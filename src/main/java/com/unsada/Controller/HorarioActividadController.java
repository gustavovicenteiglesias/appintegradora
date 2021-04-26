package com.unsada.Controller;

import org.springframework.stereotype.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unsada.model.Actividad;
import com.unsada.model.Aula;
import com.unsada.model.Horariosactividad;
import com.unsada.service.ActividadServiceImpl;
import com.unsada.service.ActividadserviceApi;
import com.unsada.service.AulaServiceApi;
import com.unsada.service.HorariosactividadServiceApi;
import com.unsada.service.HorariosactividadServiceImpl;

@RestController
@RequestMapping(value = "/api/horario")
@CrossOrigin("*")
public class HorarioActividadController{
	@Autowired
	HorariosactividadServiceApi horariosServiceApi;

    @Autowired
    @Qualifier("actividadService")
    ActividadserviceApi actividadService;

    @Autowired
    @Qualifier("aulaService")
    AulaServiceApi aulaService;

    @GetMapping(value = "/all")
    public Map<String, Object> listhorarios() {
    HashMap<String, Object> response = new HashMap<String, Object>();

        try {
            List<Horariosactividad> horarioData;
            horarioData = (List<Horariosactividad>) horariosServiceApi.findAll();
            response.put("message", "Successful load");
            response.put("data",horarioData);
            response.put("success", true);
            return response;

        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success ", false);
            return response;
        }

    }
    @GetMapping(value = "/find/{id}")
	public Map<String, Object> findFechaDeIngresoPorId(@PathVariable("id") Integer id) {
		HashMap<String, Object> response = new HashMap<String, Object>();

		try {
			Optional<Horariosactividad> horario = horariosServiceApi.findById(id);

			if (horario.isPresent()) {
				response.put("message", "Successful load");
				response.put("data", horario);
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

    @GetMapping(value = "/por-actividad/{idActividad}")
    public Map<String, Object> listhorariosPorClase(@PathVariable (value = "idActividad") int idActividad) {
    HashMap<String, Object> response = new HashMap<String, Object>();

        try {
            List<Horariosactividad> horarioData;
            Optional<Actividad> actividad = actividadService.findById(idActividad);
            System.out.println(actividad.toString());
            horarioData = (List<Horariosactividad>) horariosServiceApi.findByActividad(actividad.get());
            response.put("message", "Successful load");
            response.put("data",horarioData);
            response.put("success", true);
            return response;

        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success ", false);
            return response;
        }

    }
    @GetMapping(value = "/por-actividad-y-aula/{idActividad}/{idAula}")
    public Map<String, Object> listhorariosPorAula(@PathVariable (value = "idAula") Integer idAula, @PathVariable (value = "idActividad") Integer idActividad) {
    HashMap<String, Object> response = new HashMap<String, Object>();

        try {
            List<Horariosactividad> horarioData;
            Optional<Actividad> actividad = actividadService.findById(idActividad);
            Optional<Aula> aula = aulaService.findById(idAula);
            System.out.println(aula.toString());
            horarioData = (List<Horariosactividad>) horariosServiceApi.findByActividadAndAula(idActividad, idAula);
            System.out.println(horarioData.toString());
            if(!horarioData.isEmpty()){
                response.put("message", "Successful load");
                response.put("data",horarioData);
                response.put("success", true);
            }else{
                response.put("message", "No data available");
                response.put("data",horarioData);
                response.put("success", false);
            }
            return response;

        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success ", false);
            return response;
        }

    }
}


	
