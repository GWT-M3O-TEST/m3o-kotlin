
package examples.file.save

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.file

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = FileSaveRequest(File: &file.Record{
Content = "file content example",
Path = "/document/text-files/file.txt",
Project = "examples",
},)
  
  try {
      val response = FileService.save(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
