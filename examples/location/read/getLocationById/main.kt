
package examples.location.read

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.location

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = LocationReadRequest(Id = "1",)
  
  try {
      val response = LocationServ.read(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
