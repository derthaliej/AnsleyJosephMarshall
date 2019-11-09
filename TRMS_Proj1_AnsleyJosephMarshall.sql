/*******************************************************************************
   Tuition Reimbursement Management System Database - Version 1.0
   Script: TRMS_Proj1_AnsleyJosephMarshall.sql
   Description:  Build Schema tables and fucntions to manipulate data.
   DB Server: PostgreSql
   Author(s): Derron Marshall
   Due date : 11/11/2019 
********************************************************************************/



/*******************************************************************************
   Create Schema
********************************************************************************/


CREATE SCHEMA IF NOT EXISTS TRMS;

--DROP SCHEMA IF EXISTS TRMS;

/*******************************************************************************
   Create Tables
********************************************************************************/

-- i wanted some more formality and consistency so i adjusted the names of a few things 

CREATE TABLE TRMS.Employee
(
	 Emp_ID  int NOT NULL,     
	 FirstName  VARCHAR(20) NOT NULL,
     LastName  VARCHAR(20) NOT NULL,
     User_Name  VARCHAR(60) NOT null UNIQUE,
     passwd  VARCHAR(60) NOT null,
     Emp_Typ  INT NOT NULL,
    CONSTRAINT  PK_Employee  PRIMARY KEY  ( Emp_ID )
);

CREATE TABLE TRMS.Supervise
(
	 Emp_ID  INT NOT NULL,  
	 SupEmp_ID  INT,
    CONSTRAINT  PK_Sup  PRIMARY KEY  ( Emp_ID, SupEmp_ID )
);

CREATE TABLE TRMS.Emp_type
(    
     Emp_Typ  INT NOT NULL,
     Type_Desc  VARCHAR(30) NOT NULL,
    CONSTRAINT  PK_Emp_type  PRIMARY KEY  ( Emp_typ )
);

CREATE TABLE TRMS.Grading_Format
(
	 Formt_Typ  int NOT NULL,
	 Event_ID  int NOT NULL,
	 grade_needed VARCHAR(30),
	 grade_recieved VARCHAR(30),
    CONSTRAINT  PK_Grading_Format  PRIMARY KEY  ( Formt_Typ, Event_ID)
);

CREATE TABLE TRMS.Format_typ
(
	 Formt_Typ  int NOT NULL,
	 Format_Desc VARCHAR(60),
    CONSTRAINT  PK_Format_typ  PRIMARY KEY  ( Formt_Typ)
);

CREATE TABLE TRMS.Events
(
     Event_ID  int NOT NULL,
     Event_typ  int NOT NULL,
     Reason VARCHAR(1000),          ----reason employee wishes to attend
     Event_strtdate DATE,
     Event_Location VARCHAR(100),
     Event_Length INT,
     Event_Cost NUMERIC(10,2),
     Absent_days INT,
	 Approval_date  DATE,
     Resource VARCHAR(500),
    CONSTRAINT  PK_Events  PRIMARY KEY  ( Event_ID )
);

CREATE TABLE TRMS.Event_Type
(
     Event_typ  int NOT NULL,
     Description VARCHAR(300),
     Rate  NUMERIC(3,2),          			-- reimbursement percentage  
    CONSTRAINT  PK_Event_Type  PRIMARY KEY  ( Event_typ )
);

;  

CREATE TABLE TRMS.Reimbursement 
(
     Reimbursement_ID  int NOT NULL,
     Event_ID  int NOT NULL,
     Emp_ID  int NOT NULL,
     Status_ID  int NOT NULL,
     Request_date DATE,           			-- moved request date because it the date the claim is filed
     Reason VARCHAR(1000),		 			-- reason for denial
     ProjectedReimbursement NUMERIC(10,2),	-- amount allocated to this specific claim 
     TotalReimbursement NUMERIC(10,2),		-- total allotted Reimbursement
     AwardedReimbursements NUMERIC(10,2),	-- total of all the Reimbursements given to a specfic empolyee that period
     PendingReimbursements NUMERIC(10,2),	-- total of all the pending Reimbursements that a specfic empolyee has that period
     AvailableReimbursement NUMERIC(10,2),	-- remaining balance from Reimbursement alloted 
    CONSTRAINT  PK_Reimbursement  PRIMARY KEY  ( Reimbursement_ID )
);

CREATE TABLE TRMS.Reimbursement_Status
(    
     Status_ID  int NOT NULL,           			
     Status_desc VARCHAR(1000),    
    CONSTRAINT  PK_Reimbursement_Status  PRIMARY KEY  ( Status_ID )
);


-- drop table TRMS.Employee CASCADE;
-- drop table TRMS.Emp_type CASCADE;
-- drop table TRMS.Grading_Format CASCADE;
-- drop table TRMS.Format_typ CASCADE;
-- drop table TRMS.Events CASCADE;
-- drop table TRMS.Event_Type CASCADE;
-- drop table TRMS.Reimbursement CASCADE;
-- drop table TRMS.Reimbursement_Status CASCADE;

/*******************************************************************************
   Create Sequence + Add sequence to tables
********************************************************************************/


CREATE SEQUENCE  TRMS.seq_empid 
START WITH  100000 
OWNED BY  TRMS.Employee.Emp_ID;
                
ALTER TABLE  TRMS.Employee ALTER COLUMN Emp_ID
SET DEFAULT nextVal ('TRMS.seq_empid');  

CREATE SEQUENCE  TRMS.seq_Emptyp
START WITH  1 
OWNED BY  TRMS.Emp_type.Emp_typ;
                
ALTER TABLE  TRMS.Emp_type ALTER COLUMN  Emp_typ 
SET DEFAULT nextVal ('TRMS.seq_Emptyp'); 

CREATE SEQUENCE  TRMS.seq_Formattyp
START WITH  1 
OWNED BY  TRMS.Format_typ.Formt_typ;
                
ALTER TABLE  TRMS.Format_typ ALTER COLUMN  Formt_typ 
SET DEFAULT nextVal ('TRMS.seq_Formattyp'); 

CREATE SEQUENCE  TRMS.seq_EventID
START WITH  100 
OWNED BY  TRMS.Events.Event_ID;
                
ALTER TABLE  TRMS.Events ALTER COLUMN  Event_ID 
SET DEFAULT nextVal ('TRMS.seq_EventID'); 

CREATE SEQUENCE  TRMS.seq_Eventtyp
START WITH  1 
OWNED BY  TRMS.Event_Type.Event_typ;
                
ALTER TABLE  TRMS.Event_Type ALTER COLUMN  Event_typ 
SET DEFAULT nextVal ('TRMS.seq_Eventtyp'); 

CREATE SEQUENCE  TRMS.seq_ReimbursementID
START WITH  10 
OWNED BY  TRMS.Reimbursement.Reimbursement_ID;
                
ALTER TABLE  TRMS.Reimbursement ALTER COLUMN  Reimbursement_ID 
SET DEFAULT nextVal ('TRMS.seq_ReimbursementID'); 

CREATE SEQUENCE  TRMS.seq_RStatus
START WITH  1 
OWNED BY  TRMS.Reimbursement_Status.Status_ID;
                
ALTER TABLE  TRMS.Reimbursement_Status ALTER COLUMN  Status_ID 
SET DEFAULT nextVal ('TRMS.seq_RStatus'); 


/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
-- employee has a employee type
ALTER TABLE TRMS.Employee ADD CONSTRAINT FK_Emp_typ
    FOREIGN KEY (Emp_typ) REFERENCES TRMS.Emp_type (Emp_typ) ON DELETE CASCADE ON UPDATE CASCADE;
-- Supervisor has a employee
ALTER TABLE TRMS.Supervise ADD CONSTRAINT FK_SEmp
    FOREIGN KEY (Emp_ID) REFERENCES TRMS.Employee (Emp_ID) ON DELETE CASCADE ON UPDATE CASCADE;
-- grading format has a format type 
ALTER TABLE TRMS.Grading_Format ADD CONSTRAINT FK_Format_typ
    FOREIGN KEY (Formt_typ) REFERENCES TRMS.Format_typ (Formt_typ) ON DELETE CASCADE ON UPDATE CASCADE;
-- grading format has a event   
ALTER TABLE TRMS.Grading_Format ADD CONSTRAINT FK_Event_ID
    FOREIGN KEY (Event_ID) REFERENCES TRMS.Events (Event_ID) ON DELETE CASCADE ON UPDATE CASCADE;
-- event has a event type   
ALTER TABLE TRMS.Events ADD CONSTRAINT FK_Event_typ
    FOREIGN KEY (Event_Typ) REFERENCES TRMS.Event_Type (Event_Typ) ON DELETE CASCADE ON UPDATE CASCADE;
-- Reimbursement has a employee   
ALTER TABLE TRMS.Reimbursement ADD CONSTRAINT FK_EmpID
    FOREIGN KEY (Emp_ID) REFERENCES TRMS.Employee (Emp_ID) ON DELETE CASCADE ON UPDATE CASCADE;
-- Reimbursement has a event    
ALTER TABLE TRMS.Reimbursement ADD CONSTRAINT FK_Eventid
    FOREIGN KEY (Event_ID) REFERENCES TRMS.Events (Event_ID) ON DELETE CASCADE ON UPDATE CASCADE;
-- Reimbursement has a Reimbursement status    
ALTER TABLE TRMS.Reimbursement ADD CONSTRAINT FK_Statusid
    FOREIGN KEY (Status_ID) REFERENCES TRMS.Reimbursement_Status (Status_ID) ON DELETE CASCADE ON UPDATE CASCADE;
   
/*******************************************************************************
         Functions
********************************************************************************/
----Selects
CREATE OR REPLACE FUNCTION TRMS.get_AllEmployee() 
   RETURNS TABLE (
   	 Emp_ID  INT,
     FirstName  VARCHAR(20),
     LastName  VARCHAR(20),
     User_Name  VARCHAR(60),
     passwd  VARCHAR(60),
     Emp_Typ  INT
) 
AS $$
BEGIN
   RETURN QUERY SELECT
      *
   FROM
      TRMS.Employee;
END; $$ 
 
LANGUAGE 'plpgsql';   

--<>-- Returns all Supervisors
CREATE OR REPLACE FUNCTION TRMS.get_AllSup() 
   RETURNS TABLE (
   	 Emp_ID  INT,
     FirstName  VARCHAR(20),
     LastName  VARCHAR(20),
     User_Name  VARCHAR(60),
     passwd  VARCHAR(60),
     Emp_Typ  INT
) 
AS $$
BEGIN
   RETURN QUERY SELECT
      *
   FROM
      TRMS.Employee
	WHERE 
		TRMS.Employee.Emp_Typ = 2
	OR 
		TRMS.Employee.Emp_Typ = 3;
END; $$ 
 
LANGUAGE 'plpgsql';  

--<>-- Returns a Single Row 

CREATE OR REPLACE FUNCTION TRMS.get_Employee(Uname VARCHAR) 
   RETURNS TABLE (
   	 Emp_ID  INT,
     FirstName  VARCHAR(20),
     LastName  VARCHAR(20),
     User_Name  VARCHAR(60),
     passwd  VARCHAR(60),
     Emp_Typ  INT
) 
AS $$
BEGIN
   RETURN QUERY SELECT
      *
   FROM
      TRMS.Employee
	WHERE 
		TRMS.Employee.User_Name = Uname;
END; $$ 
 
LANGUAGE 'plpgsql'; 
----
CREATE OR REPLACE FUNCTION TRMS.get_AllEmployeeType() 
   RETURNS TABLE (
   	 Emp_Typ  INT,
     Type_Desc  VARCHAR(30)
) 
AS $$
BEGIN
   RETURN QUERY SELECT
      *
   FROM
      TRMS.Emp_type;
END; $$ 
 
LANGUAGE 'plpgsql'; 
----
CREATE OR REPLACE FUNCTION TRMS.get_AllSupervise() 
   RETURNS TABLE (
   	 Emp_ID  INT,
     SupEmp_ID  INT
) 
AS $$
BEGIN
   RETURN QUERY SELECT
      *
   FROM
      TRMS.Supervise;
END; $$ 
 
LANGUAGE 'plpgsql'; 
----
CREATE OR REPLACE FUNCTION TRMS.get_GradingFormat() 
   RETURNS TABLE (
   	 Formt_Typ  int,
	 Event_ID  int,
	 grade_needed VARCHAR(30),
	 grade_recieved VARCHAR(30)
) 
AS $$
BEGIN
   RETURN QUERY SELECT
      *
   FROM
      TRMS.Grading_Format;
END; $$ 
 
LANGUAGE 'plpgsql';   
----
CREATE OR REPLACE FUNCTION TRMS.get_AllFormatType() 
   RETURNS TABLE (
   	 Formt_Typ  INT,
	 Format_Desc VARCHAR(60)
) 
AS $$
BEGIN
   RETURN QUERY SELECT
      *
   FROM
      TRMS.Format_typ;
END; $$ 
 
LANGUAGE 'plpgsql';   
----
CREATE OR REPLACE FUNCTION TRMS.get_AllEvents() 
   RETURNS TABLE (
   	 Event_ID  INT,
     Event_typ  INT,
     Reason VARCHAR(800),          
     Event_strtdate DATE,
     Event_Location VARCHAR(100),
     Event_Length INT,
     Event_Cost NUMERIC(10,2),
     Absent_days INT,
	 Approval_date  DATE,
     Resource VARCHAR(500)
) 
AS $$
BEGIN
   RETURN QUERY SELECT
      *
   FROM
      TRMS.Events;
END; $$ 
 
LANGUAGE 'plpgsql';   
----
CREATE OR REPLACE FUNCTION TRMS.get_AllEventType() 
   RETURNS TABLE (
   	 Event_typ  INT,
     Description VARCHAR(300),
     Rate  NUMERIC(3,2)
) 
AS $$
BEGIN
   RETURN QUERY SELECT
      *
   FROM
      TRMS.Event_Type;
END; $$ 
 
LANGUAGE 'plpgsql';   
----
CREATE OR REPLACE FUNCTION TRMS.get_AllReimbursement() 
   RETURNS TABLE (
   	 Reimbursement_ID  INT,
     Event_ID  INT,
     Emp_ID  INT,
     Status_ID  INT,          			
     Request_date DATE,           			
     Reason VARCHAR(1000),		 			
     ProjectedReimbursement NUMERIC(10,2),	 
     TotalReimbursement NUMERIC(10,2),		
     AwardedReimbursements NUMERIC(10,2),	
     PendingReimbursements NUMERIC(10,2), 
     AvailableReimbursement NUMERIC(10,2)
) 
AS $$
BEGIN
   RETURN QUERY SELECT
      *
   FROM
      TRMS.Reimbursement;
END; $$ 
 
LANGUAGE 'plpgsql';   
---- 
CREATE OR REPLACE FUNCTION TRMS.get_AllReimbursementStatus() 
   RETURNS TABLE (
   	 Status_ID  INT,           			
     Status_desc VARCHAR(1000)
) 
AS $$
BEGIN
   RETURN QUERY SELECT
      *
   FROM
      TRMS.Reimbursement_Status;
END; $$ 
 
LANGUAGE 'plpgsql';    
----

-----Insertions
CREATE OR REPLACE FUNCTION TRMS.AddEmployee(fname VARCHAR, lname VARCHAR, uName VARCHAR, pwd VARCHAR, utype integer)
  RETURNS void AS
  $BODY$
      BEGIN
        INSERT INTO TRMS.Employee(Emp_ID,FirstName, LastName, User_Name, passwd, Emp_Typ)
        VALUES(DEFAULT, fname, lname, uName, pwd, utype);
      END;
  $BODY$
  LANGUAGE 'plpgsql';
----
CREATE OR REPLACE FUNCTION TRMS.AddEmpType(typDesc VARCHAR)
  RETURNS void AS
  $BODY$
      BEGIN
        INSERT INTO TRMS.Emp_type(Emp_Typ,Type_Desc)
        VALUES(DEFAULT, typDesc);
      END;
  $BODY$
  LANGUAGE 'plpgsql';
----
CREATE OR REPLACE FUNCTION TRMS.AddSup(empid integer,sempid integer)
  RETURNS void AS
  $BODY$
      BEGIN
        INSERT INTO TRMS.Supervise(Emp_ID,SupEmp_ID)
        VALUES(empid, sempid);
      END;
  $BODY$
  LANGUAGE 'plpgsql';	 
----
CREATE OR REPLACE FUNCTION TRMS.AddGradingFormat( eventid integer, grade_nd VARCHAR, grade_rec VARCHAR)
  RETURNS void AS
  $BODY$
      BEGIN
        INSERT INTO TRMS.Grading_Format(Formt_Typ,Event_ID, grade_needed, grade_recieved)
        VALUES(DEFAULT, eventid, grade_nd, grade_rec);
      END;
  $BODY$
  LANGUAGE 'plpgsql';
----
CREATE OR REPLACE FUNCTION TRMS.AddFormatType(fmttyp VARCHAR)
  RETURNS void AS
  $BODY$
      BEGIN
        INSERT INTO TRMS.Format_typ(Formt_Typ,Format_Desc)
        VALUES(DEFAULT, fmttyp);
      END;
  $BODY$
  LANGUAGE 'plpgsql';
----
CREATE OR REPLACE FUNCTION TRMS.AddEvent(etype integer, Reason VARCHAR, estrtdte DATE, elocation VARCHAR, elen INT, ecost NUMERIC(10,2), adays INT, adate DATE, res VARCHAR)
  RETURNS void AS
  $BODY$
      BEGIN
        INSERT INTO TRMS.Events(Event_ID,Event_typ,Reason, Event_strtdate, Event_Location, Event_Length, Event_Cost, Absent_days, Approval_date, Resource)
        VALUES(DEFAULT, etype, Reason, estrtdte, elocation, elen, ecost, adays, adate, res);
      END;
  $BODY$
  LANGUAGE 'plpgsql';
----
CREATE OR REPLACE FUNCTION TRMS.AddEventType(etdes VARCHAR, rate NUMERIC(5,5))
  RETURNS void AS
  $BODY$
      BEGIN
        INSERT INTO TRMS.Event_Type(Event_typ,Description,Rate)
        VALUES(DEFAULT, etdes, rate);
      END;
  $BODY$
  LANGUAGE 'plpgsql';
----
CREATE OR REPLACE FUNCTION TRMS.AddReimbursement(eid integer, empid integer, sid integer, rdte DATE, Reason VARCHAR, preim NUMERIC(10,2), treim NUMERIC(10,2), awreim NUMERIC(10,2), pereim NUMERIC(10,2), avriem NUMERIC(10,2))
  RETURNS void AS
  $BODY$
      BEGIN
        INSERT INTO TRMS.Reimbursement(Reimbursement_ID, Event_ID, Emp_ID, Status_ID, Request_date, Reason, ProjectedReimbursement, TotalReimbursement, AwardedReimbursements, PendingReimbursements, AvailableReimbursement)
        VALUES(DEFAULT, eid, empid, sid, rdte, Reason, preim, treim, awreim, pereim, avriem);
      END;
  $BODY$
  LANGUAGE 'plpgsql';
----
CREATE OR REPLACE FUNCTION TRMS.AddReimbursementStatus(sdes VARCHAR)
  RETURNS void AS
  $BODY$
      BEGIN
        INSERT INTO TRMS.Reimbursement_Status(Status_ID,Status_desc)
        VALUES(DEFAULT, sdes);
      END;
  $BODY$
  LANGUAGE 'plpgsql';
 ----
 
------deletitions

 --I made a dynamic fuction that can delete 1 record at a time from any table
CREATE OR REPLACE FUNCTION TRMS.deleteRec(tableName varchar, columnName varchar,value varchar)
 RETURNS void AS

$BODY$ 
begin 
EXECUTE 'DELETE FROM ' || tableName || ' WHERE ' || columnName || '=' || value; 

end; 
$BODY$

LANGUAGE plpgsql VOLATILE;

 --I made a dynamic fuction that can delete all records from any table
CREATE OR REPLACE FUNCTION TRMS.deleteAllRec(tableName varchar)
 RETURNS void AS

$BODY$ 
begin 
EXECUTE 'DELETE FROM ' || tableName; 

end; 
$BODY$

LANGUAGE plpgsql VOLATILE;
----
------update

 --I made a dynamic fuction that can update 1 record at a time from any table
CREATE OR REPLACE FUNCTION TRMS.UpdateRec(tableName varchar, columnName1 varchar, columnName2 varchar, value1 varchar, value2 varchar)
 RETURNS void AS

$BODY$ 
begin 
EXECUTE 'UPDATE ' || tableName || ' SET ' || columnName1 || '=' || value1 || ' WHERE ' || columnName2 || '=' || value2; 

end; 
$BODY$

LANGUAGE plpgsql VOLATILE;
 

/*******************************************************************************
   Populate Tables with Some Assumed data
********************************************************************************/

SELECT TRMS.AddEmpType('Employee');
SELECT TRMS.AddEmpType('Direct Supervisor');
SELECT TRMS.AddEmpType('Department Head');
SELECT TRMS.AddEmpType('Benefits Coordinator');
SELECT TRMS.AddEmpType('Direct Manager');

--update trms.emp_type set type_desc = 'Benefits Coordinator' where emp_typ = 4;
--select TRMS.UpdateRec('TRMS.Emp_type', 'type_desc', 'emp_typ', '''Benefits Coordinator''', '4');
select * from TRMS.Emp_type

SELECT TRMS.AddFormatType('GPA');
SELECT TRMS.AddFormatType('Letter Grade');
SELECT TRMS.AddFormatType('Percentage');
SELECT TRMS.AddFormatType('Pass/Fail');
SELECT TRMS.AddFormatType('Presentation');

select * from TRMS.Format_typ

SELECT TRMS.AddEventType('Certification', 1.0);
SELECT TRMS.AddEventType('Technical Training', 0.9);
SELECT TRMS.AddEventType('University Course', 0.8);
SELECT TRMS.AddEventType('Classes',0.75);
SELECT TRMS.AddEventType('Seminar',0.6);
SELECT TRMS.AddEventType('Other',0.3);

select * from TRMS.Event_Type

SELECT TRMS.AddReimbursementStatus('Pending');
SELECT TRMS.AddReimbursementStatus('DS Approval');
SELECT TRMS.AddReimbursementStatus('DS Denial');
SELECT TRMS.AddReimbursementStatus('DS Request More Info');
SELECT TRMS.AddReimbursementStatus('DS Auto Approval');
SELECT TRMS.AddReimbursementStatus('DH Approval');
SELECT TRMS.AddReimbursementStatus('DH Denial');
SELECT TRMS.AddReimbursementStatus('DH Request More Info');
SELECT TRMS.AddReimbursementStatus('DH Auto Approval');
SELECT TRMS.AddReimbursementStatus('URGENT');
SELECT TRMS.AddReimbursementStatus('BC Approval');
SELECT TRMS.AddReimbursementStatus('BC Denial');
SELECT TRMS.AddReimbursementStatus('BC Request More Info');
SELECT TRMS.AddReimbursementStatus('BC Adj. Amount');
SELECT TRMS.AddReimbursementStatus('Email Sent');

select * from TRMS.Reimbursement_Status


 ----  
SELECT TRMS.AddEmployee('Dee', 'Jay', 'deej@gmail.com', 'pwd1', 4);
SELECT TRMS.AddEmployee('Crytal', 'Good', 'crsyg@msn.com', 'pwd2', 2);
SELECT TRMS.AddEmployee('Jelisa', 'Leng', 'jelg@yahoo.com', 'pwd3', 1);
SELECT TRMS.AddEmployee('Leon', 'Reid', 'leer@gmail.com', 'pwd3', 1);
SELECT TRMS.AddEmployee('Andre', 'DeGraw','drede@gmail.com', 'pwd4', 3);
SELECT TRMS.AddEmployee('Dom', 'Tome', 'domt@yahoo.com', 'pwd6', 1);
SELECT TRMS.AddEmployee('Toni', 'Kay', 'kay@yahoo.com', 'pwd7', 2);
SELECT TRMS.AddEmployee('Jack', 'Weme', 'jweme@yahoo.com', 'pwd8', 1);
SELECT TRMS.AddEmployee('Sherika', 'Ole', 'sole@yahoo.com', 'pwd9', 1);
SELECT TRMS.AddEmployee('Keke', 'Stride', 'kekes@msn.com', 'pwd10', 5);

select * from TRMS.get_AllEmployee();
select * from TRMS.get_Employee('deej@gmail.com');
---
SELECT TRMS.AddSup(100002,100001);
SELECT TRMS.AddSup(100003,100001);
SELECT TRMS.AddSup(100005,100004);
SELECT TRMS.AddSup(100007,100006);
SELECT TRMS.AddSup(100008,100006);
SELECT TRMS.AddSup(100001,100004);
SELECT TRMS.AddSup(100006,100004);
SELECT TRMS.AddSup(100000,100009);

--select TRMS.UpdateRec('TRMS.Supervise', 'SupEmp_ID', 'Emp_ID', '100004', '100005');
SELECT TRMS.get_AllSupervise();

SELECT * FROM TRMS.get_AllSup();
---

select * from TRMS.get_AllEmployee();
select * from TRMS.get_AllEmployeeType(); 
select * from TRMS.get_AllSupervise();
select * from TRMS.get_GradingFormat();
select * from TRMS.get_AllFormatType();
select * from TRMS.get_AllEvents(); 
select * from TRMS.get_AllEventType();
select * from TRMS.get_AllReimbursement();
select * from TRMS.get_AllReimbursementStatus();
-------------------
