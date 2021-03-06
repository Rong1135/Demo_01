package com.example.demo_01

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
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

    /* 觸控遊戲屬性 */
    private var Player: Bitmap
    private var PlayerX: Float = 0f
    private var PlayerY: Float = 0f
    var Score: Int = 0          // 成績
    private var Shooting: Int = 0       // 消失時間

    init {
        surfaceHolder = getHolder()
        BG = BitmapFactory.decodeResource(getResources(), R.drawable.ground)
        mouse1 = BitmapFactory.decodeResource(getResources(), R.drawable.m1)
        mouse2 = BitmapFactory.decodeResource(getResources(), R.drawable.m3)
        mouse3 = BitmapFactory.decodeResource(getResources(), R.drawable.m8)
        surfaceHolder.addCallback(this)

        Player = BitmapFactory.decodeResource(getResources(), R.drawable.hammer)
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

        /* 觸控偵測 */
        if(Shooting > 0)
            Shooting--

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
                    xPos2 = 1060
                    yPos2 = 360
                }
                1 -> {
                    xPos2 = 60
                    yPos2 = 330
                }
                2 -> {
                    xPos2 = 30
                    yPos2 = 130
                }
                3 -> {
                    xPos2 = 850
                    yPos2 = 260
                }
                4 -> {
                    xPos2 = 1000
                    yPos2 = 120
                }
                5 -> {
                    xPos2 = 485
                    yPos2 = 260
                }
                6 -> {
                    xPos2 = 650
                    yPos2 = 380
                }
                7 -> {
                    xPos2 = 340
                    yPos2 = 130
                }
                8 -> {
                    xPos2 = 350
                    yPos2 = 380
                }
                9 -> {
                    xPos2 = 645
                    yPos2 = 105
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
                    xPos3 = 1035
                    yPos3 = 355
                }
                1 -> {
                    xPos3 = 30
                    yPos3 = 330
                }
                2 -> {
                    xPos3 = 5
                    yPos3 = 122
                }
                3 -> {
                    xPos3 = 840
                    yPos3 = 250
                }
                4 -> {
                    xPos3 = 970
                    yPos3 = 110
                }
                5 -> {
                    xPos3 = 455
                    yPos3 = 250
                }
                6 -> {
                    xPos3 = 610
                    yPos3 = 380
                }
                7 -> {
                    xPos3 = 310
                    yPos3 = 130
                }
                8 -> {
                    xPos3 = 320
                    yPos3 = 375
                }
                9 -> {
                    xPos3 = 620
                    yPos3 = 105
                }
            }

            val destRect3 = Rect(xPos3, yPos3, w3+xPos3, h3+yPos3)
            canvas.drawBitmap(mouse3, srcRect3, destRect3, null)
        }
        /* m8 地鼠隨機出現 --- 結束 */

        /* 繪製槌子 */
        canvas.drawBitmap(Player, PlayerX, PlayerY, null)

        // 繪製得分文字
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.BLACK
        paint.textSize = 45f
        canvas.drawText("得分:"+Score.toString(), 600f,72f, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        PlayerX = event!!.x
        PlayerY = event.y

        val w1:Int = mouse1.width / 6
        val h1:Int = mouse1.height / 6
        val w2:Int = mouse2.width / 6
        val h2:Int = mouse2.height / 6
        val w3:Int = mouse3.width / 6
        val h3:Int = mouse3.height / 6

        if((PlayerX >= xPos1) && (PlayerX <= xPos1+w1) && (PlayerY >= yPos1) && (PlayerY <= yPos1+h1)) {
            Score += 10
            Shooting = 0
        }
        else if((PlayerX >= xPos2) && (PlayerX <= xPos2+w2) && (PlayerY >= yPos2) && (PlayerY <= yPos2+h2)) {
            Score += 50
            Shooting = 0
        }
        else if((PlayerX >= xPos3) && (PlayerX <= xPos3+w3) && (PlayerY >= yPos3) && (PlayerY <= yPos3+h3)) {
            Score -= 20
            Shooting = 0
        }

        PlayerX -= Player.width / 2
        PlayerY -= Player.height / 2

        return false
    }

}