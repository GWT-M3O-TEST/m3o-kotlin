
package examples.evchargers.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.evchargers

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = EvchargersSearchRequest(Location: &evchargers.Coordinates{
Latitude = 51.53336351319885,
Longitude = -0.0252,
},
Distance = 2000,
MaxResults = 2,
Levels = listOf(String){
"3",
},)
  
  try {
      val response = EvchargersServ.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
