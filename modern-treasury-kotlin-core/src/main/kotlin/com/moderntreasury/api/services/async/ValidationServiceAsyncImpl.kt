package com.moderntreasury.api.services.async

import com.moderntreasury.api.core.ClientOptions
import com.moderntreasury.api.core.RequestOptions
import com.moderntreasury.api.core.http.HttpMethod
import com.moderntreasury.api.core.http.HttpRequest
import com.moderntreasury.api.core.http.HttpResponse.Handler
import com.moderntreasury.api.errors.ModernTreasuryError
import com.moderntreasury.api.models.RoutingNumberLookupRequest
import com.moderntreasury.api.models.ValidationValidateRoutingNumberParams
import com.moderntreasury.api.services.errorHandler
import com.moderntreasury.api.services.jsonHandler
import com.moderntreasury.api.services.withErrorHandler

class ValidationServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ValidationServiceAsync {

    private val errorHandler: Handler<ModernTreasuryError> = errorHandler(clientOptions.jsonMapper)

    private val validateRoutingNumberHandler: Handler<RoutingNumberLookupRequest> =
        jsonHandler<RoutingNumberLookupRequest>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Validates the routing number information supplied without creating a routing detail */
    override suspend fun validateRoutingNumber(
        params: ValidationValidateRoutingNumberParams,
        requestOptions: RequestOptions
    ): RoutingNumberLookupRequest {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("api", "validations", "routing_numbers")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { validateRoutingNumberHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
