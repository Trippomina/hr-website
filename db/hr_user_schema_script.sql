-- To drop a user, you need firstly to either
-- drop all artefacts owned by the user
-- revoke all privleges for user from artefacts
-- to drop everything owned by a user:
DROP OWNED BY hr_employee_manager ;
-- to revoke ownership:
REVOKE ALL PRIVILEGES ON
ALL TABLES IN SCHEMA employee_schema
FROM
hr_employee_manager ;
-- now you can drop the user
DROP USER IF EXISTS hr_employee_manager;

CREATE USER hr_employee_manager WITH PASSWORD 'hr1234';

CREATE SCHEMA IF NOT EXISTS employee_schema AUTHORIZATION hr_employee_manager;