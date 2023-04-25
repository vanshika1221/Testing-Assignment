
package com.knoldus

import org.scalatest.funsuite.AnyFunSuite

class PasswordCheckerTest extends AnyFunSuite {
  val passwordObject = new PasswordChecker

  test("PasswordChecker should return true if password is strong") {
    val input = passwordObject.passwordStrengthChecker("StrongPassword@123","Vanshika","abc@gmail.com")
    assert(input)
  }
  test("PasswordChecker should return false if upperCase Letter is missing") {
    val input = passwordObject.passwordStrengthChecker("weakpassword@123", "Vanshika","abc@gmail.com")
    assert(!input)
  }
  test("PasswordChecker should return false if lowerCase Letter is missing") {
    val input = passwordObject.passwordStrengthChecker("WEAKPASSWORD@123", "Vanshika","abc@gmail.com")
    assert(!input)
  }
  test("PasswordChecker should return false if special character is missing") {
    val input = passwordObject.passwordStrengthChecker("WeakPassword123", "Vanshika","abc@gmail.com")
    assert(!input)
  }
  test("PasswordChecker should return false if alphanumeric Letter is missing") {
    val input = passwordObject.passwordStrengthChecker("WeakPassword@", "Vanshika","abc@gmail.com")
    assert(!input)
  }
  test("PasswordChecker should return false if password contains username") {
    val input = passwordObject.passwordStrengthChecker("Vanshika@123", "Vanshika","abc@gmail.com")
    assert(!input)
  }
  test("PasswordChecker should throw exception for empty password string") {
    assertThrows[IllegalArgumentException] {
      passwordObject.passwordStrengthChecker("","vanshika","abc@gmail.com")
    }
  }
}

