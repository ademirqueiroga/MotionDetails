package com.ademir.motiondetail

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout


class CustomCoordinatorLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CoordinatorLayout(context, attrs, defStyleAttr) {

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray) {
        if (parentShouldAnimate(dy)) {
            (parent as? MotionLayout)?.onNestedPreScroll(target, dx, dy, consumed)
        } else {
            super.onNestedPreScroll(target, dx, dy, consumed)
        }
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        if (parentShouldAnimate(dy)) {
            (parent as? MotionLayout)?.onNestedPreScroll(target, dx, dy, consumed, type)
        } else {
            super.onNestedPreScroll(target, dx, dy, consumed, type)
        }
    }

    private fun childShouldAnimate(dy: Int): Boolean {
        val child = findViewById<CollapsibleLayout>(R.id.collapsibleStuff)
        return (child.progress < 1f && dy > 0) || child.progress != 0f && dy < 0
    }

    private fun parentShouldAnimate(dy: Int): Boolean {
        val parent = (parent as? MotionLayout) ?: return false
        return when {
            dy > 0 -> parent.progress < 1f
            else -> !childShouldAnimate(dy) && parent.progress > 0
        }
    }

}