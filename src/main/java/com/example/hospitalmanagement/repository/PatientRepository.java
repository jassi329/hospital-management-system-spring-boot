package com.example.hospitalmanagement.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.hospitalmanagement.dto.BloodGroupCountResponseEntity;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.entity.type.BloodGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public interface  PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodgroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate")LocalDate birthDate);

    @Query("select new com.example.hospitalmanagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, Count(p)) from Patient p group by p.bloodGroup")
    //List<Object[]> countEachBloodGroupType();
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Patient p set p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments○")
    List<Patient> findAllPatientWithAppointment();
}
