
package examples.holidays.countries

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.holidays

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = HolidaysCountriesRequest()
  
  try {
      val response = HolidaysServ.countries(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
