
package examples.vehicle.lookup

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.vehicle

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = VehicleLookupRequest(Registration = "LC60OTA",)
  
  try {
      val response = VehicleService.lookup(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
