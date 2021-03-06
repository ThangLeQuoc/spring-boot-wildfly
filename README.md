# Foreword

# Business Specifications
Spring Roll is a fresh, energetic company. Company management rule base on two major aspects
## Department Management
Company has _departments_ (e.g: Customer Service, Development, Human Resources..). Each _department_ is lead by a _manager_ and many _employees_. The _manager_ and _employees_ in a department all have contracts with _time period_, that means they only work for a period of time in a department. Working contract timeline start and end with specific days.

A department can only have **only one** manager at a period of time.

One employee can have working contracts with departments. But **they must not have a concurrent working contract at a same period time with multiple departments** (e.g: A can not have a working contract from _03/2017_ to _06/2017_ in Human Resources Dept and a working contract from _05/2017_ to _08/2017_ with another dept.). They cannot be the manager of a department which they are not currently has a contract with. (e.g A currently has an active contract with H.R Dept, so he can't be the manager of Development Dept).

## Employee Management
An employee has _working contract_ with departments in company. He has _salary record_ and _working title_ in a period of time.

# Application Specification
- Must have two main functions: Department Management and Employee Management
## Department Management Specifications
- User can add/update departments
- User can click on department to view more details (list of employees, manager)
- User can add an available employee to the selected department and assign his title, condition of an available employee stated above. Employee's title in a department is mandatory
- User can remove current employee from the department. Upon removal, the working period of employee is updated.
- User can change department manager
- User can browse history of department
- These should be a selection from a date to a date to view history of departments
- A historical report of department should include employee name, their working period in department,
separate by each section, each section is a title of employee (e.g: Manager, Engineer, etc.)
## Employee Management Specifications
- User can add/edit information of employee
- Basic employee information includes: birth date, first name, last name, gender, and hire date
- User can set the salary of employee. After saving, a salary record for employee is generated, starting with salary and start of the moment the salary was recorded. On the upcomming salary change, the _to date_ time of salary record is updated, and a new salary record will be created.

# Technical Specifications
## Data Model

## Environment Infrastructure
