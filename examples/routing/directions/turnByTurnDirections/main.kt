
package examples.routing.directions

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.routing

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = RoutingDirectionsRequest(Origin: &routing.Point{
Latitude = 52.517037,
Longitude = 13.38886,
},
Destination: &routing.Point{
Latitude = 52.529407,
Longitude = 13.397634,
},)
  
  try {
      val response = RoutingServ.directions(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
