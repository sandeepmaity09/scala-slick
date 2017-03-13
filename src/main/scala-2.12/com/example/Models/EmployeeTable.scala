package com.example.Models

import slick.jdbc.PostgresProfile.api._

trait EmployeeTable {

  //private shows only availabe for
  private[example] class EmployeeTable(tag:Tag) extends Table [Employee](tag,"employee"){
    val id= column[Int]("id",O.PrimaryKey)
    val name = column[String]("name")
    val experience = column[Double]("experinece")

    def * = (id,name,experience) <>(Employee.tupled,Employee.unapply)
  }

  val employeeTableQuery = TableQuery[EmployeeTable]

}