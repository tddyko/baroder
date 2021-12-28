package co.kr.cobosys.domain.base.map

interface Mapper<in LeftObject, out RightObject> {

    fun mapLeftToRight(obj: LeftObject): RightObject

}