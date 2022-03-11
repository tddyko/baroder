package co.kr.cobosys.data.repos.point

import co.kr.cobosys.data.datasources.point.GetPointDataSource
import co.kr.cobosys.data.mappers.point.toPointModel
import co.kr.cobosys.domain.models.PointModel
import co.kr.cobosys.domain.repos.point.PointRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PointRepoImpl @Inject constructor(
    private val dataSource: GetPointDataSource
) : PointRepo {
    override fun getPoint(token: String):
            Flow<PointModel> = dataSource.getPointList(token).map { it.toPointModel() }
}
