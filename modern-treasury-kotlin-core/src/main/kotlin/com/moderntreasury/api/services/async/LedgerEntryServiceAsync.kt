@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.moderntreasury.api.services.async

import com.moderntreasury.api.core.RequestOptions
import com.moderntreasury.api.models.LedgerEntry
import com.moderntreasury.api.models.LedgerEntryListPageAsync
import com.moderntreasury.api.models.LedgerEntryListParams
import com.moderntreasury.api.models.LedgerEntryRetrieveParams

interface LedgerEntryServiceAsync {

    /** Get details on a single ledger entry. */
    suspend fun retrieve(
        params: LedgerEntryRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LedgerEntry

    /** Get a list of all ledger entries. */
    suspend fun list(
        params: LedgerEntryListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): LedgerEntryListPageAsync
}
