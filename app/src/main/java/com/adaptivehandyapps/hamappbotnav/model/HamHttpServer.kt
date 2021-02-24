package com.adaptivehandyapps.hamappbotnav.model

import android.util.Log
import com.adaptivehandyapps.hamappbotnav.ui.dashboard.DashboardViewModel

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class HamHttpServer {
    private val TAG = "HamHttpServer"

    // establish HTTP server for HAM GET & POST
    fun establishHttpServer() {
//        fun establishHttpServer(dashboardViewModel: DashboardViewModel) {
        embeddedServer(Netty, 8080) {
            install(ContentNegotiation) {
                gson {}
            }
            routing {
                Log.d(TAG, "embeddedServer routing rcv'd")
                get("/about") {
//                    call.respond(mapOf("message" to "Hello world"))
                    val appMap = mapOf("appTitle" to "HeartActivityMonitor", "version" to "24JAN2021-16:31", "token" to "HAMster")
                    call.respond(appMap)
                    Log.d(TAG, "embeddedServer /about appMap keys: ${appMap.keys}")
                    Log.d(TAG, "embeddedServer /about appMap values: ${appMap.values}")
                    for (appMapKey in appMap.keys) {
                        appMap[appMapKey]?.let { it1 -> Log.d(TAG, "$appMapKey: $it1") }
                    }
                }
                post("/heartRate") {
                    val text: String = call.receiveText()
                    Log.d(TAG, "embeddedServer /heartRate post-receive -> $text")
                    call.respondText(HttpStatusCode.OK.toString())
//                    dashboardViewModel.setValue("88")
//                    dashboardViewModel.text.value = "77"
                }
            }

        }.start(wait = false)

    }
}