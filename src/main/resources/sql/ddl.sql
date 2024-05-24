
create table student
(
    id           bigserial
        primary key,
    address      varchar(255),
    averagescore real,
    email        varchar(255),
    name         varchar(255),
    phone        varchar(255),
    recordbook   integer
);



create table student
(
    id           bigserial
        primary key,
    address      varchar(255),
    averagescore real,
    email        varchar(255),
    name         varchar(255),
    phone        varchar(255),
    recordbook   integer
);



create table course
(
    id     bigserial
        primary key,
    cost   real,
    number integer,
    title  varchar(255)
);



create table professor_course
(
    id           bigserial
        primary key,
    course_id    bigint
        constraint fk9vav1h7efyrufkde29cgs2jc0
            references course,
    professor_id bigint
        constraint fkngc752gy9764vvb40di6lause
            references professor
);



create table course_completion
(
    id         bigserial
        primary key,
    finalscore integer,
    score      integer,
    course_id  bigint not null
        constraint fkh64rg9wsqb5cw6ab6i6npdtne
            references course,
    student_id bigint not null
        constraint fk81usaclfa4dnrhb2sm31ycypg
            references student
);



create table coursecompletion_grades
(
    coursecompletion_id bigint not null
        constraint fk13ygyi3hyl0dvov5ov3na0194
            references course_completion,
    grades              integer
);


