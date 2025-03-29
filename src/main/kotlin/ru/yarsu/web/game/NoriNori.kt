package ru.yarsu.web.game

import org.http4k.routing.headers
import kotlin.random.Random

class NoriNori(private val fieldHeight: Int, private val fieldWith: Int) {
    private var fieldWithBlocks = List(fieldHeight) { MutableList(fieldWith) { 0 } }
    private var fieldWithBorders = List(fieldHeight) { MutableList(fieldWith) { 0 } }
    private var blocksNum = 0;
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
                        blocksNum++
                    } else if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                        blocksNum++
                    }
                } else if (targetX == fieldWith - 1 && targetY == 0) {
                    if (isValidBlock(targetX, targetY + 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY + 1][targetX] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                        blocksNum++
                    }
                } else if (targetX == fieldWith - 1 && targetY == fieldHeight - 1) {
                    if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                        blocksNum++
                    }
                } else if (targetX == 0 && targetY == fieldHeight - 1) {
                    if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                        blocksNum++
                    }
                } else if (targetY == 0) {
                    if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX, targetY + 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY + 1][targetX] = 1
                        blocksNum++
                    }
                } else if (targetY == fieldHeight - 1) {
                    if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                        blocksNum++
                    }
                } else if (targetX == 0) {
                    if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX, targetY + 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY + 1][targetX] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                        blocksNum++
                    }
                } else if (targetX == fieldWith - 1) {
                    if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX, targetY + 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY + 1][targetX] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                        blocksNum++
                    }
                } else {
                    if (isValidBlock(targetX - 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX - 1] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX, targetY + 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY + 1][targetX] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX, targetY - 1)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY - 1][targetX] = 1
                        blocksNum++
                    } else if (isValidBlock(targetX + 1, targetY)) {
                        fieldWithBlocks[targetY][targetX] = 1
                        fieldWithBlocks[targetY][targetX + 1] = 1
                        blocksNum++
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
            val indexes = if (i % 2 == 0) fieldWithBlocks[i].indices else fieldWithBlocks[i].indices.reversed()
            for (j in indexes) {
                fieldWithBorders[i][j] = borderNumber
                if (fieldWithBlocks[i][j] == 1) blocksCnt++
                if (blocksCnt == 2 && borderNumber != blocksNum) {
                    blocksCnt = 0
                    borderNumber++
                }

            }
        }

    }

    fun placeWithBordersToHtml() {
        htmlPlace = """
        <table border="0" cellspacing="0" cellpadding="5" style="border-collapse: collapse;" id="myTable"><form method="post">
            ${
            fieldWithBorders.joinToString(separator = "") { row ->
                "<tr>${row.joinToString(separator = "") { "<td>$it</td>" }}</tr>"
            }
        }
        </form></table>
    """.trimIndent()
    }

    fun isVictory(colorMatrix: List<List<String>>): Boolean {
        var max = 0
        fieldWithBorders.forEach {
            it.forEach {
                max = Math.max(max, it)
            }
        }
        val placesDict = (1..max - 1)
            .associateWith { 0 }.toMutableMap<Int, Int>()
        for (i in fieldWithBorders.indices) {
            for (j in fieldWithBorders[i].indices) {
                if (colorMatrix[i][j] == "gray") {
                    placesDict[fieldWithBorders[i][j]] = placesDict.getOrDefault(fieldWithBorders[i][j], 0) + 1
//                    if (!isValidBlock1(j, i, colorMatrix)) return false
                }


            }
        }
        for (value in placesDict.values) if (value != 2) return false
        var cnt = 0
        for (i in colorMatrix.indices) {
            for (j in colorMatrix[i].indices) {
                if (colorMatrix[i][j] == "gray") {
                    if (i > 0 && colorMatrix[i - 1][j] == "gray") cnt++
                    if (i < fieldHeight - 1 && colorMatrix[i + 1][j] == "gray") cnt++
                    if (j > 0 && colorMatrix[i][j - 1] == "gray") cnt++
                    if (j < fieldWith - 1 && colorMatrix[i][j + 1] == "gray") cnt++
                    if (cnt != 1) return false
                    cnt = 0
                }
            }
        }

        return true
    }
    fun generateBordersImproved() {
        var borderNumber = 1
        var blocksInBorder = 0
        val visited = MutableList(fieldHeight) { MutableList(fieldWith) { false } }

        // Направления движения: вверх, вправо, вниз, влево
        val directions = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)

        // Проходим по всем клеткам в случайном порядке
        val cells = (0 until fieldHeight).flatMap { y ->
            (0 until fieldWith).map { x -> y to x }
        }.shuffled()

        for ((y, x) in cells) {
            if (!visited[y][x] && fieldWithBlocks[y][x] == 1) {
                // Начинаем новую границу
                var currentY = y
                var currentX = x
                var directionChanges = 0
                var lastDirection = -1

                while (blocksInBorder < 2 && borderNumber <= blocksNum) {
                    if (!visited[currentY][currentX]) {
                        visited[currentY][currentX] = true
                        fieldWithBorders[currentY][currentX] = borderNumber
                        blocksInBorder++
                    }

                    // Пробуем двигаться в случайном направлении, но с предпочтением текущего
                    val possibleDirections = directions.indices.shuffled().sortedBy {
                        if (it == lastDirection) 0 else 1
                    }

                    var moved = false
                    for (dir in possibleDirections) {
                        val (dy, dx) = directions[dir]
                        val newY = currentY + dy
                        val newX = currentX + dx

                        if (newY in 0 until fieldHeight && newX in 0 until fieldWith &&
                            !visited[newY][newX] && fieldWithBlocks[newY][newX] == 1) {

                            if (dir != lastDirection) directionChanges++
                            lastDirection = dir
                            currentY = newY
                            currentX = newX
                            moved = true
                            break
                        }
                    }

                    // Если не смогли двигаться дальше, завершаем текущую границу
                    if (!moved) break
                }

                borderNumber++
                blocksInBorder = 0
            }
        }

        // Заполняем оставшиеся клетки (не блоки) ближайшими номерами границ
        fillEmptyCells()
    }

    fun fillEmptyCells() {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val directions = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)

        // Сначала добавляем все блоки в очередь
        for (y in 0 until fieldHeight) {
            for (x in 0 until fieldWith) {
                if (fieldWithBorders[y][x] != 0) {
                    queue.add(y to x)
                }
            }
        }

        // Распространяем номера границ на соседние клетки
        while (queue.isNotEmpty()) {
            val (y, x) = queue.removeFirst()

            for ((dy, dx) in directions) {
                val newY = y + dy
                val newX = x + dx

                if (newY in 0 until fieldHeight && newX in 0 until fieldWith &&
                    fieldWithBorders[newY][newX] == 0) {

                    fieldWithBorders[newY][newX] = fieldWithBorders[y][x]
                    queue.add(newY to newX)
                }
            }
        }
    }

}

//    fun main() {
//        var nori = NoriNori(8, 8)
//        nori.generateBlocks()
//        nori.generateBordersFirstAlgorithm()
//        println(nori)
//        println(nori.placeWithBordersToHtml())
//    }