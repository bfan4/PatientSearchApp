package com.qpidhealth.qpid.search.service;

import java.util.List;

import com.qpidhealth.qpid.search.model.Patient;

public interface PatientService {
    public Patient getPatientByName(String name);
    public List<String> getPatientByWord(String word);
}
