package co.kr.cobosys.data.datasources.point

import co.kr.cobosys.data.api.PointResponseModel
import co.kr.cobosys.data.api.Request
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface GetPointDataSource {
    fun getPointList(token: String): Flow<PointResponseModel>
}

class GetPointDataSourceImpl @Inject constructor(
    private val reqApi: Request
): GetPointDataSource {
    override fun getPointList(token: String):
            Flow<PointResponseModel> = reqApi.checkPointList(token)
}