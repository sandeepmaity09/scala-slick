import com.example.Components.EmployeeRepo
import com.example.Models.Employee

import scala.concurrent.ExecutionContext.Implicits.global

object Hello extends App {

//  EmployeeRepo.create
  for(i <- 11 until 20) {
    val insertRes = EmployeeRepo.insert(Employee(i, "sahil", i))
    val res = insertRes.map { res => s"$res row inserted" }.recover {
      case ex: Throwable => ex.getMessage
    }
    res.map(println(_))
  }
/*  val deleteRes = EmployeeRepo.delete(2)
  val res2 = deleteRes.map{ res2 => s"$res2 row deleted"}.recover {
    case ex:Throwable => ex.getMessage
  }*/

/*  val updateRes = EmployeeRepo.updateName(1,"Sandeep")
  val res3 = updateRes.map { res3 => s"$res3 row deleted"}.recover {
    case ex:Throwable=> ex.getMessage
  }*/

//  res.map(println(_))
//  res2.map(println(_))
//  res3.map(println(_))
  Thread.sleep(1000)
}
