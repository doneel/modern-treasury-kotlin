package com.moderntreasury.api.models

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.moderntreasury.api.core.NoAutoDetect
import com.moderntreasury.api.core.toUnmodifiable
import com.moderntreasury.api.models.*
import java.time.OffsetDateTime
import java.util.Objects

class LedgerAccountCategoryListParams
constructor(
    private val afterCursor: String?,
    private val perPage: Long?,
    private val metadata: Metadata?,
    private val id: List<String>?,
    private val name: String?,
    private val ledgerId: String?,
    private val parentLedgerAccountCategoryId: String?,
    private val ledgerAccountId: String?,
    private val balances: Balances?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun afterCursor(): String? = afterCursor

    fun perPage(): Long? = perPage

    fun metadata(): Metadata? = metadata

    fun id(): List<String>? = id

    fun name(): String? = name

    fun ledgerId(): String? = ledgerId

    fun parentLedgerAccountCategoryId(): String? = parentLedgerAccountCategoryId

    fun ledgerAccountId(): String? = ledgerAccountId

    fun balances(): Balances? = balances

    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.afterCursor?.let { params.put("after_cursor", listOf(it.toString())) }
        this.perPage?.let { params.put("per_page", listOf(it.toString())) }
        this.metadata?.forEachQueryParam { key, values -> params.put("metadata[$key]", values) }
        this.id?.let { params.put("id[]", it.map(Any::toString)) }
        this.name?.let { params.put("name", listOf(it.toString())) }
        this.ledgerId?.let { params.put("ledger_id", listOf(it.toString())) }
        this.parentLedgerAccountCategoryId?.let {
            params.put("parent_ledger_account_category_id", listOf(it.toString()))
        }
        this.ledgerAccountId?.let { params.put("ledger_account_id", listOf(it.toString())) }
        this.balances?.forEachQueryParam { key, values -> params.put("balances[$key]", values) }
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

        return other is LedgerAccountCategoryListParams &&
            this.afterCursor == other.afterCursor &&
            this.perPage == other.perPage &&
            this.metadata == other.metadata &&
            this.id == other.id &&
            this.name == other.name &&
            this.ledgerId == other.ledgerId &&
            this.parentLedgerAccountCategoryId == other.parentLedgerAccountCategoryId &&
            this.ledgerAccountId == other.ledgerAccountId &&
            this.balances == other.balances &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            afterCursor,
            perPage,
            metadata,
            id,
            name,
            ledgerId,
            parentLedgerAccountCategoryId,
            ledgerAccountId,
            balances,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "LedgerAccountCategoryListParams{afterCursor=$afterCursor, perPage=$perPage, metadata=$metadata, id=$id, name=$name, ledgerId=$ledgerId, parentLedgerAccountCategoryId=$parentLedgerAccountCategoryId, ledgerAccountId=$ledgerAccountId, balances=$balances, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var afterCursor: String? = null
        private var perPage: Long? = null
        private var metadata: Metadata? = null
        private var id: MutableList<String> = mutableListOf()
        private var name: String? = null
        private var ledgerId: String? = null
        private var parentLedgerAccountCategoryId: String? = null
        private var ledgerAccountId: String? = null
        private var balances: Balances? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        internal fun from(ledgerAccountCategoryListParams: LedgerAccountCategoryListParams) =
            apply {
                this.afterCursor = ledgerAccountCategoryListParams.afterCursor
                this.perPage = ledgerAccountCategoryListParams.perPage
                this.metadata = ledgerAccountCategoryListParams.metadata
                this.id(ledgerAccountCategoryListParams.id ?: listOf())
                this.name = ledgerAccountCategoryListParams.name
                this.ledgerId = ledgerAccountCategoryListParams.ledgerId
                this.parentLedgerAccountCategoryId =
                    ledgerAccountCategoryListParams.parentLedgerAccountCategoryId
                this.ledgerAccountId = ledgerAccountCategoryListParams.ledgerAccountId
                this.balances = ledgerAccountCategoryListParams.balances
                additionalQueryParams(ledgerAccountCategoryListParams.additionalQueryParams)
                additionalHeaders(ledgerAccountCategoryListParams.additionalHeaders)
            }

        fun afterCursor(afterCursor: String) = apply { this.afterCursor = afterCursor }

        fun perPage(perPage: Long) = apply { this.perPage = perPage }

        /**
         * For example, if you want to query for records with metadata key `Type` and value `Loan`,
         * the query would be `metadata%5BType%5D=Loan`. This encodes the query parameters.
         */
        fun metadata(metadata: Metadata) = apply { this.metadata = metadata }

        /**
         * If you have specific IDs to retrieve in bulk, you can pass them as query parameters
         * delimited with `id[]=`, for example `?id[]=123&id[]=abc`.
         */
        fun id(id: List<String>) = apply {
            this.id.clear()
            this.id.addAll(id)
        }

        /**
         * If you have specific IDs to retrieve in bulk, you can pass them as query parameters
         * delimited with `id[]=`, for example `?id[]=123&id[]=abc`.
         */
        fun addId(id: String) = apply { this.id.add(id) }

        fun name(name: String) = apply { this.name = name }

        fun ledgerId(ledgerId: String) = apply { this.ledgerId = ledgerId }

        /** Query categories that are nested underneath a parent category */
        fun parentLedgerAccountCategoryId(parentLedgerAccountCategoryId: String) = apply {
            this.parentLedgerAccountCategoryId = parentLedgerAccountCategoryId
        }

        /** Query categories which contain a ledger account directly or through child categories. */
        fun ledgerAccountId(ledgerAccountId: String) = apply {
            this.ledgerAccountId = ledgerAccountId
        }

        /**
         * For example, if you want the balances as of a particular time (ISO8601), the encoded
         * query string would be `balances%5Beffective_at%5D=2000-12-31T12:00:00Z`. The balances as
         * of a time are inclusive of entries with that exact time.
         */
        fun balances(balances: Balances) = apply { this.balances = balances }

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

        fun build(): LedgerAccountCategoryListParams =
            LedgerAccountCategoryListParams(
                afterCursor,
                perPage,
                metadata,
                if (id.size == 0) null else id.toUnmodifiable(),
                name,
                ledgerId,
                parentLedgerAccountCategoryId,
                ledgerAccountId,
                balances,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }

    /**
     * For example, if you want the balances as of a particular time (ISO8601), the encoded query
     * string would be `balances%5Beffective_at%5D=2000-12-31T12:00:00Z`. The balances as of a time
     * are inclusive of entries with that exact time.
     */
    @JsonDeserialize(builder = Balances.Builder::class)
    @NoAutoDetect
    class Balances
    private constructor(
        private val effectiveAt: OffsetDateTime?,
        private val additionalProperties: Map<String, List<String>>,
    ) {

        private var hashCode: Int = 0

        fun effectiveAt(): OffsetDateTime? = effectiveAt

        fun _additionalProperties(): Map<String, List<String>> = additionalProperties

        internal fun forEachQueryParam(putParam: (String, List<String>) -> Unit) {
            this.effectiveAt?.let { putParam("effective_at", listOf(it.toString())) }
            this.additionalProperties.forEach { key, values -> putParam(key, values) }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Balances &&
                this.effectiveAt == other.effectiveAt &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(effectiveAt, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "Balances{effectiveAt=$effectiveAt, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var effectiveAt: OffsetDateTime? = null
            private var additionalProperties: MutableMap<String, List<String>> = mutableMapOf()

            internal fun from(balances: Balances) = apply {
                this.effectiveAt = balances.effectiveAt
                additionalProperties(balances.additionalProperties)
            }

            fun effectiveAt(effectiveAt: OffsetDateTime) = apply { this.effectiveAt = effectiveAt }

            fun additionalProperties(additionalProperties: Map<String, List<String>>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: List<String>) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, List<String>>) =
                apply {
                    this.additionalProperties.putAll(additionalProperties)
                }

            fun build(): Balances = Balances(effectiveAt, additionalProperties.toUnmodifiable())
        }
    }

    /**
     * For example, if you want to query for records with metadata key `Type` and value `Loan`, the
     * query would be `metadata%5BType%5D=Loan`. This encodes the query parameters.
     */
    @JsonDeserialize(builder = Metadata.Builder::class)
    @NoAutoDetect
    class Metadata
    private constructor(
        private val additionalProperties: Map<String, List<String>>,
    ) {

        private var hashCode: Int = 0

        fun _additionalProperties(): Map<String, List<String>> = additionalProperties

        internal fun forEachQueryParam(putParam: (String, List<String>) -> Unit) {
            this.additionalProperties.forEach { key, values -> putParam(key, values) }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Metadata && this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(additionalProperties)
            }
            return hashCode
        }

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, List<String>> = mutableMapOf()

            internal fun from(metadata: Metadata) = apply {
                additionalProperties(metadata.additionalProperties)
            }

            fun additionalProperties(additionalProperties: Map<String, List<String>>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: List<String>) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, List<String>>) =
                apply {
                    this.additionalProperties.putAll(additionalProperties)
                }

            fun build(): Metadata = Metadata(additionalProperties.toUnmodifiable())
        }
    }
}
