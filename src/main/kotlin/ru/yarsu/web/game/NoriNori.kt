package ru.yarsu.web.game

import kotlin.random.Random

class NoriNori(private val fieldHeight: Int, private val fieldWith: Int) {
    private var fieldWithBlocks = List(fieldHeight) { MutableList(fieldWith) { 0 } }
    private var fieldWithBorders = List(fieldHeight) { MutableList(fieldWith) { 0 } }
     var htmlPlace: String = ""

    override fun toString(): String {
        var res = ""
        fieldWithBlocks.forEach {
            res += it.toString() + "\n"
        }
        res += "\n"
        fieldWithBorders.forEach {
            res += it.toString() + "\n"
        }
        return res
    }

    fun generateBlocks() {
        var attempts = fieldWith * fieldHeight * 1000
        while (attempts-- != 0) {

            val targetX = Random.nextInt(fieldWith)
            val targetY = Random.nextInt(fieldHeight)

            if (isValidBlock(targetX, targetY)) {

                if (targetX == 0 && targetY == 0) {
                    if (isValidBlock(targetX, targetY + 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY + 1][targetX] = 1
                    } else if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                    }
                } else if (targetX == fieldWith - 1 && targetY == 0) {
                    if (isValidBlock(targetX, targetY + 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY + 1][targetX] = 1
                    } else if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                    }
                } else if (targetX == fieldWith - 1 && targetY == fieldHeight - 1) {
                    if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                    }
                } else if (targetX == 0 && targetY == fieldHeight - 1) {
                    if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                    }
                } else if (targetY == 0) {
                    if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                    } else if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                    } else if (isValidBlock(targetX, targetY + 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY + 1][targetX] = 1
                    }
                } else if (targetY == fieldHeight - 1) {
                    if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                    } else if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                    }
                } else if (targetX == 0) {
                    if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                    } else if (isValidBlock(targetX, targetY + 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY + 1][targetX] = 1
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                    }
                } else if (targetX == fieldWith - 1) {
                    if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                    } else if (isValidBlock(targetX, targetY + 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY + 1][targetX] = 1
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                    }
                } else {
                    if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                    } else if (isValidBlock(targetX, targetY + 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY + 1][targetX] = 1
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                    } else if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                    }
                }

            }
        }

    }

    fun isValidBlock(x: Int, y: Int): Boolean {
        if (x !in 0 until fieldWith) return false;
        else if (y !in 0 until fieldHeight) return false
        else if (fieldWithBlocks[y][x] != 0) return false
        if (x == 0 && y == 0)
            return fieldWithBlocks[y + 1][x] == 0 && fieldWithBlocks[y][x + 1] == 0
        else if (x == fieldWith - 1 && y == 0)
            return fieldWithBlocks[y + 1][x] == 0 && fieldWithBlocks[y][x - 1] == 0
        else if (x == fieldWith - 1 && y == fieldHeight - 1)
            return fieldWithBlocks[y - 1][x] == 0 && fieldWithBlocks[y][x - 1] == 0
        else if (x == 0 && y == fieldHeight - 1)
            return fieldWithBlocks[y - 1][x] == 0 && fieldWithBlocks[y][x + 1] == 0
        else if (y == 0)
            return fieldWithBlocks[y + 1][x] == 0 && fieldWithBlocks[y][x + 1] == 0 && fieldWithBlocks[y][x - 1] == 0
        else if (y == fieldHeight - 1)
            return fieldWithBlocks[y - 1][x] == 0 && fieldWithBlocks[y][x + 1] == 0 && fieldWithBlocks[y][x - 1] == 0
        else if (x == 0)
            return fieldWithBlocks[y + 1][x] == 0 && fieldWithBlocks[y][x + 1] == 0 && fieldWithBlocks[y - 1][x] == 0
        else if (x == fieldWith - 1)
            return fieldWithBlocks[y + 1][x] == 0 && fieldWithBlocks[y][x - 1] == 0 && fieldWithBlocks[y - 1][x] == 0
        else return fieldWithBlocks[y + 1][x] == 0 && fieldWithBlocks[y][x - 1] == 0 && fieldWithBlocks[y - 1][x] == 0 && fieldWithBlocks[y][x + 1] == 0
//        return true
    }

    fun generateBordersFirstAlgorithm() {
        var borderNumber = 1
        var blocksCnt = 0
        for (i in fieldWithBlocks.indices) {
            for (j in fieldWithBlocks[i].indices) {
                fieldWithBorders[i][j] = borderNumber
                if (fieldWithBlocks[i][j] == 1) blocksCnt++
                if (blocksCnt == 2) {
                    blocksCnt = 0
                    borderNumber++
                }
            }
        }

    }

    fun placeWithBordersToHtml() {
        htmlPlace = """
        <table border="1">
            ${
            fieldWithBorders.joinToString(separator = "") { row ->
                "<tr>${row.joinToString(separator = "") { "<td>$it</td>" }}</tr>"
            }
        }
        </table>
    """.trimIndent()
    }
}

fun main() {
    var nori = NoriNori(8, 8)
    nori.generateBlocks()
    nori.generateBordersFirstAlgorithm()
    println(nori)
    println(nori.placeWithBordersToHtml())
}