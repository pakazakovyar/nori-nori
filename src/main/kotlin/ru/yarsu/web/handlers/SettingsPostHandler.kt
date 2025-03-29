package ru.yarsu.web.handlers

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.body.form
import ru.yarsu.web.game.GameStorage
import ru.yarsu.web.game.NoriNori

class SettingsPostHandler(private var gameStorage: GameStorage):HttpHandler {
    override fun invoke(request: Request): Response {

        val fieldHeight = request.form("fieldHeight")?.toInt() ?: 2
        val fieldWidth = request.form("fieldWidth")?.toInt() ?: 2
        val noriNori = NoriNori(fieldHeight, fieldWidth)
        noriNori.generateBlocks()
        noriNori.generateBordersFirstAlgorithm()
        noriNori.placeWithBordersToHtml()
        gameStorage.setGame(noriNori)
        println(gameStorage.noriNori)
        return Response(Status.FOUND).header("Location", "/norinori")
    }
}