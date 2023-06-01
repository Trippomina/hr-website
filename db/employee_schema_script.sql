-- Drop table
DROP TABLE IF EXISTS employee CASCADE;

DROP TABLE IF EXISTS department CASCADE;

DROP TABLE IF EXISTS leave CASCADE;

DROP TABLE IF EXISTS leave_type CASCADE;

DROP TABLE IF EXISTS expense_claim_type CASCADE;

DROP TABLE IF EXISTS expense_claim CASCADE;

DROP TABLE IF EXISTS expense_claim_detail CASCADE;
-- Create department table
CREATE TABLE department (
    department_id varchar(255) NOT NULL,
    department_name varchar(255) NOT NULL,
    CONSTRAINT pk_department_department_id PRIMARY KEY (department_id)
);
-- Create leave_type table
CREATE TABLE leave_type (
    leave_type_id varchar(255) NOT NULL,
    leave_type_name varchar(255) NOT NULL,
    CONSTRAINT pk_leave_type_leave_type_id PRIMARY KEY (leave_type_id)
);
-- Create employee table
CREATE TABLE employee (
    employee_id varchar(255) NOT NULL,
    department_id varchar(255) NOT NULL,
    full_name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    CONSTRAINT pk_employee_employee_id PRIMARY KEY (employee_id),
    CONSTRAINT fk_employee_department_department_id FOREIGN KEY (department_id) REFERENCES department(department_id)
);
-- Create leave table
CREATE TABLE leave (
    leave_id varchar(255) NOT NULL,
    employee_id varchar(255) NOT NULL,
    leave_type_id varchar(255) NOT NULL,
    date_from date NOT NULL,
    date_to date NOT NULL,
    days int NOT NULL,
    note varchar(255) NULL,
    CONSTRAINT pk_leave_leave_id PRIMARY KEY (leave_id),
    CONSTRAINT fk_leave_employee_employee_id FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    CONSTRAINT fk_leave_leave_type_leave_type_id FOREIGN KEY (leave_type_id) REFERENCES leave_type(leave_type_id)
);
--create expense_type 
CREATE TABLE expense_claim_type(
	ec_type_id varchar(255) NOT NULL,
	ec_type_name varchar(255) NOT NULL,
	CONSTRAINT pk_expense_claim_type_ec_type_id PRIMARY KEY (ec_type_id)
);  
-- Create expense_claim table 
CREATE TABLE expense_claim (
	ec_id varchar(255) NOT NULL,
	employee_id varchar(255) NOT NULL,
	submition_date date NOT NULL,
	description TEXT NOT NULL,
	total numeric(10,2) NOT NULL,
	status varchar(255) NOT NULL,
	CONSTRAINT pk_expense_claim_ec_id PRIMARY KEY (ec_id),
	CONSTRAINT fk_expense_claim_employee_employee_id FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

-- Create expense_claim_detail
CREATE TABLE expense_claim_detail (
	ec_dtl_id varchar(255) NOT NULL,
	ec_id varchar(255) NOT NULL,
	submition_date date NOT NULL,
	ec_type_id varchar(255) NOT NULL,
	description TEXT NULL,
	total numeric(10,2) NOT NULL,
	CONSTRAINT pk_expense_claim_detail_ec_dtl_id PRIMARY KEY (ec_dtl_id),
	CONSTRAINT fk_expense_claim_detail_expense_claim_ec_id FOREIGN KEY (ec_id) REFERENCES expense_claim (ec_id),
	CONSTRAINT fk_expense_claim_detail_expense_claim_type_ec_type_id FOREIGN KEY (ec_type_id) REFERENCES expense_claim_type(ec_type_id)
);