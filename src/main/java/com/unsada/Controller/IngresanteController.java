package com.unsada.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unsada.model.Asistenciaingresante;
import com.unsada.model.Fechaingresoingresante;
import com.unsada.model.Ingresante;
import com.unsada.service.IngresanteServiceApi;
import com.unsada.util.QrCreatorService;
import com.unsada.service.AsistenciaIngresanteApi;
import com.unsada.service.FechaingresoingresanteServiceApi;
import com.unsada.service.HorariosactividadServiceApi;

@RestController
@RequestMapping(value = "/api/ingresante")
@CrossOrigin("*")
public class IngresanteController {
	@Autowired
	IngresanteServiceApi ingresanteServiceApi;

	@Autowired
	@Qualifier("service")
	FechaingresoingresanteServiceApi fechaIngresoIngresanteServiceApi;

	@Autowired
	@Qualifier("horariosService")
	HorariosactividadServiceApi horariosServiceApi;

	@Autowired
	@Qualifier("asistenciaService")

	AsistenciaIngresanteApi asistenciaService;
	
	@GetMapping(value = "/all")
	public Map<String, Object> listclase() {

	HashMap<String, Object> response = new HashMap<String, Object>();

	try {
		List<Ingresante> claseData;
		claseData = (List<Ingresante>) ingresanteServiceApi.findAll();
		response.put("message", "Successful load");
		response.put("data",claseData);
		response.put("success", true);
		return response;

	} catch (Exception e) {
		response.put("message", e.getMessage());
		response.put("success ", false);
		return response;
	}

}
	
@GetMapping(value = "/find/{id}")
public Map<String, Object> dataClase(@PathVariable("id") Integer id) {
	HashMap<String, Object> response = new HashMap<String, Object>();

	try {
		Optional<Ingresante> clase = ingresanteServiceApi.findById(id);

		if (clase.isPresent()) {
			response.put("message", "Successful load");
			response.put("data", clase);
			response.put("success", true);
			return response;
		} else {
			response.put("message", "Not found data");
			response.put("data", null);
			response.put("success", false);
			return response;
		}

	} catch (Exception e) {
		response.put("message", "" + e.getMessage());
		response.put("success", false);
		return response;
	}
}



@PostMapping(value = "/create/{idHorario}/")
public ResponseEntity<String> create(@RequestBody Ingresante data,@PathVariable("idHorario") int idHorario, @RequestParam(value="fechaingreso") @DateTimeFormat(pattern="yyyy-MM-dd") Date fechaIngreso, RedirectAttributes ra) {

	try {
		Ingresante searchByDni = ingresanteServiceApi.findByDni(data.getDni());
		if (searchByDni == null){
			ingresanteServiceApi.saveingresante(data.getDni(),data.getEnSeguimiento(),data.getGrupoDeRiesgo(),data.getMail(),data.getNombre(),data.getTelefono());
			System.out.println ("not repeated");
		}else{
			System.out.println("repeated");

		}
		int idFechaCreada = nuevaFechaDeIngreso(fechaIngreso, data.getDni());
		nuevoRegistroDeAsistencia(idFechaCreada, idHorario);

		return new ResponseEntity<>("Save successful ", HttpStatus.OK);

	} catch (Exception e) {
		
		return new ResponseEntity<>("" + e, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

@PutMapping(value = "/update/{id}")

public Map<String, Object> update(@PathVariable("id") Integer id, @RequestBody Ingresante data) {

	HashMap<String, Object> response = new HashMap<String, Object>();

	try {
		data.setIdIngresante(id);;
		ingresanteServiceApi.update(id,
				data.getDni(), data.getEnSeguimiento(),
				data.getGrupoDeRiesgo(), data.getMail(),
				data.getNombre(), data.getTelefono(), id);;
		response.put("message", "Successful update");
		response.put("success", true);
		return response;
	} catch (Exception e) {
		response.put("message", e.getMessage());
		response.put("success", false);
		return response;
	}

}



@DeleteMapping(value = "/delete/{id}")

public Map<String, Object> update(@PathVariable("id") Integer id) {
	HashMap<String, Object> response = new HashMap<String, Object>();
	try {
		ingresanteServiceApi.deleteById(id);
		;
		response.put("message", "Successful delete");
		response.put("success", true);
		return response;
	} catch (Exception e) {
		response.put("message", e.getMessage());
		response.put("success", false);
		return response;
	}

}
@PostMapping(value = "/nueva-fecha-ingreso/{idIngresante}")
public ResponseEntity<String> nuevaFechaDeIngreso(@PathVariable("idIngresante") Integer id, @RequestBody Fechaingresoingresante fechaIngreso)  {

	try {
		Optional<Ingresante> ingresante = ingresanteServiceApi.findById(id);
		String fecha = fechaIngreso.getFecha().toString();
		System.out.println("fecha es:" + fecha);
		fechaIngresoIngresanteServiceApi.saveFechaIngresoIngresante(parseDate(fechaIngreso.getFecha()), ingresante.get().getIdIngresante());
		return new ResponseEntity<>("Success", HttpStatus.OK);
	
	} catch (Exception e) {
		return new ResponseEntity<>("" + e, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
@GetMapping(value = "/find-fecha-ingreso/{id}")
public Map<String, Object> findFechaDeIngreso(@PathVariable("id") Integer id) {
	HashMap<String, Object> response = new HashMap<String, Object>();
	try {
		Optional<Fechaingresoingresante> fecha = fechaIngresoIngresanteServiceApi.findById(id);

		if (fecha.isPresent()) {
			response.put("message", "Successful load");
			response.put("data", parseDateWithHours(fecha.get().getFecha().toString()));
			response.put("success", true);
			return response;
		} else {
			response.put("message", "Not found data");
			response.put("data", null);
			response.put("success", false);
			return response;
		}
	} catch (Exception e) {
		response.put("message", "" + e.getMessage());
		response.put("success", false);
		return response;
	}
}

private String parseDate(Date date){
	SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	String dateString = format.format(date);
	System.out.println("formatted is now" + dateString);
	return dateString;

}
private String parseDateWithHours(String dateAsString){
	SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    try {
		Date date = dt.parse(dateAsString);
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        return (dt1.format(date));

	} catch (ParseException e) {
		e.printStackTrace();
	}
	return null;
}
//Obtiene el ingresante por DNI, si el registro no existe para esa fecha lo crea. Retorna el id de la fecha creada
private int nuevaFechaDeIngreso(@DateTimeFormat(pattern="yyyy-MM-dd") Date fechaIngreso, String dni){
	Ingresante ingresante = ingresanteServiceApi.findByDni(dni);
	List<Fechaingresoingresante> fechas = fechaIngresoIngresanteServiceApi.findByIngresante(ingresante);
	Fechaingresoingresante fechaIngresoIngresante= new Fechaingresoingresante();
	fechaIngresoIngresante.setFecha(fechaIngreso);
	fechaIngresoIngresante.setIngresante(ingresante);
	int getIdFecha = fechaIsPresent(fechas, fechaIngreso);
	if(getIdFecha == 0 ){
		return(fechaIngresoIngresanteServiceApi.save(fechaIngresoIngresante).getIdFechaIngresante());
	}else{
		return getIdFecha;
	}

}
private void nuevoRegistroDeAsistencia(int idFechaCreada, int idHorario){
	Asistenciaingresante asistencia = new Asistenciaingresante();
	try {
		asistencia.setFechaingresoingresante(fechaIngresoIngresanteServiceApi.findById(idFechaCreada).get());
		asistencia.setHorariosactividad(horariosServiceApi.findById(idHorario).get());
		asistencia.setPresente((byte) 1);
		asistencia.setHabilitado((byte) 1);
		asistencia.setQr(QrCreatorService.generateQrId());

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Error cargando datos");

	}
	try {
		asistenciaService.save(asistencia);

	} catch (Exception e) {
		System.out.println("Error creando el registro");
	}

}

private int fechaIsPresent(List<Fechaingresoingresante> fechas, Date fechaIngreso) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	for (Fechaingresoingresante fechaingresoingresante : fechas) {
		Date dbTime = fechaingresoingresante.getFecha();
		try {
			Date date = format.parse(dbTime.toString());
			if(date.equals(fechaIngreso)){
				System.out.println("this is the same");
				return fechaingresoingresante.getIdFechaIngresante();
			}else{
				System.out.println("not the same");
			}
		} catch (ParseException e) {
			System.out.println("error fecha format");
			e.printStackTrace();
		}
	}
	return 0;
}

}
