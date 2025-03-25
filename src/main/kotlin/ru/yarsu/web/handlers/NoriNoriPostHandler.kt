package ru.yarsu.web.handlers

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.Body
import org.http4k.format.Jackson.auto
import ru.yarsu.web.game.GameStorage

class NoriNoriPostHandler(private val gameStorage: GameStorage): HttpHandler {
    data class ColorMatrixRequest(val colors: List<List<String>>)
    data class ResultResponse(val result: String, val message: String)

    private val colorMatrixLens = Body.auto<ColorMatrixRequest>().toLens()
    private val resultLens = Body.auto<ResultResponse>().toLens()

    override fun invoke(request: Request): Response {
        val colorMatrixRequest = colorMatrixLens(request)
        val colorMatrix = colorMatrixRequest.colors
        colorMatrix.forEach { row ->
            println(row.joinToString(" "))
        }

        return if (gameStorage.noriNori?.isVictory(colorMatrix) == true) {
            resultLens(ResultResponse("success", "хорош"), Response(Status.OK))
        } else {
            resultLens(ResultResponse("fail", "плох"), Response(Status.OK))
        }
    }
}