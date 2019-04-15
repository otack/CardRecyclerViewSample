package com.example.cardrecyclerviewsample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class SingleCardListDecoration(
    private val context: Context,
    private val bottomOnly: Boolean = false
) : RecyclerView.ItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        (0 until parent.childCount).map {
            val itemView = parent.getChildAt(it)
            val position = parent.getChildAdapterPosition(itemView)
            val count = parent.adapter?.itemCount ?: 0
            if (count == 1) {
                itemView.background = ContextCompat.getDrawable(context, R.drawable.common_list_item_bg)
                itemView.outlineProvider = ViewOutlineProvider.BACKGROUND
            } else if (!bottomOnly && position == 0) {
                itemView.background = ContextCompat.getDrawable(context, R.drawable.common_list_top_item_bg)
                itemView.outlineProvider = ViewOutlineProvider.BACKGROUND
            } else if (position == count - 1) {
                itemView.background = ContextCompat.getDrawable(context, R.drawable.common_list_bottom_item_bg)
                itemView.outlineProvider = object: ViewOutlineProvider() {
                    override fun getOutline(view: View?, outline: Outline?) {
                        outline?.setRoundRect(
                            0,
                            // 背景の矩形の丸さと影の深さから、オフセットすべきサイズを算出する
                            ((view?.elevation ?: 0f) * 1.5f -
                                    context.resources.getDimensionPixelSize(R.dimen.card_radius)).toInt(),
                            view?.width ?: 0,
                            view?.height ?: 0,
                           context.resources.getDimension(R.dimen.card_radius)
                        )
                    }
                }
            } else {
                itemView.background = ContextCompat.getDrawable(context, R.drawable.common_list_middle_item_bg)
                itemView.outlineProvider = object: ViewOutlineProvider() {
                    override fun getOutline(view: View?, outline: Outline?) {
                        outline?.setRect(
                            0,
                            view?.elevation?.toInt() ?: 0,
                            view?.width ?: 0,
                            view?.height ?: 0
                        )
                    }
                }
            }
        }
    }
}