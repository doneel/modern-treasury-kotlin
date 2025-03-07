package com.moderntreasury.api.models

import com.moderntreasury.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TransactionLineItemListParamsTest {

    @Test
    fun createTransactionLineItemListParams() {
        TransactionLineItemListParams.builder()
            .transactionId("string")
            .afterCursor("string")
            .type(TransactionLineItemListParams.Type.ORIGINATING)
            .perPage(123L)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            TransactionLineItemListParams.builder()
                .transactionId("string")
                .afterCursor("string")
                .type(TransactionLineItemListParams.Type.ORIGINATING)
                .perPage(123L)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("after_cursor", listOf("string"))
        expected.put("type", listOf(TransactionLineItemListParams.Type.ORIGINATING.toString()))
        expected.put("per_page", listOf("123"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = TransactionLineItemListParams.builder().transactionId("string").build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getPathParam() {
        val params = TransactionLineItemListParams.builder().transactionId("string").build()
        assertThat(params).isNotNull
        // path param "transactionId"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
