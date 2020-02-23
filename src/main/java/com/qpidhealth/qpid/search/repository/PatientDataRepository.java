package com.qpidhealth.qpid.search.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import com.qpidhealth.qpid.search.model.Patient;

/**
 * Created by Bo Fan on 2/22/2020.
 */

@Component
public class PatientDataRepository {
    
    public List<Patient> findAllPatients() {
        Patient p1 = new Patient();
        p1.setId(1000000L);
        p1.setName("Mary TestPerson");
        List<String> docs = new ArrayList<String>();
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_1"));
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_2"));
        p1.setDocuments(docs);
        
        Patient p2 = new Patient();
        p2.setId(1000001L);
        p2.setName("Joe TestPerson");
        List<String> docs2 = new ArrayList<String>();
        docs2.add("Clinical Note:::4/6/2010:::" + resource("Joe_1"));
        docs2.add("Summary:::7/2/2010:::" + resource("Joe_2"));
        p2.setDocuments(docs2);
        
        Patient p3 = new Patient();
        p3.setId(1000002L);
        p3.setName("Sam TestPerson");
        List<String> docs3 = new ArrayList<String>();
        docs3.add("Patient Note:::8/3/2012:::" + resource("Sam_1"));
        p3.setDocuments(docs3);
        
        List<Patient> results = new ArrayList<Patient>();
        results.add(p1);
        results.add(p2);
        results.add(p3);
        
        return results;
    }
    
    public Patient findByPatientName(String name) {
        
        Patient p1 = new Patient();
        p1.setId(1000000L);
        p1.setName("Mary TestPerson");
        List<String> docs = new ArrayList<String>();
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_1"));
        docs.add("Patient Note:::6/20/2010:::" + resource("Mary_2"));
        p1.setDocuments(docs);
        
        Patient p2 = new Patient();
        p2.setId(1000001L);
        p2.setName("Joe TestPerson");
        List<String> docs2 = new ArrayList<String>();
        docs2.add("Clinical Note:::4/6/2010:::" + resource("Joe_1"));
        docs2.add("Summary:::7/2/2010:::" + resource("Joe_2"));
        p2.setDocuments(docs2);
        
        Patient p3 = new Patient();
        p3.setId(1000002L);
        p3.setName("Sam TestPerson");
        List<String> docs3 = new ArrayList<String>();
        docs3.add("Patient Note:::8/3/2012:::" + resource("Sam_1"));
        p3.setDocuments(docs3);
        
        Map<String, Patient> map = new HashMap<String, Patient>();
        
        map.put("mary", p1);
        map.put("joe", p2);
        map.put("sam", p3);
        
        return map.get(name);
    }
    
    private static String resource(String fileName) {   
        ClassLoader classLoader = PatientDataRepository.class.getClassLoader();
        try {
            return IOUtils.toString(classLoader.getResourceAsStream("documents/"+fileName+".txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to retrieve resource "+fileName;
        }
    }
}
