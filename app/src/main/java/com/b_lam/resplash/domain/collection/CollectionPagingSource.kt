package com.b_lam.resplash.domain.collection

import androidx.annotation.StringRes
import com.b_lam.resplash.R
import com.b_lam.resplash.data.collection.CollectionService
import com.b_lam.resplash.data.collection.model.Collection
import com.b_lam.resplash.domain.BasePagingSource

class CollectionPagingSource(
    private val collectionService: CollectionService,
    private val order: Order
) : BasePagingSource<Collection>() {

    override suspend fun getPage(page: Int, perPage: Int): List<Collection> {
        return when (order) {
            Order.ALL -> collectionService.getCollections(page, perPage)
        }
    }

    companion object {

        enum class Order(@StringRes val titleRes: Int, val value: String) {
            ALL(R.string.order_all, "all"),
        }
    }
}
