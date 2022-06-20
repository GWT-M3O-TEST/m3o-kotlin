
package examples.db.create

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.db

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DbCreateRequest(name = "Jone")
  
  try {
      val response = DbService.create(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
