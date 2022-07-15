
package examples.routing.eta

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.routing

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = RoutingEtaRequest(Origin: &routing.Point{
Longitude = 13.38886,
Latitude = 52.517037,
},
Destination: &routing.Point{
Latitude = 52.529407,
Longitude = 13.397634,
},)
  
  try {
      val response = RoutingService.eta(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
