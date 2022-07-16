
package com.m3o.m3okotlin.services.weather

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "weather"

object WeatherService {
      suspend fun forecast(req: WeatherForecastRequest): WeatherForecastResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Forecast")) {
          body = req
        }
      }
      suspend fun now(req: WeatherNowRequest): WeatherNowResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Now")) {
          body = req
        }
      }
}
@Serializable
data class WeatherForecast(val min_temp_c: Double, val will_it_rain: Boolean, val avg_temp_f: Double, val date: String, val max_temp_f: Double, val max_wind_mph: Double, val sunrise: String, val chance_of_rain: Int, val condition: String, val max_temp_c: Double, val min_temp_f: Double, val avg_temp_c: Double, val icon_url: String, val max_wind_kph: Double, val sunset: String)
@Serializable
data class WeatherForecastRequest(val location: String, val days: Int)
@Serializable
data class WeatherForecastResponse(val longitude: Double, val region: String, val timezone: String, val country: String, val forecast: List<WeatherForecast>, val latitude: Double, val local_time: String, val location: String)
@Serializable
data class WeatherNowRequest(val location: String)
@Serializable
data class WeatherNowResponse(val feels_like_f: Double, val region: String, val wind_kph: Double, val wind_mph: Double, val country: String, val daytime: Boolean, val location: String, val temp_f: Double, val timezone: String, val latitude: Double, val longitude: Double, val temp_c: Double, val wind_direction: String, val local_time: String, val wind_degree: Int, val cloud: Int, val condition: String, val feels_like_c: Double, val humidity: Int, val icon_url: String)
