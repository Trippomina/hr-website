INSERT INTO leave_type (leave_type_id, leave_type_name) VALUES
('LT001', 'Annual Leave'),
('LT002', 'Sick Leave'),
('LT003', 'Maternity Leave'),
('LT004', 'Paternity Leave'),
('LT005', 'Bereavement Leave');

INSERT INTO employee (employee_id, full_name, department, email, address) VALUES
('E001', 'John Doe', 'HR', 'john.doe@example.com', '123 Main St'),
('E002', 'Jane Smith', 'Marketing', 'jane.smith@example.com', '456 Elm St'),
('E003', 'Michael Johnson', 'Finance', 'michael.johnson@example.com', '789 Oak St'),
('E004', 'Emily Davis', 'IT', 'emily.davis@example.com', '987 Pine St'),
('E005', 'David Wilson', 'Sales', 'david.wilson@example.com', '654 Cedar St');

INSERT INTO leave (leave_id, employee_id, leave_type_id, date_from, date_to, days, note) VALUES
('L001', 'E001', 'LT001', '2023-01-05', '2023-01-10', 6, 'Vacation'),
('L002', 'E002', 'LT002', '2023-02-15', '2023-02-16', 2, 'Fever'),
('L003', 'E003', 'LT003', '2023-03-20', '2023-04-05', 17, 'Maternity leave'),
('L004', 'E004', 'LT001', '2023-05-10', '2023-05-12', 3, 'Family trip'),
('L005', 'E005', 'LT002', '2023-06-01', '2023-06-05', 5, 'Flu');

INSERT INTO expense_claim (ec_id, employee_id, submission_date, description, total, status) VALUES
('EC001', 'E001', '2023-01-10', 'Office supplies', 50.00, 'Pending'),
('EC002', 'E002', '2023-02-20', 'Travel expenses', 200.00, 'Approved'),
('EC003', 'E003', '2023-03-25', 'Client dinner', 150.00, 'Approved'),
('EC004', 'E004', '2023-05-15', 'Conference registration', 300.00, 'Pending'),
('EC005', 'E005', '2023-06-05', 'Team lunch', 100.00, 'Pending');

INSERT INTO expense_claim_detail (ec_dtl_id, ec_id, submission_date, ec_type, description, total) VALUES
('ED001', 'EC001', '2023-01-10', 'Office Supplies', 'Pens, notebooks, and stapler', 30.00),
('ED002', 'EC001', '2023-01-10', 'Office Supplies', 'Printer ink cartridges', 20.00),
('ED003', 'EC002', '2023-02-20', 'Travel Expenses', 'Flight tickets', 150.00),
('ED004', 'EC002', '2023-02-20', 'Travel Expenses', 'Taxi fare', 50.00),
('ED005', 'EC003', '2023-03-25', 'Client Dinner', 'Restaurant bill', 150.00);