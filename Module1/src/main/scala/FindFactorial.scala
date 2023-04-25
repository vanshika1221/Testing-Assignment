
package com.knoldus

import com.typesafe.scalalogging.Logger

class FindFactorial {
  val loggerObject = Logger(getClass)

  def findFactorial(inputNumber: Int): Int = {
    def findFactorialHelper(number: Int, accumulator: Int): Int = {
      if (inputNumber < 0) {
        loggerObject.info("Factorial of negative values cannot be calculated")
        0
      }
      else if (number == 1) {
        loggerObject.info(s"Factorial is: $accumulator")
        accumulator
      }
      else {
        findFactorialHelper(number - 1, accumulator * number)
      }
    }
    findFactorialHelper(inputNumber, 1)
  }
}

