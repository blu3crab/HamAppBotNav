package com.adaptivehandyapps.hamappbotnav

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.adaptivehandyapps.hamappbotnav.model.HamHttpServer

//import io.ktor.application.call
//import io.ktor.application.install
//import io.ktor.features.ContentNegotiation
//import io.ktor.gson.gson
//import io.ktor.http.*
//import io.ktor.request.*
//import io.ktor.response.*
//import io.ktor.routing.*
//import io.ktor.server.engine.embeddedServer
////import io.ktor.server.jetty.*
//import io.ktor.server.netty.Netty

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val hamHttpServer: HamHttpServer = HamHttpServer()
        hamHttpServer.establishHttpServer()

////        embeddedServer(Jetty, 8080) {
//        embeddedServer(Netty, 8080) {
//            install(ContentNegotiation) {
//                gson {}
//            }
////            routing {
////                get("/") {
////                    call.respond(mapOf("message" to "Hello world"))
////                }
////            }
//            routing {
//                Log.d(TAG, "embeddedServer routing rcv'd")
//                get("/about") {
////                    call.respond(mapOf("message" to "Hello world"))
//                    val appMap = mapOf("appTitle" to "HeartActivityMonitor", "version" to "24JAN2021-16:31", "token" to "HAMster")
//                    call.respond(appMap)
//                    println("embeddedServer appMap keys: ${appMap.keys}")
//                    println("embeddedServer appMap values: ${appMap.values}")
//                    for (appMapKey in appMap.keys) {
//                        appMap[appMapKey]?.let { it1 -> Log.d(TAG, "$appMapKey: $it1") }
//                    }
//                }
//                post("/heartRate") {
//                    val text: String = call.receiveText()
//                    Log.d(TAG, "embeddedServer post-receive -> $text")
//                    call.respondText(HttpStatusCode.OK.toString())
//                }
//            }
//
//        }.start(wait = false)
//
////        embeddedServer(Netty, 8080) {
////            install(ContentNegotiation) {
////                gson {}
////            }
////            routing {
////                Log.d(TAG, "embeddedServer routing rcv'd")
////                get("/about") {
//////                    call.respond(mapOf("message" to "Hello world"))
////                    val appMap = mapOf("appTitle" to "HeartActivityMonitor", "version" to "24JAN2021-16:31", "token" to "HAMster")
////                    call.respond(appMap)
////                    println("embeddedServer appMap keys: ${appMap.keys}")
////                    println("embeddedServer appMap values: ${appMap.values}")
////                    for (appMapKey in appMap.keys) {
////                        appMap[appMapKey]?.let { it1 -> Log.d(TAG, "$appMapKey: $it1") }
////                    }
////                }
////                post("/heartRate") {
////                    val text: String = call.receiveText()
////                    Log.d(TAG, "embeddedServer post-receive -> $text")
////                }
////            }
////        }.start(wait = true)

    }
}