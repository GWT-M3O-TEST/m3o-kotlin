
package examples.routing.route

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.routing

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = RoutingRouteRequest(Origin: &routing.Point{
Longitude = 13.38886,
Latitude = 52.517037,
},
Destination: &routing.Point{
Longitude = 13.397634,
Latitude = 52.529407,
},)
  
  try {
      val response = RoutingService.route(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
