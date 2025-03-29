package ru.yarsu.web

import org.http4k.core.Method
import org.http4k.routing.bind
import org.http4k.routing.routes
import ru.yarsu.web.game.GameStorage
import ru.yarsu.web.handlers.*
var gameStorage = GameStorage(null)
val router = routes(
    "/ping" bind Method.GET to PingHandler(),
    "/templates/pebble" bind Method.GET to PebbleHandler(),
    "/norinori" bind Method.GET to NoriNoriGetHandler(gameStorage),
    "/norinori" bind Method.POST to NoriNoriPostHandler(gameStorage),
    "/settings" bind Method.GET to SettingsGetHandler(),
    "/settings" bind Method.POST to SettingsPostHandler(gameStorage)
)
