
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
data class WeatherForecast(val condition: String, val date: String, val icon_url: String, val max_wind_mph: Double, val min_temp_f: Double, val sunset: String, val max_temp_c: Double, val max_temp_f: Double, val will_it_rain: Boolean, val chance_of_rain: Int, val min_temp_c: Double, val sunrise: String, val avg_temp_c: Double, val avg_temp_f: Double, val max_wind_kph: Double)
@Serializable
data class WeatherForecastRequest(val days: Int, val location: String)
@Serializable
data class WeatherForecastResponse(val forecast: List<WeatherForecast>, val latitude: Double, val local_time: String, val location: String, val longitude: Double, val region: String, val timezone: String, val country: String)
@Serializable
data class WeatherNowRequest(val location: String)
@Serializable
data class WeatherNowResponse(val daytime: Boolean, val region: String, val temp_c: Double, val wind_degree: Int, val timezone: String, val country: String, val humidity: Int, val icon_url: String, val location: String, val local_time: String, val longitude: Double, val wind_kph: Double, val wind_mph: Double, val condition: String, val feels_like_c: Double, val feels_like_f: Double, val latitude: Double, val cloud: Int, val temp_f: Double, val wind_direction: String)
