
package examples.app.run

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.app

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = AppRunRequest(Region = "europe-west1",
Name = "helloworld",
Repo = "github.com/asim/helloworld",
Branch = "master",
Port = 8080,)
  
  try {
      val response = AppService.run(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
