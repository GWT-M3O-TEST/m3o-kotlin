
package examples.prayer.times

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.prayer
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PrayertimesRequest(name = "Jone")
  
  try {
      val response = PrayerService.times(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
