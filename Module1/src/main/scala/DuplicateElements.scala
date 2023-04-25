
package com.knoldus

import com.typesafe.scalalogging.Logger

class DuplicateElements {
  val loggerObject: Logger = Logger(getClass)

  def duplicateElementsChecker[T](inputList: List[T]): Boolean = {
    val distinctList = inputList.distinct
    if (inputList.isEmpty) {
      loggerObject.info("List is empty")
      false
    }
    else if (distinctList != inputList) {
      loggerObject.info("Duplicate Elements Found")
      false
    }
    else {
      loggerObject.info("List does not contain any duplicate elements")
      true
    }
  }
}
