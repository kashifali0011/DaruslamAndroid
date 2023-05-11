package com.dtech.darussalam.utilities.helper

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dtech.darussalam.R

import com.dtech.darussalam.view.base.ActivityBase

class CirclePagerIndicatorDecorationTop: RecyclerView.ItemDecoration() {
    private val DP = Resources.getSystem().displayMetrics.density

    private val mIndicatorHeight = (DP * 18).toInt()
    private val mIndicatorStrokeWidth = DP * 2
    private val mIndicatorItemLength = DP * 18

    private val mIndicatorItemPadding = DP * 2
    private val mInterpolator = AccelerateDecelerateInterpolator()

    private val mPaint = Paint()

    init {
        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.strokeWidth = mIndicatorStrokeWidth
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
    }


    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        val itemCount = parent.adapter!!.itemCount
        // center horizontally, calculate width and subtract half from center
        val totalLength = mIndicatorItemLength * itemCount
        val paddingBetweenItems = Math.max(0, itemCount - 1) * mIndicatorItemPadding
        val indicatorTotalWidth = totalLength + paddingBetweenItems
        val indicatorStartX = (parent.width - indicatorTotalWidth) / 2f

        // center vertically in the allotted space
        val indicatorPosY = parent.height.toFloat() * 0.05f
        drawInactiveIndicators(c, indicatorStartX, indicatorPosY, itemCount)


        val layoutManager = parent.layoutManager as LinearLayoutManager?
        val activePosition = layoutManager!!.findFirstVisibleItemPosition()
        if (activePosition == RecyclerView.NO_POSITION) {
            return
        }

        val activeChild = layoutManager.findViewByPosition(activePosition)
        val left = activeChild!!.left
        val width = activeChild.width

        val progress = mInterpolator.getInterpolation(left * -1 / width.toFloat())

        drawHighlights(c, indicatorStartX, indicatorPosY, activePosition, progress, itemCount)
    }
    private fun drawInactiveIndicators(c: Canvas, indicatorStartX: Float, indicatorPosY: Float, itemCount: Int) {
        mPaint.color = ContextCompat.getColor(ActivityBase.activity, R.color.invoice_background_color)

        val itemWidth = mIndicatorItemLength + mIndicatorItemPadding

        var start = indicatorStartX
        for (i in 0 until itemCount) {
            c.drawCircle(start + mIndicatorItemLength,indicatorPosY,itemWidth/4,mPaint)
            start += itemWidth
        }
    }
    private fun drawHighlights(
        c: Canvas, indicatorStartX: Float, indicatorPosY: Float,
        highlightPosition: Int, progress: Float, itemCount: Int
    ) {
        mPaint.color = ContextCompat.getColor(ActivityBase.activity,R.color.blue)


        val itemWidth = mIndicatorItemLength + mIndicatorItemPadding

        if (progress == 0f) {
            val highlightStart = indicatorStartX + itemWidth * highlightPosition

//            c.drawLine(
//                highlightStart, indicatorPosY,
//                highlightStart + mIndicatorItemLength, indicatorPosY, mPaint
//            )
            c.drawCircle(highlightStart,indicatorPosY,itemWidth/4,mPaint);


        } else {
            var highlightStart = indicatorStartX + itemWidth * highlightPosition
            val partialLength = mIndicatorItemLength * progress

//            c.drawLine(
//                highlightStart + partialLength, indicatorPosY,
//                highlightStart + mIndicatorItemLength, indicatorPosY, mPaint
//            )
            c.drawCircle(highlightStart + mIndicatorItemLength,indicatorPosY,itemWidth/6,mPaint);


//            if (highlightPosition < itemCount - 1) {
//                highlightStart += itemWidth
//
//                c.drawLine(
//                    highlightStart, indicatorPosY,
//                    highlightStart + partialLength, indicatorPosY, mPaint
//                )
//            }
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
           outRect.bottom = mIndicatorHeight
    }
    companion object {
      //  private val DP = Resources.getSystem().displayMetrics.density
    }

}

