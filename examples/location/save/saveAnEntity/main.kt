
package examples.location.save

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.location

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = LocationSaveRequest(Entity: &location.Entity{
Location: &location.Point{
Latitude = 51.511061,
Longitude = -0.120022,
Timestamp = 1622802761,
},
Id = "1",
Type = "bike",
},)
  
  try {
      val response = LocationService.save(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
