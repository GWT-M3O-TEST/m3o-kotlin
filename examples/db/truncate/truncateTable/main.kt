
package examples.db.truncate

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.db

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DbTruncateRequest(Table = "example",)
  
  try {
      val response = DbService.truncate(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
