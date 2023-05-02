create sequence aliment_seq start with 1 increment by 50;
create table aliment (id bigint not null, name varchar(100) not null, email_address varchar(255), primary key (id));
