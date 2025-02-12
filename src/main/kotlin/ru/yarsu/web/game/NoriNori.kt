package ru.yarsu.web.game

import kotlin.random.Random

class NoriNori(private val fieldHeight: Int, private val fieldWith: Int) {
    var fieldWithBlocks = List(fieldHeight) { List(fieldWith) { 0 } }
    var fieldWithBorders = List(fieldHeight) { List(fieldWith) { 0 } }

    override fun toString(): String {
        return fieldWithBlocks.toString()
    }

    fun generateBlocks() {
        var attempts = fieldWith * fieldHeight
        while (attempts-- != 0) {
            val targetX = Random.nextInt(fieldWith)
            val targetY = Random.nextInt(fieldHeight)
        }
        fun isValidBlock(x: Int, y: Int): Boolean {
            if (x !in 0 until fieldWith) return false;
            else if (y !in 0 until fieldHeight) return false
            else if (fieldWithBlocks[x][y] != 0) return false

            if (x == 0) {
                if (y == 0 && (fieldWithBlocks[x + 1][y] != 0 || fieldWithBlocks[x][y + 1] != 0)) return false
                else if (y == fieldHeight - 1 && (fieldWithBlocks[x + 1][y] != 0 || fieldWithBlocks[x][y - 1] != 0)) return false
            }


        }
    }
}