package com.example.shiftapplicationrmvl.helpers

fun dateConverter(date:String):String{

    val startRemovingIndex = date.indexOf('.')

    return date
        .replace('T',' ',ignoreCase = true)
        .removeRange(startRemovingIndex,date.lastIndex)
        .removeSuffix("Z")
}