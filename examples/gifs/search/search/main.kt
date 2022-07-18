
package examples.gifs.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.gifs

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = GifsSearchRequest(Limit = 2,
Query = "dogs",)
  
  try {
      val response = GifsServ.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
