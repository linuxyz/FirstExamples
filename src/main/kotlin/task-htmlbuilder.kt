/**
 * Created by sysop on 6/28/2017.
 */
package com.ytzb.kotlin

fun renderProductTable(): String {
    return html {
        table {
            tr (color = getTitleColor()){
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            for ((idx, it) in products.withIndex()) {
                tr {
                    td (color = getCellColor(idx, 0), align = "left") {
                        text(it.description)
                    }
                    td (color = getCellColor(idx, 1), align = "right")  {
                        text(it.price)
                    }
                    td (color = getCellColor(idx, 2), align = "right") {
                        text(it.popularity)
                    }
                }
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(row: Int, column: Int) = if ((row + column) %2 == 0) "#dce4ff" else "#eff2ff"
