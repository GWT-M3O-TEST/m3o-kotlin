package com.m3o.m3okotlin

import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*

object M3O {
    private const val BASE_URL = "https://api.m3o.com/v1"
    private const val BASE_URL_STREAM = "wss://api.m3o.com/v1"
    internal lateinit var authorization: Pair<String, String>
    internal lateinit var ktorHttpClient: HttpClient
    private lateinit var ktorHttpMultipartClient: HttpClient

    fun initialize(apiKey: String) {
        Log.initialize()
        Log.i("Initializing Ktor M3O Client...")

        if (!Regex("[a-zA-Z0-9]+").matches(apiKey) || apiKey.length > 64) {
            throw InvalidParameterException("The M3O API Key contains invalid characters or does not have 48 characters.")
        }

        authorization = "Authorization" to "Bearer $apiKey"

        ktorHttpClient = HttpClient(Apache) {
            followRedirects = true
            expectSuccess = false

            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                    ignoreUnknownKeys = true
                })
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header(HttpHeaders.Authorization, authorization.second)
            }

            // Logging for debugging

//            install(Logging) {
//                logger = object : Logger {
//                    override fun log(message: String) {
//                        Log.i("Logger Ktor => $message")
//                    }
//
//                }
//                level = LogLevel.ALL
//            }
        }

        Log.i("Ktor M3O Client initialized.")
    }

    internal fun getKtorHttpMultipartClient(): HttpClient {
        if (!::ktorHttpMultipartClient.isInitialized) {
            ktorHttpMultipartClient = HttpClient(Apache) {
                install(DefaultRequest) {
                    header(HttpHeaders.Authorization, authorization.second)
                }

                // Logging for debugging

//                install(Logging) {
//                    logger = object : Logger {
//                        override fun log(message: String) {
//                            Log.i("Logger Ktor => $message")
//                        }
//
//                    }
//                    level = LogLevel.ALL
//                }
            }
            Log.i("Ktor M3O Multipart Client initialized.")
        }
        return ktorHttpMultipartClient
    }

    fun getUrl(service: String, endpoint: String, stream: Boolean = false): String {
        val url = if (!stream) BASE_URL else BASE_URL_STREAM
        return "$url/$service/$endpoint"
    }
}
