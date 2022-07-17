
package examples.search.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.search

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SearchDeleteRequest(Id = "1234",
Index = "customers",)
  
  try {
      val response = SearchServ.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
