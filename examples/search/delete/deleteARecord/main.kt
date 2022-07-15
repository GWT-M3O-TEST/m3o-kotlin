
package examples.search.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.search

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SearchDeleteRequest(Index = "customers",
Id = "1234",)
  
  try {
      val response = SearchService.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
