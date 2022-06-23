
package examples.db.dropTable

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.db

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DbDropTableRequest(Table = "example",)
  
  try {
      val response = DbService.dropTable(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
