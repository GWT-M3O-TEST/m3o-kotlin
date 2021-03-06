
package examples.app.status

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.app

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = AppStatusRequest(Name = "helloworld",)
  
  try {
      val response = AppServ.status(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
