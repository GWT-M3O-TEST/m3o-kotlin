
package examples.app.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.app
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ApplistRequest(name = "Jone")
  
  try {
      val response = AppService.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
