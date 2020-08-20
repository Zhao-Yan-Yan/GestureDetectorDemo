package com.yan.gesturedetectordemo

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.VelocityTracker
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var gestureDetectorCompat: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.movementMethod = ScrollingMovementMethod()
        gestureDetectorCompat =
            GestureDetectorCompat(this, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent?): Boolean {
                    log("onSingleTapUp")
                    return super.onSingleTapUp(e)
                }

                override fun onDown(e: MotionEvent?): Boolean {
                    log("onDown")
                    return super.onDown(e)
                }

                override fun onFling(
                    e1: MotionEvent?,
                    e2: MotionEvent?,
                    velocityX: Float,
                    velocityY: Float
                ): Boolean {
                    log("onFling velocityX=${velocityX} velocityY=${velocityY}")
                    //velocityY 手指向上滑动值为负数 向下为正数
                    //velocityX 手指向左滑动值为负数 向右为正数
                    //     translation(velocityX, velocityY)
                    val obtain = VelocityTracker.obtain()
                    obtain.addMovement(e1)
                    obtain.recycle()
                    obtain.computeCurrentVelocity(1000, 100f)
                    return super.onFling(e1, e2, velocityX, velocityY)
                }

                override fun onDoubleTap(e: MotionEvent?): Boolean {
                    log("onDoubleTap")
                    return super.onDoubleTap(e)
                }

                override fun onScroll(
                    e1: MotionEvent?,
                    e2: MotionEvent?,
                    distanceX: Float,
                    distanceY: Float
                ): Boolean {
                    log("onScroll distanceX=${distanceX} distanceY=${distanceY}")
                    //distanceX 向上滑动为正 向下为负数
                    //distanceY 向右滑动为负数 向左滑动为是正数
                    translation(distanceX, distanceY)
                    return super.onScroll(e1, e2, distanceX, distanceY)
                }

                override fun onContextClick(e: MotionEvent?): Boolean {
                    log("onContextClick")
                    return super.onContextClick(e)
                }

                override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
                    log("onSingleTapConfirmed")
                    return super.onSingleTapConfirmed(e)
                }

                override fun onShowPress(e: MotionEvent?) {
                    log("onShowPress")
                    super.onShowPress(e)
                }

                override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
                    log("onDoubleTapEvent")
                    return super.onDoubleTapEvent(e)
                }

                override fun onLongPress(e: MotionEvent?) {
                    log("onLongPress")
                    super.onLongPress(e)
                }
            })

        view.setOnTouchListener { p0, p1 ->
            gestureDetectorCompat.onTouchEvent(p1)
            true
        }
    }

    fun log(msg: String) {
        Log.e("main", msg)
        tv.text = msg
    }

    fun translation(x: Float, y: Float) {
        ball.translationX = ball.translationX + -x
        ball.translationY = ball.translationY + -y
    }
}