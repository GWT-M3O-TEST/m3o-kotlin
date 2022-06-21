
package com.m3o.m3okotlin.services.wordle

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "wordle"

object WordleService {
    suspend fun guess(req: WordleGuessRequest): WordleGuessResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Guess")) {
          body = req
        }
    }
}
    suspend fun next(): WordleNextResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Next")) 
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
