
package com.knoldus.db

import com.knoldus.models.Company

import scala.collection.immutable.HashMap

class CompanyReadDto {

  private val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  private val philipsCompany: Company = Company("Philips", "philips123@gmail.com", "Noida")
  private val companies: HashMap[String, Company] = HashMap("Knoldus" -> knoldusCompany, "Philips" -> philipsCompany)

  def getCompanyByName(name: String): Option[Company] = companies.get(name)

}
