package com.qpidhealth.qpid.search.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qpidhealth.qpid.search.model.Patient;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PatientDataRepositoryTest {

	@Autowired
	PatientDataRepository patientDatarepository;
	
    @Test
    public void testFindByPatientName() throws Exception {
        
        Patient p = patientDatarepository.findByPatientName("mary");
        System.out.println(patientDatarepository);
        assertEquals("Mary TestPerson",p.getName());
        
    }

}
