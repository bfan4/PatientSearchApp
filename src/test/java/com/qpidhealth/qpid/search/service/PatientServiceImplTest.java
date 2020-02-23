package com.qpidhealth.qpid.search.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.qpidhealth.qpid.search.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PatientServiceImplTest {
	
	@Autowired
	private PatientServiceImpl patientService;

    @Test
    public void testGetPatientByName() throws Exception {
        
        Patient p = patientService.getPatientByName("joe");
        System.out.println(p.getName());
        assertEquals("Joe TestPerson", p.getName());
    }
    
    @Test
    public void testGetPatientByWord() throws Exception {
    	
    	List<String> resp = patientService.getPatientByWord("2012");
    	assertEquals(1, resp.size());
    	
    }
 
}
