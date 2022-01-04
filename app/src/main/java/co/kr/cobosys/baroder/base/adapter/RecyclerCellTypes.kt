package co.kr.cobosys.baroder.base.adapter

import kotlin.RuntimeException

class RecyclerCellTypes<T, R>(vararg types: RecyclerCell<T, R>) {

    private val cellTypesList: ArrayList<RecyclerCell<T, R>> = ArrayList()

    init { types.forEach { addType(it) } }

    private fun addType(type: RecyclerCell<T, R>) {
        cellTypesList.add(type)
    }

    fun of(item: T?): RecyclerCell<T, R> {
        for (cellType in cellTypesList) {
            if (cellType.belongsTo(item)) return cellType
        }
        throw NoSuchRecyclerItemTypeException()
    }

    fun of(viewType: Int): RecyclerCell<T, R> {
        for (cellType in cellTypesList) {
            if (cellType.type() == viewType) return cellType
        }
        throw NoSuchRecyclerViewTypeException()
    }
}
class NoSuchRecyclerItemTypeException: RuntimeException()
class NoSuchRecyclerViewTypeException: RuntimeException()
