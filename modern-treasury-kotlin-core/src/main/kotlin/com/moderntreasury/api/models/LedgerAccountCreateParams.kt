package com.moderntreasury.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.moderntreasury.api.core.ExcludeMissing
import com.moderntreasury.api.core.JsonField
import com.moderntreasury.api.core.JsonValue
import com.moderntreasury.api.core.NoAutoDetect
import com.moderntreasury.api.core.toUnmodifiable
import com.moderntreasury.api.errors.ModernTreasuryInvalidDataException
import com.moderntreasury.api.models.*
import java.util.Objects

class LedgerAccountCreateParams
constructor(
    private val currency: String,
    private val ledgerId: String,
    private val name: String,
    private val normalBalance: NormalBalance,
    private val currencyExponent: Long?,
    private val description: String?,
    private val ledgerableId: String?,
    private val ledgerableType: LedgerableType?,
    private val metadata: Metadata?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun currency(): String = currency

    fun ledgerId(): String = ledgerId

    fun name(): String = name

    fun normalBalance(): NormalBalance = normalBalance

    fun currencyExponent(): Long? = currencyExponent

    fun description(): String? = description

    fun ledgerableId(): String? = ledgerableId

    fun ledgerableType(): LedgerableType? = ledgerableType

    fun metadata(): Metadata? = metadata

    internal fun getBody(): LedgerAccountCreateBody {
        return LedgerAccountCreateBody(
            currency,
            ledgerId,
            name,
            normalBalance,
            currencyExponent,
            description,
            ledgerableId,
            ledgerableType,
            metadata,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(builder = LedgerAccountCreateBody.Builder::class)
    @NoAutoDetect
    class LedgerAccountCreateBody
    internal constructor(
        private val currency: String?,
        private val ledgerId: String?,
        private val name: String?,
        private val normalBalance: NormalBalance?,
        private val currencyExponent: Long?,
        private val description: String?,
        private val ledgerableId: String?,
        private val ledgerableType: LedgerableType?,
        private val metadata: Metadata?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The currency of the ledger account. */
        @JsonProperty("currency") fun currency(): String? = currency

        /** The id of the ledger that this account belongs to. */
        @JsonProperty("ledger_id") fun ledgerId(): String? = ledgerId

        /** The name of the ledger account. */
        @JsonProperty("name") fun name(): String? = name

        /** The normal balance of the ledger account. */
        @JsonProperty("normal_balance") fun normalBalance(): NormalBalance? = normalBalance

        /** The currency exponent of the ledger account. */
        @JsonProperty("currency_exponent") fun currencyExponent(): Long? = currencyExponent

        /** The description of the ledger account. */
        @JsonProperty("description") fun description(): String? = description

        /**
         * If the ledger account links to another object in Modern Treasury, the id will be
         * populated here, otherwise null.
         */
        @JsonProperty("ledgerable_id") fun ledgerableId(): String? = ledgerableId

        /**
         * If the ledger account links to another object in Modern Treasury, the type will be
         * populated here, otherwise null. The value is one of internal_account or external_account.
         */
        @JsonProperty("ledgerable_type") fun ledgerableType(): LedgerableType? = ledgerableType

        /**
         * Additional data represented as key-value pairs. Both the key and value must be strings.
         */
        @JsonProperty("metadata") fun metadata(): Metadata? = metadata

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LedgerAccountCreateBody &&
                this.currency == other.currency &&
                this.ledgerId == other.ledgerId &&
                this.name == other.name &&
                this.normalBalance == other.normalBalance &&
                this.currencyExponent == other.currencyExponent &&
                this.description == other.description &&
                this.ledgerableId == other.ledgerableId &&
                this.ledgerableType == other.ledgerableType &&
                this.metadata == other.metadata &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        currency,
                        ledgerId,
                        name,
                        normalBalance,
                        currencyExponent,
                        description,
                        ledgerableId,
                        ledgerableType,
                        metadata,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "LedgerAccountCreateBody{currency=$currency, ledgerId=$ledgerId, name=$name, normalBalance=$normalBalance, currencyExponent=$currencyExponent, description=$description, ledgerableId=$ledgerableId, ledgerableType=$ledgerableType, metadata=$metadata, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var currency: String? = null
            private var ledgerId: String? = null
            private var name: String? = null
            private var normalBalance: NormalBalance? = null
            private var currencyExponent: Long? = null
            private var description: String? = null
            private var ledgerableId: String? = null
            private var ledgerableType: LedgerableType? = null
            private var metadata: Metadata? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(ledgerAccountCreateBody: LedgerAccountCreateBody) = apply {
                this.currency = ledgerAccountCreateBody.currency
                this.ledgerId = ledgerAccountCreateBody.ledgerId
                this.name = ledgerAccountCreateBody.name
                this.normalBalance = ledgerAccountCreateBody.normalBalance
                this.currencyExponent = ledgerAccountCreateBody.currencyExponent
                this.description = ledgerAccountCreateBody.description
                this.ledgerableId = ledgerAccountCreateBody.ledgerableId
                this.ledgerableType = ledgerAccountCreateBody.ledgerableType
                this.metadata = ledgerAccountCreateBody.metadata
                additionalProperties(ledgerAccountCreateBody.additionalProperties)
            }

            /** The currency of the ledger account. */
            @JsonProperty("currency")
            fun currency(currency: String) = apply { this.currency = currency }

            /** The id of the ledger that this account belongs to. */
            @JsonProperty("ledger_id")
            fun ledgerId(ledgerId: String) = apply { this.ledgerId = ledgerId }

            /** The name of the ledger account. */
            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            /** The normal balance of the ledger account. */
            @JsonProperty("normal_balance")
            fun normalBalance(normalBalance: NormalBalance) = apply {
                this.normalBalance = normalBalance
            }

            /** The currency exponent of the ledger account. */
            @JsonProperty("currency_exponent")
            fun currencyExponent(currencyExponent: Long) = apply {
                this.currencyExponent = currencyExponent
            }

            /** The description of the ledger account. */
            @JsonProperty("description")
            fun description(description: String) = apply { this.description = description }

            /**
             * If the ledger account links to another object in Modern Treasury, the id will be
             * populated here, otherwise null.
             */
            @JsonProperty("ledgerable_id")
            fun ledgerableId(ledgerableId: String) = apply { this.ledgerableId = ledgerableId }

            /**
             * If the ledger account links to another object in Modern Treasury, the type will be
             * populated here, otherwise null. The value is one of internal_account or
             * external_account.
             */
            @JsonProperty("ledgerable_type")
            fun ledgerableType(ledgerableType: LedgerableType) = apply {
                this.ledgerableType = ledgerableType
            }

            /**
             * Additional data represented as key-value pairs. Both the key and value must be
             * strings.
             */
            @JsonProperty("metadata")
            fun metadata(metadata: Metadata) = apply { this.metadata = metadata }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): LedgerAccountCreateBody =
                LedgerAccountCreateBody(
                    checkNotNull(currency) { "`currency` is required but was not set" },
                    checkNotNull(ledgerId) { "`ledgerId` is required but was not set" },
                    checkNotNull(name) { "`name` is required but was not set" },
                    checkNotNull(normalBalance) { "`normalBalance` is required but was not set" },
                    currencyExponent,
                    description,
                    ledgerableId,
                    ledgerableType,
                    metadata,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is LedgerAccountCreateParams &&
            this.currency == other.currency &&
            this.ledgerId == other.ledgerId &&
            this.name == other.name &&
            this.normalBalance == other.normalBalance &&
            this.currencyExponent == other.currencyExponent &&
            this.description == other.description &&
            this.ledgerableId == other.ledgerableId &&
            this.ledgerableType == other.ledgerableType &&
            this.metadata == other.metadata &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            currency,
            ledgerId,
            name,
            normalBalance,
            currencyExponent,
            description,
            ledgerableId,
            ledgerableType,
            metadata,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "LedgerAccountCreateParams{currency=$currency, ledgerId=$ledgerId, name=$name, normalBalance=$normalBalance, currencyExponent=$currencyExponent, description=$description, ledgerableId=$ledgerableId, ledgerableType=$ledgerableType, metadata=$metadata, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var currency: String? = null
        private var ledgerId: String? = null
        private var name: String? = null
        private var normalBalance: NormalBalance? = null
        private var currencyExponent: Long? = null
        private var description: String? = null
        private var ledgerableId: String? = null
        private var ledgerableType: LedgerableType? = null
        private var metadata: Metadata? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(ledgerAccountCreateParams: LedgerAccountCreateParams) = apply {
            this.currency = ledgerAccountCreateParams.currency
            this.ledgerId = ledgerAccountCreateParams.ledgerId
            this.name = ledgerAccountCreateParams.name
            this.normalBalance = ledgerAccountCreateParams.normalBalance
            this.currencyExponent = ledgerAccountCreateParams.currencyExponent
            this.description = ledgerAccountCreateParams.description
            this.ledgerableId = ledgerAccountCreateParams.ledgerableId
            this.ledgerableType = ledgerAccountCreateParams.ledgerableType
            this.metadata = ledgerAccountCreateParams.metadata
            additionalQueryParams(ledgerAccountCreateParams.additionalQueryParams)
            additionalHeaders(ledgerAccountCreateParams.additionalHeaders)
            additionalBodyProperties(ledgerAccountCreateParams.additionalBodyProperties)
        }

        /** The currency of the ledger account. */
        fun currency(currency: String) = apply { this.currency = currency }

        /** The id of the ledger that this account belongs to. */
        fun ledgerId(ledgerId: String) = apply { this.ledgerId = ledgerId }

        /** The name of the ledger account. */
        fun name(name: String) = apply { this.name = name }

        /** The normal balance of the ledger account. */
        fun normalBalance(normalBalance: NormalBalance) = apply {
            this.normalBalance = normalBalance
        }

        /** The currency exponent of the ledger account. */
        fun currencyExponent(currencyExponent: Long) = apply {
            this.currencyExponent = currencyExponent
        }

        /** The description of the ledger account. */
        fun description(description: String) = apply { this.description = description }

        /**
         * If the ledger account links to another object in Modern Treasury, the id will be
         * populated here, otherwise null.
         */
        fun ledgerableId(ledgerableId: String) = apply { this.ledgerableId = ledgerableId }

        /**
         * If the ledger account links to another object in Modern Treasury, the type will be
         * populated here, otherwise null. The value is one of internal_account or external_account.
         */
        fun ledgerableType(ledgerableType: LedgerableType) = apply {
            this.ledgerableType = ledgerableType
        }

        /**
         * Additional data represented as key-value pairs. Both the key and value must be strings.
         */
        fun metadata(metadata: Metadata) = apply { this.metadata = metadata }

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

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): LedgerAccountCreateParams =
            LedgerAccountCreateParams(
                checkNotNull(currency) { "`currency` is required but was not set" },
                checkNotNull(ledgerId) { "`ledgerId` is required but was not set" },
                checkNotNull(name) { "`name` is required but was not set" },
                checkNotNull(normalBalance) { "`normalBalance` is required but was not set" },
                currencyExponent,
                description,
                ledgerableId,
                ledgerableType,
                metadata,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    class NormalBalance
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is NormalBalance && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val CREDIT = NormalBalance(JsonField.of("credit"))

            val DEBIT = NormalBalance(JsonField.of("debit"))

            fun of(value: String) = NormalBalance(JsonField.of(value))
        }

        enum class Known {
            CREDIT,
            DEBIT,
        }

        enum class Value {
            CREDIT,
            DEBIT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CREDIT -> Value.CREDIT
                DEBIT -> Value.DEBIT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CREDIT -> Known.CREDIT
                DEBIT -> Known.DEBIT
                else -> throw ModernTreasuryInvalidDataException("Unknown NormalBalance: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class LedgerableType
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is LedgerableType && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val EXTERNAL_ACCOUNT = LedgerableType(JsonField.of("external_account"))

            val INTERNAL_ACCOUNT = LedgerableType(JsonField.of("internal_account"))

            fun of(value: String) = LedgerableType(JsonField.of(value))
        }

        enum class Known {
            EXTERNAL_ACCOUNT,
            INTERNAL_ACCOUNT,
        }

        enum class Value {
            EXTERNAL_ACCOUNT,
            INTERNAL_ACCOUNT,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                EXTERNAL_ACCOUNT -> Value.EXTERNAL_ACCOUNT
                INTERNAL_ACCOUNT -> Value.INTERNAL_ACCOUNT
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                EXTERNAL_ACCOUNT -> Known.EXTERNAL_ACCOUNT
                INTERNAL_ACCOUNT -> Known.INTERNAL_ACCOUNT
                else -> throw ModernTreasuryInvalidDataException("Unknown LedgerableType: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    /** Additional data represented as key-value pairs. Both the key and value must be strings. */
    @JsonDeserialize(builder = Metadata.Builder::class)
    @NoAutoDetect
    class Metadata
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(metadata: Metadata) = apply {
                additionalProperties(metadata.additionalProperties)
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Metadata = Metadata(additionalProperties.toUnmodifiable())
        }
    }
}
