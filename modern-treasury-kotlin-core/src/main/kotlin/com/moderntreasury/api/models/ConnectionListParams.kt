package com.moderntreasury.api.models

import com.moderntreasury.api.core.NoAutoDetect
import com.moderntreasury.api.core.toUnmodifiable
import com.moderntreasury.api.models.*
import java.util.Objects

class ConnectionListParams
constructor(
    private val afterCursor: String?,
    private val perPage: Long?,
    private val vendorCustomerId: String?,
    private val entity: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun afterCursor(): String? = afterCursor

    fun perPage(): Long? = perPage

    fun vendorCustomerId(): String? = vendorCustomerId

    fun entity(): String? = entity

    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.afterCursor?.let { params.put("after_cursor", listOf(it.toString())) }
        this.perPage?.let { params.put("per_page", listOf(it.toString())) }
        this.vendorCustomerId?.let { params.put("vendor_customer_id", listOf(it.toString())) }
        this.entity?.let { params.put("entity", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ConnectionListParams &&
            this.afterCursor == other.afterCursor &&
            this.perPage == other.perPage &&
            this.vendorCustomerId == other.vendorCustomerId &&
            this.entity == other.entity &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            afterCursor,
            perPage,
            vendorCustomerId,
            entity,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "ConnectionListParams{afterCursor=$afterCursor, perPage=$perPage, vendorCustomerId=$vendorCustomerId, entity=$entity, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var afterCursor: String? = null
        private var perPage: Long? = null
        private var vendorCustomerId: String? = null
        private var entity: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        internal fun from(connectionListParams: ConnectionListParams) = apply {
            this.afterCursor = connectionListParams.afterCursor
            this.perPage = connectionListParams.perPage
            this.vendorCustomerId = connectionListParams.vendorCustomerId
            this.entity = connectionListParams.entity
            additionalQueryParams(connectionListParams.additionalQueryParams)
            additionalHeaders(connectionListParams.additionalHeaders)
        }

        fun afterCursor(afterCursor: String) = apply { this.afterCursor = afterCursor }

        fun perPage(perPage: Long) = apply { this.perPage = perPage }

        /** An identifier assigned by the vendor to your organization. */
        fun vendorCustomerId(vendorCustomerId: String) = apply {
            this.vendorCustomerId = vendorCustomerId
        }

        /** A string code representing the vendor (i.e. bank). */
        fun entity(entity: String) = apply { this.entity = entity }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun build(): ConnectionListParams =
            ConnectionListParams(
                afterCursor,
                perPage,
                vendorCustomerId,
                entity,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }
}
