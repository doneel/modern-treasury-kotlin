package com.moderntreasury.api.models

import com.moderntreasury.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LedgerAccountCategoryAddLedgerAccountParamsTest {

    @Test
    fun createLedgerAccountCategoryAddLedgerAccountParams() {
        LedgerAccountCategoryAddLedgerAccountParams.builder()
            .id("string")
            .ledgerAccountId("string")
            .build()
    }

    @Test
    fun getPathParam() {
        val params =
            LedgerAccountCategoryAddLedgerAccountParams.builder()
                .id("string")
                .ledgerAccountId("string")
                .build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // path param "ledgerAccountId"
        assertThat(params.getPathParam(1)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
