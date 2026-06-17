package com.example.hospitalmanagement;

import com.example.hospitalmanagement.entity.Appointment;
import com.example.hospitalmanagement.entity.Insurance;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.service.AppointmentService;
import com.example.hospitalmanagement.service.InsuranceService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;


    @Test
    @Transactional
    public void testInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC-1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12,30))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);

        var newPatient = insuranceService.disassociationFromPatient(patient.getId());

        System.out.println(newPatient);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDate.from(LocalDateTime.of(2026, 11, 11, 14, 30)))
                .reason("cancer")
                .build();

        var newAppointment = appointmentService.createAppointment(appointment, 1L, 2L);

        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);

        System.out.println(updatedAppointment);
    }
}
