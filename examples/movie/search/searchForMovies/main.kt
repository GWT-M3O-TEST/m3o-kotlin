
package examples.movie.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.movie

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = MovieSearchRequest(Language = "en-US",
Query = "inception",
Page = 1,
Region = "US",
Year = 2010,
PrimaryReleaseYear = 2010,)
  
  try {
      val response = MovieService.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
