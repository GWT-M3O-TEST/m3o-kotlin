
package examples.evchargers.referenceData

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.evchargers
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = EvchargersreferenceDataRequest(name = "Jone")
  
  try {
      val response = EvchargersService.referenceData(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
