
package com.knoldus.validator

import org.scalatest.funsuite.AnyFunSuite

class EmailValidatorTest extends AnyFunSuite {
  val emailValidatorObject = new EmailValidator

  test("Email Validation should return false if email-Id  is invalid") {
    val input = emailValidatorObject.emailIdIsValid("google.com")
    assert(!input)
  }
  test("Email Validation should return true if email- Id is valid") {
    val input = emailValidatorObject.emailIdIsValid("abc@gmail.com")
    assert(input)
  }
}
