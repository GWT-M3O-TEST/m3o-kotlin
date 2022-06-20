
package examples.app.run

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.app
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ApprunRequest(name = "Jone")
  
  try {
      val response = AppService.run(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
