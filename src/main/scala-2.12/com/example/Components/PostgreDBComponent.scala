package com.example.Components

import slick.jdbc.PostgresProfile
import slick.jdbc.PostgresProfile.api._

trait PostgreDBComponent extends DBComponent {
  val driver: PostgresProfile

  import driver.api._

  val db: Database = Database.forConfig("myPostgresDB")
}