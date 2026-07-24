DELETE FROM appointment;
DELETE FROM patient;
DELETE FROM doctor;
DELETE FROM insurance;

INSERT INTO patient (name, gender, birth_date, email, blood_group)
VALUES
    ('Aarav' , 'M', '1990-05-08', 'aa@gmail.com', 'A_POSITIVE'),
    ('Diya', 'F', '2005-02-02', 'D@gmail.com', 'B_NEGATIVE'),
    ('Gaurav', 'M', '2001-05-09', 'G@gmail.com', 'O_POSITIVE'),
    ('Neha', 'F', '2005-02-10', 'n@gmail.com', 'B_POSITIVE'),
    ('Rahul', 'M', '1998-11-12', 'rahul@gmail.com', 'O_NEGATIVE');

INSERT INTO doctor(name, specialization, email)
VALUES
    ('Dr A', 'Cardiology', 'drA@gmail.com'),
    ('Dr B', 'Dermatology', 'drB@gmail.com'),
    ('Dr C', 'Orthopedics', 'drC@gmail.com');

INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
    ('2025-07-01', 'General Checkup', 1, 2),
    ('2025-07-02', 'Skin Rash', 2, 2),
    ('2025-07-03', 'Knee Pain', 3, 3),
    ('2025-07-04', 'Follow-up Visit', 1, 1),
    ('2025-07-05', 'Consultation', 1, 4),
    ('2025-07-06', 'Allergy Treatment', 2, 1);
