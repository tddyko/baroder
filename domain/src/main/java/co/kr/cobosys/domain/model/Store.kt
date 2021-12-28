package co.kr.cobosys.domain.model

data class Store(
    val id: Int,
    val name: String,
    val location: String,
    val address: String,
    val imgUrl: String?,
    val favorite: Boolean
)
