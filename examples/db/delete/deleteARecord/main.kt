
package examples.db.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.db
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DbdeleteRequest(name = "Jone")
  
  try {
      val response = DbService.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
