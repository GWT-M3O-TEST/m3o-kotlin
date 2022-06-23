
package examples.app.logs

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.app

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = AppLogsRequest(Name = "helloworld",
LogsType = "build",)
  
  try {
      val response = AppService.logs(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
