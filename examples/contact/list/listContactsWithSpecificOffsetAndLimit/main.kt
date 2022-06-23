
package examples.contact.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.contact

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ContactListRequest(Offset = 1,
Limit = 1,)
  
  try {
      val response = ContactService.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
