package com.example.hospitalmanagement;

import com.example.hospitalmanagement.dto.BloodGroupCountResponseEntity;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.entity.type.BloodGroupType;
import com.example.hospitalmanagement.repository.PatientRepository;
import com.example.hospitalmanagement.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {

        java.util.List<Patient> patientList = patientRepository.findAll();
        System.out.println((patientList));
    }


    @Test
    public void testTransactionMethods() {
        //Patient patient = patientService.getPatientById(1L);

        //List<Patient> patientList = patientRepository.findByBloodgroup(BloodGroupType.A_POSITIVE);

        //List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1988, 12, 02));

        Page<Patient> patientList = patientRepository.findAllPatient((Pageable) PageRequest.of(0, 2));

        for(Patient patient: patientList) {
            System.out.println(patient);
        }

        /*
        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
        for(Object[] objects: bloodGroupList) {
            System.out.println(objects[0] + " " + objects[1]);
        }
         */

        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
        for(BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList) {
            System.out.println(bloodGroupCountResponse);
        }
    }
}
