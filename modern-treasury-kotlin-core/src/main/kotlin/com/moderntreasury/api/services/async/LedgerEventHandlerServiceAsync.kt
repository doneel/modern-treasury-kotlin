@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.moderntreasury.api.services.async

import com.moderntreasury.api.core.RequestOptions
import com.moderntreasury.api.models.LedgerEventHandlerCreateParams
import com.moderntreasury.api.models.LedgerEventHandlerCreateResponse
import com.moderntreasury.api.models.LedgerEventHandlerDeleteParams
import com.moderntreasury.api.models.LedgerEventHandlerDeleteResponse
import com.moderntreasury.api.models.LedgerEventHandlerListPageAsync
import com.moderntreasury.api.models.LedgerEventHandlerListParams
import com.moderntreasury.api.models.LedgerEventHandlerRetrieveParams
import com.moderntreasury.api.models.LedgerEventHandlerRetrieveResponse

interface LedgerEventHandlerServiceAsync {

    /** create ledger_event_handler */
    suspend fun create(
        params: LedgerEventHandlerCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LedgerEventHandlerCreateResponse

    /** Get details on a single ledger event handler. */
    suspend fun retrieve(
        params: LedgerEventHandlerRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LedgerEventHandlerRetrieveResponse

    /** Get a list of ledger event handlers. */
    suspend fun list(
        params: LedgerEventHandlerListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LedgerEventHandlerListPageAsync

    /** Archive a ledger event handler. */
    suspend fun delete(
        params: LedgerEventHandlerDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LedgerEventHandlerDeleteResponse
}
