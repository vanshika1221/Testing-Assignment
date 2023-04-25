
package com.knoldus.validator

import com.typesafe.scalalogging.Logger

class EmailValidator {
  val loggerObject = Logger(getClass)
  def emailIdIsValid(emailId: String): Boolean = {
    val email = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".r
    if(email.matches(emailId)){
      loggerObject.info("Valid Email-Id")
      true
    } else {
      loggerObject.info("Invalid Email-Id")
      false
    }

  }
}
