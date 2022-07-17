
package examples.twitter.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.twitter

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = TwitterSearchRequest(Query = "cats",)
  
  try {
      val response = TwitterServ.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
