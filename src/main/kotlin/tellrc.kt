/**
 * Created by sysop on 6/29/2017.
 */
package com.ytzb.kotlin

import com.example.tutorial.AddressBookProtos

tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))

fun TakeLook(ab: AddressBookProtos.AddressBook): AddressBookProtos.Person {
    return ab.peopleList.maxBy { it.phonesCount }!!
}