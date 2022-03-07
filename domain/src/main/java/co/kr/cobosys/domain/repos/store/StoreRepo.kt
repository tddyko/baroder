package co.kr.cobosys.domain.repos.store

import co.kr.cobosys.domain.models.StoreModel
import kotlinx.coroutines.flow.Flow

interface StoreRepo {
    fun getStore(token: String, latitude: Double, longitude: Double, options: Int): Flow<StoreModel>
}