/**
 * Created by sysop on 6/27/2017.
 */
package com.ytzb.kotlin

import java.util.*
import kotlin.reflect.KProperty

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

    fun nextDay(): MyDate {
        val d = GregorianCalendar(year, month, dayOfMonth)
        d.add(Calendar.DATE, 1)
        return MyDate(d.get(Calendar.YEAR), d.get(Calendar.MONTH), d.get(Calendar.DATE))
    }
}


///////////////////////////////////////////////////////////////////
//// Range

class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    operator fun contains(value: MyDate): Boolean = start <= value && value < end
    override fun iterator(): Iterator<MyDate> = DataIterator(this)
}

class DataIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current: MyDate = dateRange.start
    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }

    override fun hasNext(): Boolean = current <= dateRange.end
}

fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in DateRange(first, last)
}

///////////////////////////////////////////////////////////////////
//// Property Delegate

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}


/////////////////////////////////////////////////////////////
/// builder pattern

fun <T> T.myApply(f: T.() -> Unit): T { f(); return this}

fun createString(): String {
    return StringBuilder().myApply {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

fun createMap(): Map<Int, String> {
    return hashMapOf<Int, String>().myApply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
