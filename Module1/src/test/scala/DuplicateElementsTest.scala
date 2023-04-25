
package com.knoldus

import org.scalatest.funsuite.AnyFunSuite

class DuplicateElementsTest extends AnyFunSuite {
  val duplicateElementsObject = new DuplicateElements
  val firstElement = 1
  val secondElement = 2
  val thirdElement = 3

  test("To check that the List[Int] does not contains duplicate elements") {
    val inputList = List(firstElement,secondElement,thirdElement)
    val input = duplicateElementsObject.duplicateElementsChecker(inputList)
    assert(input)
  }
  test("To check that the List[Int] contains duplicate elements") {
    val inputList = List(firstElement,secondElement,thirdElement,secondElement)
    val input = duplicateElementsObject.duplicateElementsChecker(inputList)
    assert(!input)
  }
  test("To check that the List[String] does not contains duplicate elements") {
    val input = duplicateElementsObject.duplicateElementsChecker(List("Hello","World","Scala"))
    assert(input)
  }
  test("To check that the List[String] contains duplicate elements") {
    val input = duplicateElementsObject.duplicateElementsChecker(List("Hello","World","Scala","Hello"))
    assert(!input)
  }
  test("To check that the list is empty") {
    val input = duplicateElementsObject.duplicateElementsChecker(List())
    assert(!input)
  }
}
