package com.moderntreasury.api.services.async

import com.google.common.collect.ListMultimap
import com.google.common.io.BaseEncoding
import com.moderntreasury.api.core.ClientOptions
import com.moderntreasury.api.core.http.HttpResponse.Handler
import com.moderntreasury.api.errors.ModernTreasuryError
import com.moderntreasury.api.errors.ModernTreasuryInvalidDataException
import com.moderntreasury.api.services.errorHandler
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class WebhookServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : WebhookServiceAsync {

    private val errorHandler: Handler<ModernTreasuryError> = errorHandler(clientOptions.jsonMapper)

    override suspend fun getSignature(value: String, key: String): String {
        val mac: Mac = Mac.getInstance("HmacSHA256")
        mac.init(SecretKeySpec(key.toByteArray(), "HmacSHA256"))
        val bytes = mac.doFinal(value.toByteArray())
        return BaseEncoding.base16().lowerCase().encode(bytes)
    }

    override suspend fun validateSignature(
        payload: String,
        headers: ListMultimap<String, String>,
        key: String
    ): Boolean {
        val expectedSignature =
            headers.get("X-Signature").getOrNull(0)
                ?: throw ModernTreasuryInvalidDataException("Could not find an X-Signature header")
        val signature = getSignature(payload, key)
        return signature == expectedSignature
    }
}
