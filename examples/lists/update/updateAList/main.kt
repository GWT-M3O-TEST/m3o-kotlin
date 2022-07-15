
package examples.lists.update

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.lists

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ListsUpdateRequest(List: &lists.List{
Id = "63c0cdf8-2121-11ec-a881-0242e36f037a",
Items = listOf(String){
"Updated list text",
},
},)
  
  try {
      val response = ListsService.update(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
