
package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.scalatest.funsuite.AnyFunSuite

class UserImplTest extends AnyFunSuite {

  val companyReadDto = new CompanyReadDto
  val userValidator = new UserValidator
  val userImpl = new UserImpl(userValidator)
  val age = 24
  val firstUser: User = User("Aman","Singh",age,"Knoldus","Aman@gmail.com")
  val secondUser: User = User("Neha","Singh",age,"Swiggy","Neha@gmail.com")

  test("To check that user created exists") {
    val input = userImpl.createUser(firstUser)
    val result = Some("Aman@gmail.com")
    assert(input == result)
  }
  test("To check that employee created does not exists") {
    val input = userImpl.createUser(secondUser)
    val result = None
    assert(input == result)
  }
}

