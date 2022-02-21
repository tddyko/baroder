package co.kr.cobosys.domain.usecases.store

import co.kr.cobosys.domain.base.usecases.GeneralUseCase
import co.kr.cobosys.domain.models.MenuList
import co.kr.cobosys.domain.repos.store.MenuListRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMenuListRepo @Inject constructor(
    private val menuList: MenuListRepo
) : GeneralUseCase<Flow<MenuList>> {
    override suspend fun invoke(): Flow<MenuList> =
        menuList.getMenuList()
}