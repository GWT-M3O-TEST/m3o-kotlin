
package examples.db.renameTable

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.db

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DbRenameTableRequest(To = "examples3",
From = "examples2",)
  
  try {
      val response = DbService.renameTable(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
