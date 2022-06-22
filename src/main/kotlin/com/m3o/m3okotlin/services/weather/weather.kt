
package com.m3o.m3okotlin.services.weather

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

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
data class WeatherForecast(val min_temp_f: Double, val chance_of_rain: Int, val date: String, val min_temp_c: Double, val sunset: String, val max_temp_f: Double, val max_wind_kph: Double, val sunrise: String, val condition: String, val max_temp_c: Double, val max_wind_mph: Double, val will_it_rain: Boolean, val avg_temp_c: Double, val avg_temp_f: Double, val icon_url: String)
@Serializable
data class WeatherForecastRequest(val days: Int, val location: String)
@Serializable
data class WeatherForecastResponse(val country: String, val forecast: List<WeatherForecast>, val latitude: Double, val local_time: String, val location: String, val longitude: Double, val region: String, val timezone: String)
@Serializable
data class WeatherNowRequest(val location: String)
@Serializable
data class WeatherNowResponse(val local_time: String, val longitude: Double, val region: String, val wind_kph: Double, val cloud: Int, val country: String, val humidity: Int, val timezone: String, val temp_c: Double, val wind_degree: Int, val wind_direction: String, val feels_like_c: Double, val feels_like_f: Double, val latitude: Double, val location: String, val wind_mph: Double, val condition: String, val daytime: Boolean, val icon_url: String, val temp_f: Double)
