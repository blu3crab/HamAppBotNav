package com.adaptivehandyapps.hamappbotnav.ui.dashboard

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.adaptivehandyapps.hamappbotnav.R
import com.adaptivehandyapps.hamappbotnav.model.HamHttpServer

class DashboardFragment : Fragment() {
    private val TAG = "DashboardFragment"

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
        ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        // find fragment dimensions
        root.post {
            // height & width for instance
            val height = root.measuredHeight
            val width = root.measuredWidth
            // kotlin println logcat labeled I/System.out
            //println("println fragment h/w: $height / $width")
            // Log logcat labeled as D/DashboardFragment:
            Log.d(TAG, "fragment h/w: $height / $width")
        }
        // get/set viewModel HR text
        val fromHR = dashboardViewModel.text.value
        val toHR = "98"
        dashboardViewModel.setValue(toHR)
        Log.d(TAG, "HR from -> to : $fromHR / $toHR")
        //////////////////////////////////////////
        val bitmap: Bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_8888)
        val canvas: Canvas = Canvas(bitmap)

        var shapeDrawable: ShapeDrawable

        // rectangle positions
        var left = 0
        var top = 400
        var right = 1000
        var bottom = 1000

        // draw rectangle shape to canvas
        shapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.setBounds(left, top, right, bottom)
//        shapeDrawable.getPaint().setColor(Color.parseColor("#FF0000"))
        shapeDrawable.getPaint().setColor(Color.RED)
        shapeDrawable.draw(canvas)

        // oval positions
        left = 100
        top = 500
        right = 600
        bottom = 800

        // draw oval shape to canvas
        shapeDrawable = ShapeDrawable(OvalShape())
        shapeDrawable.setBounds(left, top, right, bottom)
        shapeDrawable.getPaint().setColor(Color.parseColor("#009191"))
        shapeDrawable.draw(canvas)

        // now bitmap holds the updated pixels

        // set bitmap as background to ImageView
        val imageView: ImageView = root.findViewById(R.id.imageV)
        imageView.background = BitmapDrawable(getResources(), bitmap)
        //////////////////////////////////////////
//        // establish HAM HTTP server to rcv HR on POST & send metadata on GET
//        val hamHttpServer: HamHttpServer = HamHttpServer()
//        hamHttpServer.establishHttpServer()
//        hamHttpServer.establishHttpServer(dashboardViewModel)

        return root
    }
}