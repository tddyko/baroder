package co.kr.cobosys.data.mappers.store

import co.kr.cobosys.data.api.MenuListResponse
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.MenuList

class MenuListMapper: Mapper<MenuListResponse, MenuList> {
    override fun mapLeftToRight(obj: MenuListResponse): MenuList = with(obj){
        MenuList(
            menu = menu,
            product = product.map { product ->
                ProductListMapper().mapLeftToRight(product)
            }
        )
    }

}