package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.DNSRequest
import com.cyb3rko.m3okotlin.data.DNSResponse
import io.ktor.client.request.*

private const val SERVICE = "dns"

object DNSService {

    suspend fun query(name: String, type: String = ""): DNSResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Query")) {
            body = DNSRequest(name, type)
        }
    }
}