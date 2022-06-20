
package examples.weather.now

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.weather
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = WeathernowRequest(name = "Jone")
  
  try {
      val response = WeatherService.now(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
