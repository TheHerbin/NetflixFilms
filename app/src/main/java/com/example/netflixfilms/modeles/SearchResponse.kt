package com.example.netflixfilms.modeles

data class SearchResponse(
    val results: List<Search>,
    val total: Int,
    val elapse: Double


)