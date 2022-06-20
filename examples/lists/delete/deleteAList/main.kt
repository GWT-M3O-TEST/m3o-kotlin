
package examples.lists.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.lists

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ListsDeleteRequest(name = "Jone")
  
  try {
      val response = ListsService.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
