
package examples.notes.read

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.notes

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = NotesReadRequest(Id = "63c0cdf8-2121-11ec-a881-0242e36f037a",)
  
  try {
      val response = NotesServ.read(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
