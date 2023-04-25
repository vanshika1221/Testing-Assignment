
package com.knoldus.validator

import com.knoldus.models.Company
import org.scalatest.funsuite.AnyFunSuite

class CompanyValidatorTest extends AnyFunSuite {
  val companyValidatorObject = new CompanyValidator

  test("Company Validation should return true if company is not present in database and email is valid") {
    val input = companyValidatorObject.companyIsValid(Company("Google", "google@gmail.com", "California"))
    assert(input)
  }
  test("Company Validation should return false if company is present in database and email is valid") {
    val input = companyValidatorObject.companyIsValid(Company("Knoldus", "knoldus@gmail.com", "Noida"))
    assert(!input)
  }
  test("Company Validation should return false if email is invalid") {
    val input = companyValidatorObject.companyIsValid(Company("Google", "google", "California"))
    assert(!input)
  }
}
