
package com.knoldus

import com.typesafe.scalalogging.Logger

import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}

class PasswordChecker {
  val loggerObject = Logger(getClass)

  def passwordStrengthChecker(password: String, userName: String, userEmail: String): Boolean = {
    if (password.isEmpty) throw new IllegalArgumentException("Password is Empty")
    val upperCase = "[A-Z]+".r.findFirstIn(password).isDefined
    val lowerCase = "[a-z]+".r.findFirstIn(password).isDefined
    val alphaNumeric = "[0-9]+".r.findFirstIn(password).isDefined
    val specialCharacters = "[%@#&$]+".r.findFirstIn(password).isDefined
    val name = !(password.contains(userName))
    if (upperCase && lowerCase && alphaNumeric && specialCharacters && name) {
      true
    }
    else {
      false
    }
  }
}

object PasswordChecker extends App {
  private val passwordCheckerObject = new PasswordChecker
  Try {
    val password = readLine("Enter Your Password: ")
    val userName = readLine("Enter Your Username:  ")
    val userEmail = readLine("Enter Your Email-Id: ")
    passwordCheckerObject.passwordStrengthChecker(password, userName, userEmail)
  } match {
    case Success(value) => {
      if (value) {
        passwordCheckerObject.loggerObject.info("Strong Password")
      }
      else {
        passwordCheckerObject.loggerObject.info("Weak Password")
      }
    }
    case Failure(exception) => passwordCheckerObject.loggerObject.info("Exception Occurred: " + exception.getMessage)
  }
}
