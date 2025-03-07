@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.moderntreasury.api.services.blocking

import com.moderntreasury.api.core.RequestOptions
import com.moderntreasury.api.models.PaperItem
import com.moderntreasury.api.models.PaperItemListPage
import com.moderntreasury.api.models.PaperItemListParams
import com.moderntreasury.api.models.PaperItemRetrieveParams

interface PaperItemService {

    /** Get details on a single paper item. */
    fun retrieve(
        params: PaperItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PaperItem

    /** Get a list of all paper items. */
    fun list(
        params: PaperItemListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PaperItemListPage
}
