package org.karabalin.lab17

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Path
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity

private class Draw2D(context: Context?) : View(context) {
    private var mPaint: Paint = Paint()
    private var mPath: Path = Path()

    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(mPath, mPaint)
        with(mPaint) {
            color = Color.BLACK
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
            strokeCap = Paint.Cap.ROUND
            strokeWidth = 10f
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> mPath.moveTo(event.x, event.y)
            MotionEvent.ACTION_MOVE -> {
                mPath.lineTo(event.x, event.y)
                invalidate()
            }

            MotionEvent.ACTION_UP -> {}
        }
        return true
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val draw2D = Draw2D(this)
        setContentView(draw2D)
    }
}