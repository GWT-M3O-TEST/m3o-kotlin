
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "spam"

object SpamService {
    suspend fun classify(name: String): SpamClassifyResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Classify")) {
          body = SpamClassifyRequest(name)
        }
    }
}
@Serializable
internal data class SpamClassifyRequest({/// The email address it has been sent from
String? from, /// the HTML version of the email body
String? html_body, /// The subject of the email
String? subject, /// the plain text version of the email body
String? text_body, /// The email address it is being sent to
String? to, /// The raw body of the email including headers etc per RFC 822. Alternatively, use the other parameters to correctly format the message
String? email_body,})
@Serializable
data class SpamClassifyResponse({/// The rules that have contributed to this score
List<String>? details, /// Is it spam? Returns true if its score is > 5
bool? is_spam, /// The score evaluated for this email. A higher number means it is more likely to be spam
double? score,})
