package com.moderntreasury.api.models

import com.moderntreasury.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExternalAccountVerifyParamsTest {

    @Test
    fun createExternalAccountVerifyParams() {
        ExternalAccountVerifyParams.builder()
            .id("string")
            .originatingAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .paymentType(ExternalAccountVerifyParams.PaymentType.ACH)
            .currency(Currency.AED)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ExternalAccountVerifyParams.builder()
                .id("string")
                .originatingAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentType(ExternalAccountVerifyParams.PaymentType.ACH)
                .currency(Currency.AED)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.originatingAccountId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.paymentType()).isEqualTo(ExternalAccountVerifyParams.PaymentType.ACH)
        assertThat(body.currency()).isEqualTo(Currency.AED)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            ExternalAccountVerifyParams.builder()
                .id("string")
                .originatingAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentType(ExternalAccountVerifyParams.PaymentType.ACH)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.originatingAccountId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.paymentType()).isEqualTo(ExternalAccountVerifyParams.PaymentType.ACH)
    }

    @Test
    fun getPathParam() {
        val params =
            ExternalAccountVerifyParams.builder()
                .id("string")
                .originatingAccountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .paymentType(ExternalAccountVerifyParams.PaymentType.ACH)
                .build()
        assertThat(params).isNotNull
        // path param "id"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
