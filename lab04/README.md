# TQS - LAB04
#### Author: Francisca Barros, NMEC-93102
---

## 2/ 

##### a)

*Identify a couple of examples on the use of AssertJ expressive methods chaining.*

[EmployeeService_UnitTest.java](https://github.com/itskikat/pratica-tqs/blob/main/lab04/TQS_Lab04-EmployeeManagement/src/test/java/tqsdemo/employeemngr/employee/EmployeeService_UnitTest.java), in the test [given3Employees_whengetAll_thenReturn3Records()](https://github.com/itskikat/pratica-tqs/blob/e38443a243420883cad1d893e1f3ad7ede566449/lab04/TQS_Lab04-EmployeeManagement/src/test/java/tqsdemo/employeemngr/employee/EmployeeService_UnitTest.java#L96)
``` java
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(), john.getName(), bob.getName());
```


##### b)

*Identify an example in which you mock the behavior of the repository (and avoid involving a database).*

In [EmployeeService_UnitTest.java](https://github.com/itskikat/pratica-tqs/blob/main/lab04/TQS_Lab04-EmployeeManagement/src/test/java/tqsdemo/employeemngr/employee/EmployeeService_UnitTest.java), the Employee Respository is mocked, and the real database is not involved. This way, the expected return values of the DB are mimicked.



##### c)

*What is the difference between standard @Mock and @MockBean?*

**@Mock** allows us to create a mock object of a class or an interface; the mock can be used to stub return values for its methods and verify if they were called.

**@MockBean** is used to add mock objects to the Spring application context, that'll replace any existing bean of the same type in the application context.
This is useful in integration tests where a particular bean – for example, an external service – needs to be mocked.


##### d)

*What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?*

This file contains the details to configure the persistence storage.
The @TestPropertySource annotaion will override the existing *application.properties* file; this way, when running our integrations tests, nothing will be mocked, and actual end-to-end scenarios will be executed.


## 2/ + 3/ 

All tests are inside [TQS_Lab04-CarInfoSystem](https://github.com/itskikat/pratica-tqs/tree/main/lab04/TQS_Lab04-CarInfoSystem)




 
