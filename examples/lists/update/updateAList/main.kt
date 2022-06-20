
package examples.lists.update

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.lists
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ListsupdateRequest(name = "Jone")
  
  try {
      val response = ListsService.update(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
