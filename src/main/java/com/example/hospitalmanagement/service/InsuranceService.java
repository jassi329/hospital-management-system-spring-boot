package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.entity.Insurance;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.InsuranceRepository;
import com.example.hospitalmanagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    @Getter
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not fount with id:" + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); //bidirectional consistency

        return patient;
    }

    public Patient disassociationFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("patient not found with id: " + patientId));

        patient.setInsurance(null);
        return patient;
    }

}
