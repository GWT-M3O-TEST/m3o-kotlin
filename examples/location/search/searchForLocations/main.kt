
package examples.location.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.location

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = LocationSearchRequest(NumEntities = 10,
Radius = 100,
Type = "bike",
Center: &location.Point{
Longitude = -0.120022,
Latitude = 51.511061,
},)
  
  try {
      val response = LocationService.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
