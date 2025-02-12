package ru.yarsu.web

import org.http4k.core.Method
import org.http4k.routing.bind
import org.http4k.routing.routes
import ru.yarsu.web.game.NoriNori
import ru.yarsu.web.handlers.*
var noriNori: NoriNori? = null;
val router = routes(
    "/ping" bind Method.GET to PingHandler(),
    "/templates/pebble" bind Method.GET to PebbleHandler(),
    "/" bind Method.GET to NoriNoriGetHandler(),
    "/settings" bind Method.GET to SettingsGetHandler(),
    "/settings" bind Method.POST to SettingsPostHandler(noriNori)
)
