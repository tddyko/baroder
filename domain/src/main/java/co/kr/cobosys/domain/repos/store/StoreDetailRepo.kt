package co.kr.cobosys.domain.repos.store

import co.kr.cobosys.domain.models.StoreDetailModel


interface StoreDetailRepo {
    fun getStoreDetail(ids: String): StoreDetailModel
}