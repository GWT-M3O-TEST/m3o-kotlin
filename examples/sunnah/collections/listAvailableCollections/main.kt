
package examples.sunnah.collections

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.sunnah

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SunnahCollectionsRequest(name = "Jone")
  
  try {
      val response = SunnahService.collections(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
