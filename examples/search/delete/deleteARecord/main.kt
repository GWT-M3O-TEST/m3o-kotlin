
package examples.search.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.search
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SearchdeleteRequest(name = "Jone")
  
  try {
      val response = SearchService.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
