
package examples.location.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.location

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = LocationSearchRequest(name = "Jone")
  
  try {
      val response = LocationService.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
