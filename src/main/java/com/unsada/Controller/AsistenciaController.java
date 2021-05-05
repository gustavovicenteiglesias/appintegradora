package com.unsada.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unsada.model.Actividad;
import com.unsada.model.Asistenciaingresante;
import com.unsada.model.Aula;
import com.unsada.model.Fechaingresoingresante;
import com.unsada.model.Horariosactividad;
import com.unsada.model.Ingresante;
import com.unsada.service.ActividadserviceApi;
import com.unsada.service.AsistenciaIngresanteApi;
import com.unsada.service.AulaServiceApi;
import com.unsada.service.FechaServiceApi;
import com.unsada.service.FechaingresoingresanteServiceApi;
import com.unsada.service.HorariosactividadServiceApi;

@RestController
@RequestMapping(value = "/api/asistencia")
@CrossOrigin("*")

public class AsistenciaController {
	@Autowired
	AsistenciaIngresanteApi asistenciaIngresanteApi;

  @Autowired
  @Qualifier("horariosService")
  HorariosactividadServiceApi horariosService;

  @Autowired
  @Qualifier("service")
  FechaingresoingresanteServiceApi fechaIngresoService;
  
  @PostMapping(value = "/create/{idFechaIngreso}/{idHorarioActividad}")
    public ResponseEntity<String> create(@RequestBody Asistenciaingresante data, @PathVariable("idFechaIngreso") Integer idFechaIngreso,  @PathVariable("idHorarioActividad") Integer idHorarioActividad) {
        Optional<Horariosactividad> horario = horariosService.findById(idHorarioActividad);
        Optional<Fechaingresoingresante> fechaIngreso = fechaIngresoService.findById(idFechaIngreso);
        try {
            data.setHorariosactividad(horario.get());
            data.setFechaingresoingresante(fechaIngreso.get());
            asistenciaIngresanteApi.save(data);
            return new ResponseEntity<>("Save successful ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
	
	@GetMapping(value = "/all")
	public Map<String, Object> listAsistencia() {

	HashMap<String, Object> response = new HashMap<String, Object>();

	try {
    List<Asistenciaingresante> asistenciaData;
    asistenciaData = (List<Asistenciaingresante>) asistenciaIngresanteApi.findAll();
    response.put("message", "Successful load");
    response.put("data",asistenciaData);
    response.put("success", true);
    return response;
    } 
    catch (Exception e) {
      response.put("message", e.getMessage());
      response.put("success ", false);
      return response;
    }
  }

  @GetMapping(value = "/por-ingresante/{idIngresante}")
  public Map<String, Object> listAsistenciaPorIngresante(@PathVariable ("idIngresante") int idIngresante) {
  HashMap<String, Object> response = new HashMap<String, Object>();
  try {
    List<Asistenciaingresante> asistenciaData;
    asistenciaData = (List<Asistenciaingresante>) asistenciaIngresanteApi.findByIngresante(idIngresante);
    response.put("message", "Successful load");
    response.put("data",asistenciaData);
    response.put("success", true);
    return response;
    } 
    catch (Exception e) {
      response.put("message", e.getMessage());
      response.put("success ", false);
      return response;
    }
  }
  @GetMapping(value = "/por-ingresante-actividad/{idIngresante}/{idActividad}")
  public Map<String, Object> listAsistenciaPorIngresanteAndActividad(@PathVariable ("idIngresante") int idIngresante,@PathVariable ("idActividad") int idActividad ) {
  HashMap<String, Object> response = new HashMap<String, Object>();
  try {
    List<Asistenciaingresante> asistenciaData;
    asistenciaData = (List<Asistenciaingresante>) asistenciaIngresanteApi.findByIngresanteAndActividad(idIngresante, idActividad);
    response.put("message", "Successful load");
    response.put("data",asistenciaData);
    response.put("success", true);
    return response;
    } 
    catch (Exception e) {
      response.put("message", e.getMessage());
      response.put("success ", false);
      return response;
    }
  }

  @GetMapping(value = "/por-ingresante-actividad-aula/{idIngresante}/{idActividad}/{idAula}")
  public Map<String, Object> listAsistenciaPorIngresanteAndActividadAndAula(@PathVariable ("idIngresante") int idIngresante,@PathVariable ("idActividad") int idActividad, @PathVariable ("idAula") int idAula ) {
  HashMap<String, Object> response = new HashMap<String, Object>();
  try {
    List<Asistenciaingresante> asistenciaData;
    asistenciaData = (List<Asistenciaingresante>) asistenciaIngresanteApi.findByIngresanteAndActividadAndAula(idIngresante, idActividad, idAula);
    response.put("message", "Successful load");
    response.put("data",asistenciaData);
    response.put("success", true);
    return response;
    } 
    catch (Exception e) {
      response.put("message", e.getMessage());
      response.put("success ", false);
      return response;
    }
  }

  @GetMapping(value = "/por-ingresante-actividad-aula-horario/{idIngresante}/{idActividad}/{idAula}/{idHorario}")
  public Map<String, Object> listAsistenciaPorIngresanteAndActividadAndAulaAndHorario(@PathVariable ("idIngresante") int idIngresante,@PathVariable ("idActividad") int idActividad, @PathVariable ("idAula") int idAula,  @PathVariable ("idHorario") int idHorario ) {
  HashMap<String, Object> response = new HashMap<String, Object>();
  try {
    List<Asistenciaingresante> asistenciaData;
    asistenciaData = (List<Asistenciaingresante>) asistenciaIngresanteApi.findByIngresanteAndActividadAndAulaAndHorario(idIngresante, idActividad, idAula, idHorario);
    response.put("message", "Successful load");
    response.put("data",asistenciaData);
    response.put("success", true);
    return response;
    } 
    catch (Exception e) {
      response.put("message", e.getMessage());
      response.put("success ", false);
      return response;
    }
  }
  
  @GetMapping(value = "/find/{id}")
  public Map<String, Object> dataClase(@PathVariable("id") Integer id) {
  	HashMap<String, Object> response = new HashMap<String, Object>();

  	try {

  		Optional<Asistenciaingresante> clase = asistenciaIngresanteApi.findById(id);

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
  @GetMapping(value = "/find/uuid/{id}")
  public Map<String, Object> dataClase(@PathVariable("id") String id) {
  	HashMap<String, Object> response = new HashMap<String, Object>();

  	try {

  		Optional<Asistenciaingresante> clase = asistenciaIngresanteApi.findByQr(id);

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
  @PutMapping(value = "/update/{id}/{uuid}")

  public Map<String, Object> updateuuid(@PathVariable("id") Integer id,@PathVariable("uuid") String uuid, @RequestBody Asistenciaingresante data) {
    HashMap<String, Object> response = new HashMap<String, Object>();
    Optional<Asistenciaingresante> asistencia = asistenciaIngresanteApi.findById(id);
    

  	try {
  		data.setIdAsistenciaIngresante(id);
  		data.setHabilitado(data.getHabilitado());
  		data.setFechaingresoingresante(asistencia.get().getFechaingresoingresante());
      data.setHorariosactividad(asistencia.get().getHorariosactividad());
  		data.setQr(uuid);
      data.setPresente((byte) 1);
  		asistenciaIngresanteApi.save(data);
  		response.put("message", "Successful update");
  		response.put("success", true);
      response.put("nombre", asistencia.get().getFechaingresoingresante().getIngresante().getNombre());
  		return response;
  	} catch (Exception e) {
  		response.put("message", e.getMessage());
  		response.put("success", false);
  		return response;
  	}

  }
  @PutMapping(value = "/update/{id}")

  public Map<String, Object> updateuuid(@PathVariable("id") Integer id, @RequestBody Asistenciaingresante data) {

  	HashMap<String, Object> response = new HashMap<String, Object>();

  	try {
  		data.setIdAsistenciaIngresante(id);
  		
  		asistenciaIngresanteApi.save(data);
  		response.put("message", "Successful update");
  		response.put("success", true);
  		return response;
  	} catch (Exception e) {
  		response.put("message", e.getMessage());
  		response.put("success", false);
  		return response;
  	}

  }
}