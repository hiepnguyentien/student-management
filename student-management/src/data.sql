-- Active: 1720150088783@@127.0.0.1@5432@student@public
use student;

INSERT INTO faculty (faculty_id, faculty_name) VALUES
    (nextval('faculty_sequence'), 'Công Nghệ Thông Tin'),
    (nextval('faculty_sequence'), 'Xây Dựng'),
    (nextval('faculty_sequence'), 'Kinh Tế'),
    (nextval('faculty_sequence'), 'Khoa Học Máy Tính');

INSERT INTO subject (subject_id, name, credit, description)
VALUES
    (nextval('subject_sequence'), 'Tin học đại cương', 3, 'lập trình cơ bản với C, C++'),
    (nextval('subject_sequence'), 'Ngôn ngữ C++', 3, 'lập trình với ngôn ngữ c++'),
    (nextval('subject_sequence'), 'Phương pháp lập trình HĐT', 3, 'lập trình hướng đối tượng qua Java'),
    (nextval('subject_sequence'), 'Kinh tế vĩ mô', 2, 'kinh tế vĩ mô toàn cầu'),
    (nextval('subject_sequence'), 'Toán học tính toán', 2, 'lập trình xử lí toán học với Python/Mathematica'),
    (nextval('subject_sequence'), 'Triết học Mác-Lenin', 3, 'triết học Mác - Lênin'),
    (nextval('subject_sequence'), 'Chủ Nghĩa XHKH', 2, 'Chủ nghĩa xã hội khoa học'),
    (nextval('subject_sequence'), 'Lập trình linux', 2, 'làm quen với nhân linux và các distro từ nó'),
    (nextval('subject_sequence'), 'Phần mềm nguồn mở', 3, 'tận dụng cộng đồng mã nguồn mở trên toàn thế giới'),
    (nextval('subject_sequence'), 'Toán Rời Rạc', 3, 'Toán rời rạc');

INSERT INTO lecturer (lecturer_id, first_name, last_name, gender, date_of_birth, address, email, phone_number, faculty_id)
VALUES
    (nextval('lecturer_sequence'), 'Nguyễn Văn', 'An', 'nam', '1990-01-01', '1, 3, Quang Trung, Hà Đông', 'nguyenvanan@huce.edu.vn', '0123456789', 1),
    (nextval('lecturer_sequence'), 'Nguyễn Thị', 'Bình', 'nữ', '1991-02-02', '1, Thành Công, Quang Trung, Ha Đông', 'nguyenthibinh@huce.edu.vn', '0987654321', 2),
    (nextval('lecturer_sequence'), 'Trần Văn', 'Cường', 'nam', '1992-03-03', '1, Nguyễn Trãi, Thanh Xuân', 'tranvancuong@huce.edu.vn', '0369841527', 3),
    (nextval('lecturer_sequence'), 'Lê Thị', 'Dung', 'nữ', '1993-04-04', '2, Hoàng Diệu, Ba Đình', 'lethidung@huce.edu.vn', '0765214896', 2),
    (nextval('lecturer_sequence'), 'Hoàng Thị', 'Hoa', 'nữ', '1995-06-06', '9, Nguyễn Chí Thanh, Đống Đa', 'hoangthihoa@huce.edu.vn', '0932154876', 4),
    (nextval('lecturer_sequence'), 'Đặng Văn', 'Khoa', 'nam', '1996-07-07', '12, Trường Chinh, Thanh Xuân', 'dangvankhoa@huce.edu.vn', '0852145632', 1),
    (nextval('lecturer_sequence'), 'Mai Thị', 'Lan', 'nữ', '1997-08-08', '8, Lê Duẩn, Hoàn Kiếm', 'maithilan@huce.edu.vn', '0945632154', 3),
    (nextval('lecturer_sequence'), 'Nguyễn Thị', 'Nga', 'nữ', '1999-10-10', '15, Hoàng Quốc Việt, Cầu Giấy', 'nguyenthinga@huce.edu.vn', '0978654123', 3);
INSERT INTO subject_class (subject_class_id, name, subject_id, lecturer_id)
VALUES
    (nextval('subject_class_sequence'), 'PM1', 1, 1),
    (nextval('subject_class_sequence'), 'PM2', 1, 1),
    (nextval('subject_class_sequence'), 'PM3', 2, 2),
    (nextval('subject_class_sequence'), 'PM4', 4, 2),
    (nextval('subject_class_sequence'), 'PM5', 4, 3),
    (nextval('subject_class_sequence'), 'CS1', 6, 3),
    (nextval('subject_class_sequence'), 'CS2', 7, 4),
    (nextval('subject_class_sequence'), 'CS3', 6, 4),
    (nextval('subject_class_sequence'), 'CS4', 7, 5),
    (nextval('subject_class_sequence'), 'CS5', 6, 5),
    (nextval('subject_class_sequence'), 'HKC1', 7, 6),
    (nextval('subject_class_sequence'), 'HCK2', 7, 6),
    (nextval('subject_class_sequence'), 'HCK3', 1, 7),
    (nextval('subject_class_sequence'), 'HCK4', 9, 8),
    (nextval('subject_class_sequence'), 'HCK5', 2, 7),
    (nextval('subject_class_sequence'), 'MHT1', 3, 8),
    (nextval('subject_class_sequence'), 'MHT2', 5, 8),
    (nextval('subject_class_sequence'), 'MHT3', 7, 8),
    (nextval('subject_class_sequence'), 'MHT4', 10, 1);


INSERT INTO management_class (management_class_id, lecturer_id, name, faculty_id)
VALUES
    (nextval('management_class_sequence'),3, '66IT1', 1),
    (nextval('management_class_sequence'),1, '66IT3', 1),
    (nextval('management_class_sequence'),6, '66IT5', 1),
    (nextval('management_class_sequence'),5, '66KT1', 3),
    (nextval('management_class_sequence'),8, '66KT2', 3),
    (nextval('management_class_sequence'),7, '66KT5', 3),
    (nextval('management_class_sequence'),2, '66XD1', 2),
    (nextval('management_class_sequence'),4, '66XD5', 2);

INSERT INTO student (student_id, first_name, last_name, gender, date_of_birth, address, email, phone_number, enroll_date, management_class_id)
    VALUES
    (nextval('student_sequence'),'Hoàng Quang', 'Sinh', 'nam', '1990-01-01', '1, 3, Quang Trung, Hà Đông', 'hoangquangsinh@huce.edu.vn', '0123456789', '2021-01-01', 1),
    (nextval('student_sequence'),'Nguyễn Văn', ' An', 'nam', '1992-05-10', '1, Thành Công, Quang Trung, Hà Đông', 'nguyenvanan1@huce.edu.vn', '0987654321', '2022-01-03', 1),
    (nextval('student_sequence'),'Lê Thị', ' Hương', 'nữ', '1991-07-15', '1, Nguyễn Trãi, Thanh Xuân', 'lethihuong@huce.edu.vn', '0123412345', '2022-09-01', 2),
    (nextval('student_sequence'),'Trần Văn', ' Quân', 'nam', '1990-09-20', '2, Hoàng Diệu, Ba Đình', 'tranvanquan@huce.edu.vn', '0567891234', '2022-01-02', 2),
    (nextval('student_sequence'),'Phạm Thị', ' Mai', 'nữ', '1993-03-05', '5, Trường Chinh, Hai Bà Trưng', 'phamthimai@huce.edu.vn', '0932145678', '2023-01-03', 2),
    (nextval('student_sequence'),'Đỗ Quốc', ' Bảo', 'nam', '1992-11-18', '7, Lê Duẩn, Hoàn Kiếm', 'doquocbao@huce.edu.vn', '0978654321', '2021-01-01', 3),
    (nextval('student_sequence'),'Nguyễn Thị', ' Hạnh', 'nữ', '1990-06-30', '10, Lý Thường Kiệt, Đống Đa', 'nguyenthihanh@huce.edu.vn', '0123678901', '2021-12-29', 3),
    (nextval('student_sequence'),'Trương Minh', ' Đức', 'nam', '1991-04-25', '15, Huỳnh Thúc Kháng, Đống Đa', 'truongminhduc@huce.edu.vn', '0987123456', '2022-05-13', 4),
    (nextval('student_sequence'),'Lê Thị', ' Ngọc', 'nữ', '1993-08-12', '20, Phạm Hùng, Cầu Giấy', 'lethingoc@huce.edu.vn', '0956789123', '2022-09-18', 4),
    (nextval('student_sequence'),'Vũ Văn', ' Tuấn', 'nam', '1991-02-15', '25, Trần Phú, Hà Đông', 'vuvantuan@huce.edu.vn', '0912345678', '2021-10-08', 4);

INSERT INTO score (score_id, student_id, subject_class_id, attendance_score, mid_term_score, end_term_score, semester)
VALUES
    (nextval('score_sequence'), 1, 1, 9.0, 8.5, 9.0, 1),
    (nextval('score_sequence'), 1, 2, 8.0, 7.5, 8.0, 2),
    (nextval('score_sequence'), 2, 3, 9.5, 9.0, 9.5, 3),
    (nextval('score_sequence'), 2, 4, 8.5, 8.0, 8.5, 1),
    (nextval('score_sequence'), 3, 5, 7.0, 7.5, 8.0, 2),
    (nextval('score_sequence'), 3, 6, 8.5, 9.0, 8.5, 3),
    (nextval('score_sequence'), 4, 7, 9.0, 9.0, 9.0, 1),
    (nextval('score_sequence'), 4, 8, 7.5, 8.0, 7.5, 2),
    (nextval('score_sequence'), 5, 9, 8.0, 8.0, 8.0, 3),
    (nextval('score_sequence'), 5, 1, 9.5, 9.5, 9.5, 1),
    (nextval('score_sequence'), 6, 1, 6.0, 7.0, 7.5, 2),
    (nextval('score_sequence'), 6, 2, 7.5, 8.0, 7.0, 3),
    (nextval('score_sequence'), 7, 3, 9.0, 8.5, 9.0, 1),
    (nextval('score_sequence'), 7, 4, 8.0, 8.0, 8.0, 2),
    (nextval('score_sequence'), 8, 5, 7.0, 7.0, 7.0, 3),
    (nextval('score_sequence'), 8, 6, 6.5, 7.5, 7.0, 1),
    (nextval('score_sequence'), 9, 7, 8.5, 8.5, 8.5, 2),
    (nextval('score_sequence'), 9, 8, 9.0, 9.0, 9.0, 3),
    (nextval('score_sequence'), 10, 9, 7.5, 8.0, 7.5, 1),
    (nextval('score_sequence'), 10, 1, 8.0, 8.5, 8.0, 2);

        -- (1, 1, 0, 0, 0, 2, 'hoc lai lan 1'),
        -- (2, 2, 0, 0, 0, 1, ''),
        -- (2, 3, 0, 0, 0, 1, ''),
        -- (2, 4, 0, 0, 0, 2, 'vi pham quy che'),
        -- (2, 5, 0, 0, 0, 3, ''),
        -- (5, 6, 0, 0, 0, 3, ''),
        -- (7, 7, 0, 0, 0, 4, ''),
        -- (10, 8, 0, 0, 0, 5, ''),
        -- (4, 9, 0, 0, 0, 5, ''),
        -- (8, 10, 0, 0, 0, 5, '');


INSERT INTO subject_faculty (faculty_id, subject_id) 
VALUES  (1, 1),
        (1, 2),
        (1, 3),
        (1, 5),
        (1, 6),
        (1, 7),
        (1, 8),
        (1, 9),
        (1, 10),
        (2, 6),
        (2, 7),
        (3, 4),
        (3, 6),
        (3, 7),
        (4, 1),
        (4, 2),
        (4, 3),
        (4, 5),
        (4, 6),
        (4, 7),
        (4, 8),
        (4, 10);