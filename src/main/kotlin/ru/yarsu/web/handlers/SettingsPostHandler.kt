package ru.yarsu.web.handlers

import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.body.form
import org.http4k.core.body.formAsMap
import org.http4k.template.PebbleTemplates
import ru.yarsu.web.game.NoriNori
import ru.yarsu.web.models.SettingsVM

class SettingsPostHandler(private var noriNori: NoriNori?):HttpHandler {
    override fun invoke(request: Request): Response {
        val fieldHeight = request.form("fieldHeight")?.toInt() ?: 2
        val fieldWidth = request.form("fieldWidth")?.toInt() ?: 2
        noriNori = NoriNori(fieldHeight, fieldWidth)
        val renderer = PebbleTemplates().CachingClasspath()
        val viewModel = SettingsVM()
        val htmlDocument = renderer(viewModel)
        return Response(Status.OK).body(htmlDocument)
    }
}