
package com.knoldus

import org.scalatest.funsuite.AnyFunSuite

class FindFactorialTest extends AnyFunSuite {
  val factorialObject = new FindFactorial
  val value = 5
  test("To find factorial of any positive number") {
    val input = factorialObject.findFactorial(value)
    assert(input == 120)
  }
  test("To find factorial of any negative number") {
    val input = factorialObject.findFactorial(-1)
    assert(input == 0)
  }
}
