
package examples.weather.forecast

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.weather
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = WeatherforecastRequest(name = "Jone")
  
  try {
      val response = WeatherService.forecast(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
