package co.kr.cobosys.domain.repos.store

import co.kr.cobosys.domain.models.MenuList
import kotlinx.coroutines.flow.Flow

interface MenuListRepo {
    fun getMenuList(): Flow<MenuList>
}