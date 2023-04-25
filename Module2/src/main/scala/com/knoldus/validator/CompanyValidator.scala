
package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.typesafe.scalalogging.Logger

import scala.util.{Failure, Success, Try}

class CompanyValidator {

   val emailValidatorObject = new EmailValidator
   val companiesObject = new CompanyReadDto
   private val loggerObject = Logger(getClass)

  def companyIsValid(company: Company): Boolean = {
    Try(companiesObject.getCompanyByName(company.name)) match {
      case Success(database) => (database.isEmpty && emailValidatorObject.emailIdIsValid(company.emailId))
      case Failure(exception) => {
        loggerObject.info("Exception Occurred: " + exception.getMessage)
        false
      }
    }
  }
}
