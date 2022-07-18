
package examples.file.save

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.file

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = FileSaveRequest(File: &file.Record{
Path = "/document/text-files/file.txt",
Project = "examples",
Content = "file content example",
},)
  
  try {
      val response = FileServ.save(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
