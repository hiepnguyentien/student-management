-- Active: 1720150088783@@127.0.0.1@5432@student@public
SELECT student_id, first_name, last_name, date_of_birth, management_class, batch
FROM student
JOIN management_class ON student.management_class_id = management_class.management_class_id
WHERE student.management_class_id = 1;