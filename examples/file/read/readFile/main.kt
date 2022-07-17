
package examples.file.read

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.file

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = FileReadRequest(Project = "examples",
Path = "/document/text-files/file.txt",)
  
  try {
      val response = FileServ.read(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
