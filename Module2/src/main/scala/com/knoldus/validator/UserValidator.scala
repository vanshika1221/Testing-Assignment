
package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.typesafe.scalalogging.Logger

import scala.util.{Failure, Success, Try}

class UserValidator {
  def userIsValid(user: User): Boolean = {

    val loggerObject = Logger(getClass)
    val emailValidatorObject = new EmailValidator
    val companiesObject = new CompanyReadDto

    Try(companiesObject.getCompanyByName(user.companyName)) match {
      case Success(database) => (!database.isEmpty && emailValidatorObject.emailIdIsValid(user.emailId))
      case Failure(exception) => {
        loggerObject.info("Exception Occurred: " + exception.getMessage)
        false
      }
    }
  }
}

