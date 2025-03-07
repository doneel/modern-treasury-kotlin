package com.moderntreasury.api.models

import com.moderntreasury.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExternalAccountListParamsTest {

    @Test
    fun createExternalAccountListParams() {
        ExternalAccountListParams.builder()
            .afterCursor("string")
            .perPage(123L)
            .partyName("string")
            .counterpartyId("string")
            .metadata(ExternalAccountListParams.Metadata.builder().build())
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            ExternalAccountListParams.builder()
                .afterCursor("string")
                .perPage(123L)
                .partyName("string")
                .counterpartyId("string")
                .metadata(ExternalAccountListParams.Metadata.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("after_cursor", listOf("string"))
        expected.put("per_page", listOf("123"))
        expected.put("party_name", listOf("string"))
        expected.put("counterparty_id", listOf("string"))
        ExternalAccountListParams.Metadata.builder().build().forEachQueryParam { key, values ->
            expected.put("metadata[$key]", values)
        }
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = ExternalAccountListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
