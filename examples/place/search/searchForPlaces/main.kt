
package examples.place.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.place
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PlacesearchRequest(name = "Jone")
  
  try {
      val response = PlaceService.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
