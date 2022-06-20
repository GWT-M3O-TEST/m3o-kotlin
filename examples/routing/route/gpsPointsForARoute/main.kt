
package examples.routing.route

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.routing

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = RoutingRouteRequest(name = "Jone")
  
  try {
      val response = RoutingService.route(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
