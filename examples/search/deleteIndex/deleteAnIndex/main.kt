
package examples.search.deleteIndex

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.search
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SearchdeleteIndexRequest(name = "Jone")
  
  try {
      val response = SearchService.deleteIndex(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
