package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.entity.Appointment;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.AppointmentRepository;
import com.example.hospitalmanagement.repository.DoctorRepository;
import com.example.hospitalmanagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("appointment should not have");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointmentRepository.save(appointment);

    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not fount: " + appointmentId));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not fount: " + doctorId));

        appointment.setDoctor(doctor);

        return appointment;
    }
}
