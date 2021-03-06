
package examples.search.createIndex

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.search

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SearchCreateIndexRequest(Index = "customers",)
  
  try {
      val response = SearchServ.createIndex(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
