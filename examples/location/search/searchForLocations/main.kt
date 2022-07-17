
package examples.location.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.location

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = LocationSearchRequest(Center: &location.Point{
Latitude = 51.511061,
Longitude = -0.120022,
},
NumEntities = 10,
Radius = 100,
Type = "bike",)
  
  try {
      val response = LocationServ.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
