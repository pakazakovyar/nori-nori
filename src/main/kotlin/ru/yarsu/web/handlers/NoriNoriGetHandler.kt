package ru.yarsu.web.handlers

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.template.PebbleTemplates
import ru.yarsu.web.game.GameStorage
import ru.yarsu.web.models.NoriNoriVM

class NoriNoriGetHandler(private var gameStorage: GameStorage): HttpHandler {
    override fun invoke(request: Request): Response {
        val renderer = PebbleTemplates().CachingClasspath()
        println(gameStorage.noriNori)
        val viewModel = NoriNoriVM(gameStorage.noriNori!!.htmlPlace)
        val htmlDocument = renderer(viewModel)
        return Response(Status.OK).body(htmlDocument)
    }
}