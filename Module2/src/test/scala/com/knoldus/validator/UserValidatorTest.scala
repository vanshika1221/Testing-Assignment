
package com.knoldus.validator

import com.knoldus.models.User
import org.scalatest.funsuite.AnyFunSuite

class UserValidatorTest extends AnyFunSuite {
  val employeeValidatorObject = new UserValidator
  val age = 24
  test("User Validation should return true if company is present in database and email-Id  is valid") {
    val input = employeeValidatorObject.userIsValid(User("Anika", "Singh",age,"Knoldus","anu12@gmail.com"))
    assert(input)
  }
  test("User Validation should return false if company is not present in database") {
    val input = employeeValidatorObject.userIsValid(User("Anika", "Singh", age, "Google", "anu12@gmail.com"))
    assert(!input)
  }
  test("User Validation should return false if email-Id  is invalid") {
    val input = employeeValidatorObject.userIsValid(User("Anika", "Singh", age,"Google", "anu12.com"))
    assert(!input)
  }
}
