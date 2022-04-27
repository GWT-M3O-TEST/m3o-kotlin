
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "weather"

object WeatherService {
    suspend fun forecast(name: String): WeatherForecastResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Forecast")) {
          body = WeatherForecastRequest(name)
        }
    }
    suspend fun now(name: String): WeatherNowResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Now")) {
          body = WeatherNowRequest(name)
        }
    }
}
@Serializable
internal data class WeatherForecast(val max_wind_mph: Double, val min_temp_f: Double, val sunrise: String, val date: String, val icon_url: String, val max_wind_kph: Double, val will_it_rain: Boolean, val chance_of_rain: Int, val avg_temp_f: Double, val condition: String, val max_temp_c: Double, val max_temp_f: Double, val min_temp_c: Double, val sunset: String, val avg_temp_c: Double)
@Serializable
internal data class WeatherForecastRequest(val days: Int, val location: String)
@Serializable
data class WeatherForecastResponse(val country: String, val forecast: List<WeatherForecast>, val latitude: Double, val local_time: String, val location: String, val longitude: Double, val region: String, val timezone: String)
@Serializable
internal data class WeatherNowRequest(val location: String)
@Serializable
data class WeatherNowResponse(val humidity: Int, val icon_url: String, val temp_f: Double, val cloud: Int, val local_time: String, val temp_c: Double, val timezone: String, val daytime: Boolean, val feels_like_f: Double, val region: String, val wind_degree: Int, val wind_mph: Double, val feels_like_c: Double, val country: String, val latitude: Double, val location: String, val longitude: Double, val wind_direction: String, val wind_kph: Double, val condition: String)
