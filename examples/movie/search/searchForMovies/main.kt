
package examples.movie.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.movie

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = MovieSearchRequest(name = "Jone")
  
  try {
      val response = MovieService.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
