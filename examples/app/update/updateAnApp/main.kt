
package examples.app.update

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.app

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = AppUpdateRequest(Name = "helloworld",)
  
  try {
      val response = AppServ.update(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
