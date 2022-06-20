
package examples.search.index

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.search

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SearchIndexRequest(name = "Jone")
  
  try {
      val response = SearchService.index(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
