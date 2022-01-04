package co.kr.cobosys.baroder.base.adapter

class PagerCellTypes<T, R>(vararg types: PagerCell<T, R>) {

    private val cellTypesList: ArrayList<PagerCell<T, R>> = ArrayList()

    init { types.forEach { addType(it) } }

    private fun addType(type: PagerCell<T, R>) {
        cellTypesList.add(type)
    }

    fun of(item: T?): PagerCell<T, R> {
        for (cellType in cellTypesList) {
            if (cellType.belongsTo(item)) return cellType
        }
        throw NoSuchRecyclerItemTypeException()
    }

    fun of(viewType: Int): PagerCell<T, R> {
        for (cellType in cellTypesList) {
            if (cellType.type() == viewType) return cellType
        }
        throw NoSuchRecyclerViewTypeException()
    }
}