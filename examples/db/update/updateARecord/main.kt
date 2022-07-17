
package examples.db.update

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.db

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DbUpdateRequest(Table = "example",
Record: &db.Json{
},)
  
  try {
      val response = DbServ.update(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
