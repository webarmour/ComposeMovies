package ru.webarmour.composemovies.data.models

data class Network(
    val country: Country,
    val id: Int,
    val name: String,
    val officialSite: String
)