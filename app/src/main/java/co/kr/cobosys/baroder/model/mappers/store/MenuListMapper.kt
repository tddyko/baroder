package co.kr.cobosys.baroder.model.mappers.store

import co.kr.cobosys.baroder.model.MenuListUI
import co.kr.cobosys.domain.base.map.Mapper
import co.kr.cobosys.domain.model.MenuList

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