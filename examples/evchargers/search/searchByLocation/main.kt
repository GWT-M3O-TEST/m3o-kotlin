
package examples.evchargers.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.evchargers

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = EvchargersSearchRequest(name = "Jone")
  
  try {
      val response = EvchargersService.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
