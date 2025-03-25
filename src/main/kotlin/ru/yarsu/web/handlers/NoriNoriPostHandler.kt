package ru.yarsu.web.handlers

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.Body
import org.http4k.format.Jackson.auto
import ru.yarsu.web.game.GameStorage

class NoriNoriPostHandler(private val gameStorage: GameStorage): HttpHandler {
    // Определяем модель для парсинга JSON
    data class ColorMatrixRequest(val colors: List<List<String>>)

    // Автоматический парсер для JSON
    private val colorMatrixLens = Body.auto<ColorMatrixRequest>().toLens()

    override fun invoke(request: Request): Response {
        // Парсим JSON из запроса
        val colorMatrixRequest = colorMatrixLens(request)
        val colorMatrix = colorMatrixRequest.colors

        // Выводим матрицу цветов в консоль
        println("Получена матрица цветов:")
        colorMatrix.forEach { row ->
            println(row.joinToString(" "))
        }
        println(gameStorage.noriNori?.isVictory(colorMatrix)?: "aboba")
        // Возвращаем успешный ответ
        return Response(Status.OK).body("Матрица цветов получена и обработана")
    }
}