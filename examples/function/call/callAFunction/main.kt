
package examples.function.call

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.function

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = FunctionCallRequest(Request: &function.Json{
},
Name = "helloworld",)
  
  try {
      val response = FunctionService.call(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
