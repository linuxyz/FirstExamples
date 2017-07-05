/**
 * Created by sysop on 6/29/2017.
 */
package com.ytzb.kotlin

import kotlin.collections.*

fun <C, T:MutableCollection<C>> Collection<C>.partitionTo(left:T, right:T, pf:(C)->Boolean): Pair<T,T> {
    for (ele in this) {
        if (pf(ele)) {
            left.add(ele)
        } else {
            right.add(ele)
        }
    }
    return Pair(left, right)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").
            partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').
            partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}
