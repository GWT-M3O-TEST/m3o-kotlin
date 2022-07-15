
package examples.db.read

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.db

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DbReadRequest(Query = "age == 43",
Table = "example",)
  
  try {
      val response = DbService.read(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
