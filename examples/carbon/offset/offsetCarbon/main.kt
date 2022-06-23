
package examples.carbon.offset

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.carbon

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CarbonOffsetRequest()
  
  try {
      val response = CarbonService.offset(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
