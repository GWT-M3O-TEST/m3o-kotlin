
package examples.db.listTables

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.db

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DbListTablesRequest()
  
  try {
      val response = DbServ.listTables(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
