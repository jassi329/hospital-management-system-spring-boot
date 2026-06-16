TRUNCATE TABLE patient RESTART IDENTITY CASCADE;

INSERT INTO patient (name, gender, birth_date, email, blood_group)
VALUES
    ('Aarav' , 'M', '1990-05-08', 'aa@gmail.com', 'A_POSITIVE'),
    ('Diya', 'F', '2005-02-02', 'D@gmail.com', 'B_NEGATIVE'),
    ('Gaurav', 'M', '2001-05-09', 'G@gmail.com', 'O_POSITIVE'),
    ('Neha', 'F', '2005-02-10', 'n@gmail.com', 'B_POSITIVE');