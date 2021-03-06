
package examples.place.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.place

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PlaceSearchRequest(Query = "food",
Location = "51.5074577,-0.1297515",)
  
  try {
      val response = PlaceServ.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
