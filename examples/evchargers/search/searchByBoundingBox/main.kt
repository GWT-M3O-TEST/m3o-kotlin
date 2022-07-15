
package examples.evchargers.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.evchargers

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = EvchargersSearchRequest(Box: &evchargers.BoundingBox{
TopRight: &evchargers.Coordinates{
Latitude = 51.56717121807993,
Longitude = -0.002293530559768285,
},
BottomLeft: &evchargers.Coordinates{
Latitude = 51.52627543859447,
Longitude = -0.03635349400295168,
},
},
MaxResults = 2,)
  
  try {
      val response = EvchargersService.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
