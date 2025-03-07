package com.moderntreasury.api.models

import com.moderntreasury.api.core.NoAutoDetect
import com.moderntreasury.api.core.toUnmodifiable
import com.moderntreasury.api.models.*
import java.time.LocalDate
import java.util.Objects

class PaperItemListParams
constructor(
    private val lockboxNumber: String?,
    private val depositDateStart: LocalDate?,
    private val depositDateEnd: LocalDate?,
    private val afterCursor: String?,
    private val perPage: Long?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun lockboxNumber(): String? = lockboxNumber

    fun depositDateStart(): LocalDate? = depositDateStart

    fun depositDateEnd(): LocalDate? = depositDateEnd

    fun afterCursor(): String? = afterCursor

    fun perPage(): Long? = perPage

    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.lockboxNumber?.let { params.put("lockbox_number", listOf(it.toString())) }
        this.depositDateStart?.let { params.put("deposit_date_start", listOf(it.toString())) }
        this.depositDateEnd?.let { params.put("deposit_date_end", listOf(it.toString())) }
        this.afterCursor?.let { params.put("after_cursor", listOf(it.toString())) }
        this.perPage?.let { params.put("per_page", listOf(it.toString())) }
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

        return other is PaperItemListParams &&
            this.lockboxNumber == other.lockboxNumber &&
            this.depositDateStart == other.depositDateStart &&
            this.depositDateEnd == other.depositDateEnd &&
            this.afterCursor == other.afterCursor &&
            this.perPage == other.perPage &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            lockboxNumber,
            depositDateStart,
            depositDateEnd,
            afterCursor,
            perPage,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "PaperItemListParams{lockboxNumber=$lockboxNumber, depositDateStart=$depositDateStart, depositDateEnd=$depositDateEnd, afterCursor=$afterCursor, perPage=$perPage, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var lockboxNumber: String? = null
        private var depositDateStart: LocalDate? = null
        private var depositDateEnd: LocalDate? = null
        private var afterCursor: String? = null
        private var perPage: Long? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        internal fun from(paperItemListParams: PaperItemListParams) = apply {
            this.lockboxNumber = paperItemListParams.lockboxNumber
            this.depositDateStart = paperItemListParams.depositDateStart
            this.depositDateEnd = paperItemListParams.depositDateEnd
            this.afterCursor = paperItemListParams.afterCursor
            this.perPage = paperItemListParams.perPage
            additionalQueryParams(paperItemListParams.additionalQueryParams)
            additionalHeaders(paperItemListParams.additionalHeaders)
        }

        /**
         * Specify `lockbox_number` if you wish to see paper items that are associated with a
         * specific lockbox number.
         */
        fun lockboxNumber(lockboxNumber: String) = apply { this.lockboxNumber = lockboxNumber }

        /** Specify an inclusive start date (YYYY-MM-DD) when filtering by deposit_date */
        fun depositDateStart(depositDateStart: LocalDate) = apply {
            this.depositDateStart = depositDateStart
        }

        /** Specify an inclusive end date (YYYY-MM-DD) when filtering by deposit_date */
        fun depositDateEnd(depositDateEnd: LocalDate) = apply {
            this.depositDateEnd = depositDateEnd
        }

        fun afterCursor(afterCursor: String) = apply { this.afterCursor = afterCursor }

        fun perPage(perPage: Long) = apply { this.perPage = perPage }

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

        fun build(): PaperItemListParams =
            PaperItemListParams(
                lockboxNumber,
                depositDateStart,
                depositDateEnd,
                afterCursor,
                perPage,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }
}
