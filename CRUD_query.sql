-- CREATE a new employee
insert into employees(first_name, last_name, gender, birth_date, hire_date)
values ('Adi', 'Saputra', 'M', '2000-07-01', '2025-02-16');

-- GET all employees
select * from employees;

-- GET employees by emp_no
select * from employees e where e.emp_no = 1;

-- UPDATE employee by emp_no
update employees e set
first_name = 'Joko',
last_name = 'Widodo',
birth_date = '1960-06-21',
hire_date = '2025-02-21'
where e.emp_no = 2;

-- DELETE employee by emp_no
delete from employees e where e.emp_no = 12;