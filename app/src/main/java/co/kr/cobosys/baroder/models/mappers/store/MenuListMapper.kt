package co.kr.cobosys.baroder.models.mappers.store

import co.kr.cobosys.baroder.models.MenuListUI
import co.kr.cobosys.domain.base.mappers.Mapper
import co.kr.cobosys.domain.models.MenuList

class MenuListMapper: Mapper<MenuList, MenuListUI> {
    override fun mapLeftToRight(obj: MenuList): MenuListUI = with(obj){
        MenuListUI(
            menu = menu,
            product = product.map { product ->
                ProductListMapper().mapLeftToRight(product)
            }
        )
    }

}