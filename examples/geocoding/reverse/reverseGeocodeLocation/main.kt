
package examples.geocoding.reverse

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.geocoding

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = GeocodingReverseRequest(Longitude = -0.1216235,
Latitude = 51.5123064,)
  
  try {
      val response = GeocodingService.reverse(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
