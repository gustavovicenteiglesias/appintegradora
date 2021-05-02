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

import com.unsada.model.Fechaingresoingresante;
import com.unsada.model.Ingresante;
import com.unsada.service.IngresanteServiceApi;
import com.unsada.service.FechaingresoingresanteServiceApi;

@RestController
@RequestMapping(value = "/api/ingresante")
@CrossOrigin("*")
public class IngresanteController {
	@Autowired
	IngresanteServiceApi ingresanteServiceApi;
	@Autowired
	@Qualifier("service")
	FechaingresoingresanteServiceApi fechaIngresoIngresanteServiceApi;
	
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



@PostMapping(value = "/create")
public ResponseEntity<String> create(@RequestBody Ingresante data) {

	try {
		
		ingresanteServiceApi.saveingresante(data.getDni(),data.getEnSeguimiento(),data.getGrupoDeRiesgo(),data.getMail(),data.getNombre(),data.getTelefono());
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

}
