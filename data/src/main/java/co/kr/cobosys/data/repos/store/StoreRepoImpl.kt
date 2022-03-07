package co.kr.cobosys.data.repos.store

import co.kr.cobosys.data.datasources.store.StoreListDataSource
import co.kr.cobosys.data.mappers.store.toStoreModel
import co.kr.cobosys.domain.models.StoreModel
import co.kr.cobosys.domain.repos.store.StoreRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class StoreRepoImpl @Inject constructor(
    private val dataSource: StoreListDataSource
) : StoreRepo {
    override fun getStore(
        token: String,
        latitude: Double,
        longitude: Double,
        options: Int
    ): Flow<StoreModel> = dataSource.getStoreList(token, latitude, longitude, options).map { it.toStoreModel() }


}