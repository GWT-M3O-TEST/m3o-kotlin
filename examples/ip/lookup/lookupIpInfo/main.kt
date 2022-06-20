
package examples.ip.lookup

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.ip

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = IpLookupRequest(name = "Jone")
  
  try {
      val response = IpService.lookup(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
