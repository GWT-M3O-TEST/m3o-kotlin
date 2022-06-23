
package examples.google.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.google

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = GoogleSearchRequest(Query = "how to make donuts",)
  
  try {
      val response = GoogleService.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
