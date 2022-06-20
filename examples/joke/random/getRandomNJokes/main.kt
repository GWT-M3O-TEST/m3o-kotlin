
package examples.joke.random

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.joke
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = JokerandomRequest(name = "Jone")
  
  try {
      val response = JokeService.random(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
