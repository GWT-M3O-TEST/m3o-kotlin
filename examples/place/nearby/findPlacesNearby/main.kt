
package examples.place.nearby

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.place
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PlacenearbyRequest(name = "Jone")
  
  try {
      val response = PlaceService.nearby(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}