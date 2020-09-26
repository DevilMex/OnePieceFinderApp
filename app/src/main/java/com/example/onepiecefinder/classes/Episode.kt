package com.example.onepiecefinder.classes

open class EpisodeKotlin(
    protected var number : Int,
    protected var stringNumber : String,
    protected var firstLink : String,
    protected var secondLink : String
){
    class EpisodeKotlin constructor(number: Int, stringNumber: String, firstLink: String, secondLink: String) : com.example.onepiecefinder.classes.EpisodeKotlin (
            number,
            stringNumber,
            firstLink,
            secondLink
    )

}