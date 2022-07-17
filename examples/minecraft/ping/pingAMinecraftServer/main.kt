
package examples.minecraft.ping

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.minecraft

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = MinecraftPingRequest(Address = "funcraft.net",)
  
  try {
      val response = MinecraftServ.ping(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
