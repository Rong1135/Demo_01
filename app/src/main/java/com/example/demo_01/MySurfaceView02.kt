package com.example.demo_01

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class MySurfaceView02(context: Context?, attrs: AttributeSet?): SurfaceView(context, attrs), SurfaceHolder.Callback  {

    private var surfaceHolder: SurfaceHolder
    private var BG: Bitmap
    private var Score1: Int = 0        // 成績

    init {
        surfaceHolder = getHolder()
        BG = BitmapFactory.decodeResource(getResources(), R.drawable.end)
        surfaceHolder.addCallback(this)
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        val canvas: Canvas = surfaceHolder.lockCanvas()
            drawSomething(canvas)
        surfaceHolder.unlockCanvasAndPost(canvas)
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {

    }

    fun drawSomething(canvas: Canvas) {
        /* 背景圖 */
        canvas.drawBitmap(BG, 0f, 0f, null)

        // 繪製得分文字
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.BLACK
        paint.textSize = 45f
        canvas.drawText("得分:"+Score1.toString(), 600f,72f, paint)
    }

}