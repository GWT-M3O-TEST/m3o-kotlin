
package examples.lists.create

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.lists

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ListsCreateRequest(Items = listOf(String){
"This is my list",
},)
  
  try {
      val response = ListsService.create(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
