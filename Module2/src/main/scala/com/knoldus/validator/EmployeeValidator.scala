
package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Employee, User}
import com.typesafe.scalalogging.Logger

import scala.util.{Failure, Success, Try}

class EmployeeValidator {

  def employeeIsValid(employee: Employee): Boolean = {

    val loggerObject = Logger(getClass)
    val emailValidatorObject = new EmailValidator
    val companiesObject = new CompanyReadDto

    Try(companiesObject.getCompanyByName(employee.companyName)) match {
      case Success(database) => (!database.isEmpty && emailValidatorObject.emailIdIsValid(employee.emailId))
      case Failure(exception) => {
        loggerObject.info("Exception Occurred: " + exception.getMessage)
        false
      }
    }
  }
}