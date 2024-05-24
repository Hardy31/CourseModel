

INSERT INTO public.student (address, averagescore, email, name, phone, recordbook)
VALUES ('address студент1', null, 'emailстудент1', 'nameстудент1', 'phoneстудент1', 101),
       ('address студент2', null, 'emailстудент2', 'nameстудент2', 'phoneстудент2', 102),
       ('address студент3', null, 'emailстудент3', 'nameстудент3', 'phoneстудент3', 103),
       ('address студент4', null, 'emailстудент4', 'nameстудент4', 'phoneстудент4', 104),
       ('address студент5', null, 'emailстудент5', 'nameстудент5', 'phoneстудент5', 105);



INSERT INTO public.course (title, number, cost )
VALUES ('IT',  101, 12000.1),
       ('QA',  102, 11000.2),
       ('AI',  103, 15000.3),
       ('HR',  104, 10000.4),
       ('DV',  105, 11000.5);



INSERT INTO public.professor (name, address, phone, payment )
VALUES ('Профессор1',  'адресс1', 'телефон1', 100000.1),
       ('Профессор2',  'адресс2', 'телефон2', 102000.2),
       ('Профессор3',  'адресс3', 'телефон3', 103000.3),
       ('Профессор4',  'адресс4', 'телефон4', 104000.4),
       ('Профессор5',  'адресс5', 'телефон5', 105000.5);

INSERT INTO public.professor_course (course_id, professor_id )
VALUES (1, 1),
       (2, 2),
       (3, 1),
       (4, 3),
       (5, null);



INSERT INTO public.course_completion ( course_id, student_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (3, 1),
       (3, 3),
       (4, 4);





INSERT INTO public.coursecompletion_grades ( coursecompletion_id, grades)
    VALUES (1, 3),
    (1, 3),
    (1, 3),
    (2, 4),
    (2, 4),
    (2, 4),
    (2, 4),
    (2, 4),
    (3, 4),
    (3, 5),
    (3, 4),
    (3, 5);


