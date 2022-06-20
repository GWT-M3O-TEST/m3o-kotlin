
package examples.lists.read

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.lists

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ListsReadRequest(name = "Jone")
  
  try {
      val response = ListsService.read(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
