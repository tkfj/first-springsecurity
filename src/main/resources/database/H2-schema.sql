CREATE TABLE account(
    username varchar(128),
    password varchar(60),
    first_name varchar(128),
    last_name varchar(128),
    company_id varchar(128),
    constraint pk_tbl_account primary key (username)
);