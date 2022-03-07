package co.kr.cobosys.domain.usecases.store


import android.os.Parcelable
import co.kr.cobosys.domain.base.usecases.GeneralParamsUseCase
import co.kr.cobosys.domain.models.StoreModel
import co.kr.cobosys.domain.repos.store.StoreRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

class GetStoreListUseCase @Inject constructor(
    private val storeList: StoreRepo
) : GeneralParamsUseCase<Flow<StoreModel>, GetStoreListParams> {
    override suspend fun invoke(params: GetStoreListParams): Flow<StoreModel> =
        storeList.getStore(params.token, params.latitude, params.longitude, params.options)
}

@Parcelize
data class GetStoreListParams(val token: String, val latitude: Double, val longitude: Double, val options: Int) :
    Parcelable