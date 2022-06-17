package com.example.demo_01

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class MySurfaceView(context: Context?, attrs: AttributeSet?): SurfaceView(context, attrs), SurfaceHolder.Callback {

    private var surfaceHolder: SurfaceHolder
    private var BG: Bitmap

    init {
        surfaceHolder = getHolder()
        BG = BitmapFactory.decodeResource(getResources(), R.drawable.ground)
        surfaceHolder.addCallback(this)
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        var canvas: Canvas = surfaceHolder.lockCanvas()
            drawSomething(canvas)
        surfaceHolder.unlockCanvasAndPost(canvas)
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {

    }

    private fun drawSomething(canvas: Canvas) {
        /* 背景圖 */
        canvas.drawBitmap(BG, 0f, 0f, null)
    }

}