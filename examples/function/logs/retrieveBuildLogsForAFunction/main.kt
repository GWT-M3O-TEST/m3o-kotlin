
package examples.function.logs

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.function

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = FunctionLogsRequest(Name = "helloworld",
LogsType = "build",)
  
  try {
      val response = FunctionService.logs(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
