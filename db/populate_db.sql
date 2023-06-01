-- Insert basic leave types into the leave_type table
INSERT INTO leave_type (leave_type_id, leave_type_name)
VALUES
    ('VAC', 'Vacation Leave'),
    ('SICK', 'Sick Leave'),
    ('MAT', 'Maternity/Paternity Leave'),
    ('BEREAV', 'Bereavement Leave'),
    ('PH', 'Public Holidays'),
    ('UNPAID', 'Unpaid Leave');  
 -- Insert departments into the department table
INSERT INTO department (department_id, department_name)
VALUES
    ('HR', 'Human Resources'),
    ('IT', 'Information Technology'),
    ('SALES', 'Sales');
 -- Insert employees into the employee table
INSERT INTO employee (employee_id, department_id, full_name, email, address)
VALUES
    ('EMP1', 'HR', 'Ahmed Abdullah', 'ahmed@example.com', 'Riyadh'),
    ('EMP2', 'IT', 'Mohammed Al-Shammari', 'mohammed@example.com', 'Jeddah'),
    ('EMP3', 'SALES', 'Nora Al-Harbi', 'nora@example.com', 'Dammam'),
    ('EMP4', 'HR', 'Fatima Al-Marzouq', 'fatima@example.com', 'Riyadh'),
    ('EMP5', 'IT', 'Ali Al-Otaibi', 'ali@example.com', 'Jeddah'),
    ('EMP6', 'SALES', 'Layla Al-Qahtani', 'layla@example.com', 'Dammam'),
    ('EMP7', 'HR', 'Mahmoud Al-Aqeel', 'mahmoud@example.com', 'Riyadh'),
    ('EMP8', 'IT', 'Saleh Al-Ghamdi', 'saleh@example.com', 'Jeddah'),
    ('EMP9', 'SALES', 'Sara Khalid', 'sara@example.com', 'Dammam'),
    ('EMP10', 'HR', 'Omar Ahmed', 'omar@example.com', 'Riyadh'),
    ('EMP11', 'IT', 'Lina Hasan', 'lina@example.com', 'Jeddah'),
    ('EMP12', 'SALES', 'Yousef Al-Mansour', 'yousef@example.com', 'Dammam'),
    ('EMP13', 'HR', 'Hala Al-Faris', 'hala@example.com', 'Riyadh'),
    ('EMP14', 'IT', 'Nasser Saleh', 'nasser@example.com', 'Jeddah'),
    ('EMP15', 'SALES', 'Maha Al-Qahtani', 'maha@example.com', 'Dammam');
 -- Insert expense types into the expense_claim_type table 
INSERT INTO expense_claim_type (ec_type_id, ec_type_name)
VALUES
   ('hotel', 'Hotel expense'),
   ('car_rental', 'Car rental expense');
   