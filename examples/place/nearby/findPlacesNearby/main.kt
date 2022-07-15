
package examples.place.nearby

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.place

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PlaceNearbyRequest(Type = "store",
Location = "51.5074577,-0.1297515",
Keyword = "tesco",)
  
  try {
      val response = PlaceService.nearby(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
