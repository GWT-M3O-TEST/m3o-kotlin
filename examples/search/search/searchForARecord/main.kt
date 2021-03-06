
package examples.search.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.search

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SearchSearchRequest(Index = "customers",
Query = "name == 'John'",)
  
  try {
      val response = SearchServ.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
