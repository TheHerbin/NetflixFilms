package com.example.netflixfilms.modeles

data class Search(
    val avgrating: Double,
    val clist: String,
    val id: Int,
    val imdbid: String,
    val imdbrating: Double,
    val img: String,
    val nfid: Int,
    val poster: String,
    val runtime: Int,
    val synopsis: String,
    val title: String,
    val titledate: String,
    val top250: Any,
    val top250tv: Any,
    val vtype: String,
    val year: Int
) {
    @JvmName("getClist1")
    fun getClistToString(): String {
        var countryList : String = "It can be found in : "
        val strs = this.clist.split(",").toTypedArray()
        strs.forEach {
            countryList = countryList + it.substringAfterLast(":")
        }
        val oldValue = "\"\""
        val newValue = ", "
        val output = countryList.replace(oldValue, newValue)
        return output
    }
}