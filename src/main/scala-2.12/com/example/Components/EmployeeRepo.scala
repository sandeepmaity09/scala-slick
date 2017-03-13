package com.example.Components

import com.example.Models.{Employee, EmployeeTable}

trait EmployeeRepo extends EmployeeTable {

  this:DBComponent =>

  import driver.api._

  def create = db.run(employeeTableQuery.schema.create)

  def insert(emp:Employee) = db.run {
    employeeTableQuery += emp
  }

  def delete(exp:Double) = {
    val query = employeeTableQuery.filter(x => x.experience < exp)
    val action = query.delete
    db.run(action)
  }

  def updateName(id:Int,name:String) = {
    val query = employeeTableQuery.filter(_.id === id).map(_.name).update(name)
    db.run(query)
  }

}

object EmployeeRepo extends EmployeeRepo with PostgreDBComponent