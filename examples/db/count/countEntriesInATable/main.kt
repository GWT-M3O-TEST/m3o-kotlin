
package examples.db.count

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.db

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DbCountRequest(Table = "example",)
  
  try {
      val response = DbServ.count(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
