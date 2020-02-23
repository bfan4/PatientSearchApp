package com.qpidhealth.qpid.search.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpidhealth.qpid.search.model.Patient;
import com.qpidhealth.qpid.search.repository.PatientDataRepository;

/**
 * Created by Bo Fan on 2/22/2020.
 */

@Service
public class PatientServiceImpl implements PatientService {

	private static final Log log = LogFactory.getLog(PatientServiceImpl.class);
	@Autowired
	PatientDataRepository patientDataRepository;

	@Override
	public Patient getPatientByName(String name) {
		Patient patient = patientDataRepository.findByPatientName(name);
		if (patient != null) {
			log.info("Search patient name: " + patient.getName());
			return patient;
		} else {
			log.info("No search result for patient name: " + name);
			return null;
		}
	}

	@Override
	public List<String> getPatientByWord(String word) {
		String n = word.toLowerCase();
		List<Patient> results = patientDataRepository.findAllPatients();
		List<String> resp = new ArrayList<String>();
		for(Patient p : results) {
			for(String s:p.getDocuments()) {
				if(s.toLowerCase().indexOf(n)!= -1) {
					resp.add(s);
				}
			}
		}
		log.info("Get patient by word count: " + resp.size());
		return resp;
	}


}
