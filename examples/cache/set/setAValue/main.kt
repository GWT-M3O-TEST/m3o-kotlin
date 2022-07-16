
package examples.cache.set

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.cache

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CacheSetRequest(Key = "foo",
Value = "bar",)
  
  try {
      val response = CacheService.set(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
