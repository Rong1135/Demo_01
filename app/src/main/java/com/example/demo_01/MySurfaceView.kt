package com.example.demo_01

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class MySurfaceView(context: Context?, attrs: AttributeSet?): SurfaceView(context, attrs), SurfaceHolder.Callback {

    private var surfaceHolder: SurfaceHolder
    private var BG: Bitmap
    private var mouse1: Bitmap
    private var mouse2: Bitmap
    private var mouse3: Bitmap

    /* 地鼠出現座標 & 隨機移動 */
    private var xPos1: Int = 0
    private var yPos1: Int = 0
    private var xPos2: Int = 0
    private var yPos2: Int = 0
    private var xPos3: Int = 0
    private var yPos3: Int = 0
    private var count1: Int = 0
    private var count2: Int = 0
    private var count3: Int = 0
    private var time: Int = 0

    init {
        surfaceHolder = getHolder()
        BG = BitmapFactory.decodeResource(getResources(), R.drawable.ground)
        mouse1 = BitmapFactory.decodeResource(getResources(), R.drawable.m1)
        mouse2 = BitmapFactory.decodeResource(getResources(), R.drawable.m3)
        mouse3 = BitmapFactory.decodeResource(getResources(), R.drawable.m8)
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

        /* m1 地鼠隨機出現 --- 開始 */
        val srcRect1 = Rect(0, 0, mouse1.width, mouse1.height)
        val w1: Int = mouse1.width / 8
        val h1: Int = mouse1.height / 8

        count1 = (0..9).random()    // 從 0 ~ 9 隨機抽取一個數字為 count1

        when (count1) {
            0 -> {
                xPos1 = 1080
                yPos1 = 380
            }
            1 -> {
                xPos1 = 70
                yPos1 = 350
            }
            2 -> {
                xPos1 = 40
                yPos1 = 140
            }
            3 -> {
                xPos1 = 880
                yPos1 = 280
            }
            4 -> {
                xPos1 = 1020
                yPos1 = 140
            }
            5 -> {
                xPos1 = 500
                yPos1 = 280
            }
            6 -> {
                xPos1 = 660
                yPos1 = 400
            }
            7 -> {
                xPos1 = 360
                yPos1 = 140
            }
            8 -> {
                xPos1 = 370
                yPos1 = 400
            }
            19 -> {
                xPos1 = 660
                yPos1 = 120
            }
        }

        val destRect1 = Rect(xPos1, yPos1, w1+xPos1, h1+yPos1)
        canvas.drawBitmap(mouse1, srcRect1, destRect1, null)
        /* m1 地鼠隨機出現 --- 結束 */

        time++

        /* m3 地鼠隨機出現 --- 開始 */
        val srcRect2 = Rect(0, 0, mouse2.width, mouse2.height)
        val w2: Int = mouse2.width / 8
        val h2: Int = mouse2.height / 8

        do {
            count2 = (0..9).random()
        }while (count2 == count1)

        if(time % 5 == 0) {     // 間隔時間長一點才出現
            when (count2) {
                0 -> {
                    xPos2 = 1080
                    yPos2 = 380
                }
                1 -> {
                    xPos2 = 70
                    yPos2 = 350
                }
                2 -> {
                    xPos2 = 40
                    yPos2 = 140
                }
                3 -> {
                    xPos2 = 880
                    yPos2 = 280
                }
                4 -> {
                    xPos2 = 1020
                    yPos2 = 140
                }
                5 -> {
                    xPos2 = 500
                    yPos2 = 280
                }
                6 -> {
                    xPos2 = 660
                    yPos2 = 400
                }
                7 -> {
                    xPos2 = 360
                    yPos2 = 140
                }
                8 -> {
                    xPos2 = 370
                    yPos2 = 400
                }
                9 -> {
                    xPos2 = 660
                    yPos2 = 120
                }
            }

            val destRect2 = Rect(xPos2, yPos2, w2+xPos2, h2+yPos2)
            canvas.drawBitmap(mouse2, srcRect2, destRect2, null)
        }
        /* m3 地鼠隨機出現 --- 結束 */

        /* m8 地鼠隨機出現 --- 開始 */
        val srcRect3 = Rect(0, 0, mouse3.width, mouse3.height)
        val w3: Int = mouse3.width / 8
        val h3: Int = mouse3.height / 8

        do {
            count3 = (0..9).random()
        }while (count3 == count2 || count3 == count1)

        if(time % 3 == 0) {
            when (count3) {
                0 -> {
                    xPos3 = 1080
                    yPos3 = 380
                }
                1 -> {
                    xPos3 = 70
                    yPos3 = 350
                }
                2 -> {
                    xPos3 = 40
                    yPos3 = 140
                }
                3 -> {
                    xPos3 = 880
                    yPos3 = 280
                }
                4 -> {
                    xPos3 = 1020
                    yPos3 = 140
                }
                5 -> {
                    xPos3 = 500
                    yPos3 = 280
                }
                6 -> {
                    xPos3 = 660
                    yPos3 = 400
                }
                7 -> {
                    xPos3 = 360
                    yPos3 = 140
                }
                8 -> {
                    xPos3 = 370
                    yPos3 = 400
                }
                9 -> {
                    xPos3 = 660
                    yPos3 = 120
                }
            }

            val destRect3 = Rect(xPos3, yPos3, w3+xPos3, h3+yPos3)
            canvas.drawBitmap(mouse3, srcRect3, destRect3, null)
        }

        /* m8 地鼠隨機出現 --- 結束 */

    }

}