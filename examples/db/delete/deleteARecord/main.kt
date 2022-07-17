
package examples.db.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.db

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DbDeleteRequest(Table = "example",
Id = "1",)
  
  try {
      val response = DbServ.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
