
package examples.location.save

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.location

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = LocationSaveRequest(Entity: &location.Entity{
Id = "1",
Type = "bike",
Location: &location.Point{
Timestamp = 1622802761,
Latitude = 51.511061,
Longitude = -0.120022,
},
},)
  
  try {
      val response = LocationService.save(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
