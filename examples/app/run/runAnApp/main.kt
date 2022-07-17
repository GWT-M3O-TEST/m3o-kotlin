
package examples.app.run

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.app

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = AppRunRequest(Name = "helloworld",
Repo = "github.com/asim/helloworld",
Branch = "master",
Port = 8080,
Region = "europe-west1",)
  
  try {
      val response = AppServ.run(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
