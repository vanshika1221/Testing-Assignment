
package com.knoldus.db

import com.knoldus.models.Company
import org.scalatest.funsuite.AnyFunSuite

class CompanyReadDtoTest extends AnyFunSuite {
   val companyObject = new CompanyReadDto

  test("To check if the company is present in the database") {
    val input = companyObject.getCompanyByName("Knoldus")
    val result = Some(Company("Knoldus", "knoldus@gmail.com", "Noida"))
    assert(input == result)
  }
  test("To check if the company is not present in the database") {
    val input = companyObject.getCompanyByName("Swiggy")
    val result = None
    assert(input == result)
  }
}
