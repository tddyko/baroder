package co.kr.cobosys.baroder.base.adapter

interface Code {
    val code: String
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
}