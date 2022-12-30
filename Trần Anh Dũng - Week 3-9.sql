-- Bai 1 -- CREATE PROCEDURE
-- 1.1: Tao thu tuc DEPT_INFO
CREATE OR REPLACE PROCEDURE "DEPT_INFO"
(
    departmentId IN NUMBER
)
IS
    departmentINFO departments%rowtype;
BEGIN
    SELECT * INTO departmentINFO FROM departments dp
    WHERE (1=1) and dp.department_id = departmentId;
    
    dbms_output.put_line('departmentID: ' || departmentINFO.department_id || ' name: ' || departmentINFO.department_name || ' manager_id: ' || departmentINFO.manager_id || ' location_id: ' || departmentINFO.location_id);
EXCEPTION
    when no_data_found then
        dbms_output.put_line('No department found');
END;

BEGIN
    dept_info(20); 
END;

-- 1.2: Tao thu tuc ADD_JOB
CREATE OR REPLACE PROCEDURE "ADD_JOB"
(
    jobID IN VARCHAR2,
    jobName IN VARCHAR2
)
IS BEGIN
    INSERT INTO JOBS values(jobID,jobName,0,0);
    EXCEPTION
        When dup_val_on_index then
            rollback;
            dbms_output.put_line('Triggered roll back');
END;
begin
    add_job('DL_R','Delivery');
end;

-- 1.3: Tao thu tuc UPDATE_COMM
CREATE OR REPLACE PROCEDURE "UPDATE_COMM"
(
    commID IN NUMBER
)
IS
    com_num number;
BEGIN
        select commission_pct into com_num
        from employees emp
        where emp.employee_id = commID;
        if(com_num is null) then com_num := 0;
        end if;
        com_num := com_num * 5/100;
        UPDATE EMPLOYEES emp
        SET emp.COMMISSION_PCT = emp.COMMISSION_PCT + (emp.COMMISSION_PCT * 5 / 100)
        WHERE emp.EMPLOYEE_ID = commID;
        dbms_output.put_line('Updated');
    EXCEPTION
        when no_data_found then
            dbms_output.put_line('No data found');
    END;
DECLARE
    emp_id number(6,0);
BEGIN
    emp_id := 101;
    --AFTER UPDATE
    update_comm(emp_id);
END;

-- 1.4: Tao thu tuc ADD_EMP
CREATE OR REPLACE PROCEDURE "ADD_EMP"
(
    empID IN NUMBER,
    firstName IN VARCHAR2,
    lastName IN VARCHAR2,
    email_add IN VARCHAR2,
    phoneNumber IN VARCHAR2,
    hireDate IN DATE,
    jobID IN VARCHAR2,
    salary_add IN NUMBER,
    commPCT IN NUMBER,
    managerID IN NUMBER,
    departmentID IN NUMBER
)
IS BEGIN
    INSERT INTO EMPLOYEES VALUES(empID,firstName,lastName,email_add,phoneNumber,hireDate,jobID,salary_add,commPCT,managerID,departmentID);
    EXCEPTION
        when dup_val_on_index then
            rollback;
            dbms_output.put_line('Triggered roll back');
    END;
BEGIN
    add_emp(206,'TRAN', 'ANH DUNG','kudung053@gmail.com','0335240370',TO_DATE('30-SEP-2022'), 'IT_PROG', 30000,null,103,60);
END;

-- 1.5: Tao thu tuc DELETE_EMP
CREATE OR REPLACE PROCEDURE "DELETE_EMP"
(
    empID IN NUMBER
)
IS BEGIN
    DELETE FROM EMPLOYEES emp
    WHERE emp.EMPLOYEE_ID = empID;
END;

-- 1.6: Tao thu tuc FIND_EMP
CREATE OR REPLACE PROCEDURE "FIND_EMP"
IS
    CURSOR get_emp is
        SELECT emp.first_name, emp.employee_id
        FROM employees emp, jobs jb
        WHERE (1=1) and((emp.SALARY > jb.MIN_SALARY) and (emp.SALARY < jb.MAX_SALARY)) and (emp.JOB_ID = jb.JOB_ID);
    BEGIN
    for r_emp in get_emp
    LOOP
        dbms_output.put_line(r_emp.employee_id || ' - ' || r_emp.first_name);
    END LOOP;
    EXCEPTION
        when no_data_found then
            DBMS_OUTPUT.PUT_LINE('No data found');    
END;
begin
        find_emp;
END;

-- 1.7: Tao thu tuc update_comm
CREATE OR REPLACE PROCEDURE "UPDATE_COMM"
IS
    work_time number(8,2);
    salary_update number;
    cursor get_info
    is select emp.employee_id, emp.hire_date, emp.salary from employees emp;
BEGIN
    for r_info in get_info
    loop
        salary_update := r_info.salary;
        work_time := (months_between(trunc(sysdate), trunc(r_info.hire_date)) / 12);
        
        if(work_time >= 2) then salary_update := salary_update + 200;
        elsif(work_time > 1 and work_time < 2) then salary_update := salary_update + 100;
        else salary_update := salary_update + 50;
        end if;
        
        UPDATE employees
        SET salary = salary_update
        WHERE employee_id = r_info.employee_id;
    end loop;
        dbms_output.put_line('Updated');
    EXCEPTION
        when no_data_found then
             dbms_output.put_line('No data found');
END;
BEGIN
    update_comm;
END;

-- 1.8: Tao thu tuc JOB_HIS
CREATE OR REPLACE PROCEDURE "JOB_HIS"(emp_id IN number)
IS 
    cursor get_his
    is SELECT jb.employee_id, jb.start_date, jb.end_date
    from job_history jb
    where jb.employee_id = emp_id;
BEGIN
    for r_his_job in get_his
    loop
        dbms_output.put_line('Employee ID:' || r_his_job.employee_id || ' - START DATE: ' || r_his_job.start_date || ' - END DATE: ' || r_his_job.end_date);
    end loop;
    EXCEPTION
        when no_data_found then
            dbms_output.put_line('No Data Found');
END;
BEGIN
    job_his(102);
END;

-- BAI 2: CREATE FUNCTION
-- 2.1: TAO HAM SUM_SALARY
CREATE OR REPLACE FUNCTION sum_salary(depart_id number)
return number
is
    total number := 0;
begin
    select sum(emp.salary)into total from employees emp
    where emp.department_id = depart_id;
    if total = 0 then return 0;
    else return total;
    end if;
end;
begin
    dbms_output.put_line(sum_salary(10));
end;

--2.2: TAO HAM NAME_CON
CREATE OR REPLACE FUNCTION name_con(coun_id varchar2)
return varchar2
is
    name_con varchar2(40);
begin
    select ct.country_name into name_con 
    from countries ct
    where ct.country_id = coun_id;
    return name_con;
EXCEPTION
    when no_data_found then
        dbms_output.put_line('No country was found');
end;
begin
    dbms_output.put_line(name_con('AR'));
end;

--2.3: TAO HAM ANNUAL_COMP
CREATE OR REPLACE FUNCTION annual_comp(income_monthly number, commission number)
return number
IS
    annual_income number := 0;
BEGIN
    annual_income := income_monthly*12 + (commission * income_monthly * 12);
    return annual_income;
END;
BEGIN
    dbms_output.put_line('Annual income: ' || annual_comp(200,0.5));
END;

--2.4: TAO HAM AVG_SALARY
CREATE OR REPLACE FUNCTION avg_salary(depart_id number)
return number
IS
    avg_salary number := 0;
BEGIN
    select avg(emp.salary) into avg_salary
    from employees emp
    where emp.department_id = depart_id;
    return avg_salary;
END;
BEGIN
    dbms_output.put_line(avg_salary(90));
END;

--2.3: TAO HAM TIME_WORK
CREATE OR REPLACE FUNCTION time_work(emp_id number)
return number
IS
    month_work number(8,2);
BEGIN
    select months_between(trunc(sysdate), trunc(hire_date)) into month_work
    from employees
    where employee_id = emp_id;
    return month_work;
EXCEPTION
    when no_data_found then
        dbms_output.put_line('No employee was found');
END;
BEGIN
    dbms_output.put_line(time_work(100));
END;

--Bai 3: LENH CREATE TRIGGER
-- 3.1: RANG BUOC NGAY THUE NHAN VIEN
CREATE OR REPLACE TRIGGER date_hire_emp
BEFORE INSERT or UPDATE
ON employees
FOR EACH ROW
DECLARE
BEGIN
    if(trunc(sysdate) >= trunc(:new.hire_date)) then
        dbms_output.put_line('UPDATED OR INSERTED SUCCESSFUL');
    else
        RAISE_APPLICATION_ERROR(-20001, 'Time hiring employee must less or equal current');
    end if;
END;
BEGIN
     add_emp(208,'TRAN', 'ANH TUAN','dangdong971993@gmail.com','0888333774',TO_DATE('29-SEP-2022'), 'IT_PROG', 30000,null,103,60);
END;

-- 3.2: RANG BUOC TOAN VEN MIN MAX
CREATE OR REPLACE TRIGGER min_max_sal
BEFORE INSERT or UPDATE
ON jobs
FOR EACH ROW
DECLARE
BEGIN
    if(:new.MIN_SALARY > :new.MAX_SALARY) then RAISE_APPLICATION_ERROR(-20001, 'MIN value must small than MAX value');
    else dbms_output.put_line('UPDATED OR INSERTED SUCCESSFUL');
    end if;
END;
BEGIN
    insert into jobs values ('FB', 'Football',4000,500);
END;

-- 3.3: RANG BUOC THEM MOI
CREATE OR REPLACE TRIGGER date_start_ins_up
BEFORE INSERT or UPDATE
ON JOB_HISTORY
FOR EACH ROW
DECLARE
BEGIN
    if(:new.START_DATE > :new.END_DATE) then RAISE_APPLICATION_ERROR(-20001, 'START DATE must small or equal END DATE');
    else dbms_output.put_line('UPDATED OR INSERTED SUCCESSFUL');
    end if;
END;
BEGIN
    insert into job_history values (102, TO_date('30-SEP-2014'),TO_date('30-SEP-2013'),'IT_PROG',60);
END;

-- 3.4: RANG BUOC TOAN VEN LUONG VA HOA HONG NHAN VIEN PHAI TANG KHONG GIAM KHI CAP NHAT
CREATE OR REPLACE TRIGGER sal_com_emp
BEFORE UPDATE
ON employees
FOR EACH ROW
DECLARE
BEGIN
    if(:new.SALARY < :old.SALARY) or (:new.COMMISSION_PCT < :old.COMMISSION_PCT) then 
        RAISE_APPLICATION_ERROR(-20001, 'NEWER SALARY AND COMMISSION must greater than OLDER SALARY AND COMMISSION');
    else
        dbms_output.put_line('UPDATED SUCCESSFUL');
    end if;
END;