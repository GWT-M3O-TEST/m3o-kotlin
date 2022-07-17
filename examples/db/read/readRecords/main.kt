
package examples.db.read

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.db

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DbReadRequest(Table = "example",
Query = "age == 43",)
  
  try {
      val response = DbServ.read(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
