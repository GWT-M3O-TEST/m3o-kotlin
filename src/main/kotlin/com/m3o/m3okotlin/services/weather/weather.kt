
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
internal data class WeatherForecast({/// chance of rain (percentage)
int? chance_of_rain, /// time of sunset
String? sunset, /// minimum temp in celsius
double? min_temp_c, /// minimum temp in fahrenheit
double? min_temp_f, /// time of sunrise
String? sunrise, /// will it rain
bool? will_it_rain, /// forecast condition
String? condition, /// date of the forecast
String? date, /// the URL of forecast condition icon. Simply prefix with either http or https to use it
String? icon_url, /// max wind speed mph
double? max_wind_mph, /// max wind speed kph
double? max_wind_kph, /// the average temp in celsius
double? avg_temp_c, /// the average temp in fahrenheit
double? avg_temp_f, /// max temp in celsius
double? max_temp_c, /// max temp in fahrenheit
double? max_temp_f,})
@Serializable
internal data class WeatherForecastRequest({/// location of the forecase
String? location, /// number of days. default 1, max 10
int? days,})
@Serializable
data class WeatherForecastResponse({/// e.g 37.55
double? latitude, /// the local time
String? local_time, /// location of the request
String? location, /// e.g -77.46
double? longitude, /// region related to the location
String? region, /// timezone of the location
String? timezone, /// country of the request
String? country, /// forecast for the next number of days
List<Forecast>? forecast,})
@Serializable
internal data class WeatherNowRequest({/// location to get weather e.g postcode, city
String? location,})
@Serializable
data class WeatherNowResponse({/// country of the request
String? country, /// e.g -77.46
double? longitude, /// wind direction
String? wind_direction, /// wind in mph
double? wind_mph, /// region related to the location
String? region, /// timezone of the location
String? timezone, /// wind in kph
double? wind_kph, /// the weather condition
String? condition, /// whether its daytime
bool? daytime, /// feels like in celsius
double? feels_like_c, /// the URL of the related icon. Simply prefix with either http or https to use it
String? icon_url, /// location of the request
String? location, /// temperature in celsius
double? temp_c, /// temperature in fahrenheit
double? temp_f, /// wind degree
int? wind_degree, /// cloud cover percentage
int? cloud, /// feels like in fahrenheit
double? feels_like_f, /// the humidity percentage
int? humidity, /// e.g 37.55
double? latitude, /// the local time
String? local_time,})
