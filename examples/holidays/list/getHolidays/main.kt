
package examples.holidays.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.holidays

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = HolidaysListRequest(Year = 2022,
CountryCode = "GB",)
  
  try {
      val response = HolidaysService.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
