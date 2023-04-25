
package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplTest extends AnyFunSuite {

  val companyReadDto = new CompanyReadDto
  val employeeValidator = new EmployeeValidator
  val employeeImpl = new EmployeeImpl(employeeValidator)
  val age = 24
  val firstEmployee: Employee = Employee("Aman","Singh",age,25000.00,"Intern","Knoldus","Aman@gmail.com")
  val secondEmployee: Employee = Employee("Neha","Singh",age,15000.00,"Intern","Swiggy","Neha@gmail.com")

  test("To check that employee created exists") {
    val input = employeeImpl.createEmployee(firstEmployee)
    val result = Some("Aman@gmail.com")
    assert(input == result)
  }
  test("To check that employee created does not exists") {
    val input = employeeImpl.createEmployee(secondEmployee)
    val result = None
    assert(input == result)
  }
}
