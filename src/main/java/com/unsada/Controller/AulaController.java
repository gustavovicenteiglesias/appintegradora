package com.unsada.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.unsada.model.Aula;
import com.unsada.service.AulaServiceApi;

@RestController
@RequestMapping(value = "/api/aula")
@CrossOrigin("*")

public class AulaController {
	@Autowired
	AulaServiceApi aulaServiceApi;
	
	@GetMapping(value = "/all")
	public Map<String, Object> listclase() {

	HashMap<String, Object> response = new HashMap<String, Object>();

	try {
		List<Aula> claseData;
		claseData = (List<Aula>) aulaServiceApi.findAll();
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

		Optional<Aula> clase = aulaServiceApi.findById(id);
		System.out.println(clase.get().getCapacidad()+"Capacidad");
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
}
