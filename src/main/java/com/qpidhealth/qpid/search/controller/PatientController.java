package com.qpidhealth.qpid.search.controller;

import static com.qpidhealth.qpid.search.model.SimpleResponse.success;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qpidhealth.qpid.search.model.Patient;
import com.qpidhealth.qpid.search.model.SimpleResponse;
import com.qpidhealth.qpid.search.service.PatientServiceImpl;

import io.swagger.annotations.ApiOperation;


/**
 * Created by Bo Fan on 2/22/2020.
 */

@RestController
public class PatientController {

	@Autowired
	PatientServiceImpl patientService;

	@GetMapping("/test")
	public String test() {
		return "Successful";
	}

	@GetMapping("/api/patient/{name}")
	@ApiOperation( value = "Return patient information for the given patient name", 
	response = Patient.class )
	public ResponseEntity<SimpleResponse> getPatient(@PathVariable String name) {
	    String n = name.toLowerCase();
		Patient patient = patientService.getPatientByName(n);
		return new ResponseEntity<>(success(patient), HttpStatus.OK);
		
	}
	
	@GetMapping("/api/document/{keyWord}")
	@ApiOperation( value = "Return patient information for the given key words", 
	response = List.class )
	public ResponseEntity<SimpleResponse> getDocument(@PathVariable String keyWord) {
		List<String> resp = patientService.getPatientByWord(keyWord);
		return new ResponseEntity<>(success(resp), HttpStatus.OK);
	}

}
