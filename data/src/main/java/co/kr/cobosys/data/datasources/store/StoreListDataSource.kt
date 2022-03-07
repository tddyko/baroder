package co.kr.cobosys.data.datasources.store

import co.kr.cobosys.data.api.Request
import co.kr.cobosys.data.api.StoreResponseModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface StoreListDataSource {
    fun getStoreList(token: String, latitude: Double, longitude: Double, options: Int):
            Flow<StoreResponseModel>
}


class StoreListDataSourceImpl @Inject constructor(
    private val reqApi: Request
): StoreListDataSource {
    override fun getStoreList(token: String, latitude: Double, longitude: Double, options: Int):
            Flow<StoreResponseModel> = reqApi.checkStoreList(token, latitude, longitude, options)
}