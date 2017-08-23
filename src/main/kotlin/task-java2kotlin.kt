package com.ytzb.kotlin

import kotlin.collections.*

fun toJSON(collection:Collection<Int>)
    = collection.joinToString(prefix = "[", postfix = "]")

fun toJSON2(collection:Collection<Int>):String {

    val sb = StringBuilder()
    sb.append("[")
    val iter = collection.iterator()
    while (iter.hasNext()) {
        val element = iter.next()
        sb.append(element)
        if (iter.hasNext()) {
            sb.append(",")
        }
    }
    sb.append("]")

    for (item in sb) {
        
    }
    return sb.toString()
}

