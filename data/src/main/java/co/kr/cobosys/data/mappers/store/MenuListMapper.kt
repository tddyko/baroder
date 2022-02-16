package co.kr.cobosys.data.mappers.store

import co.kr.cobosys.data.api.MenuListResponse
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.MenuList

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