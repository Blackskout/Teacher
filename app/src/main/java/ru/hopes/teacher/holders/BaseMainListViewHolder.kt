package ru.hopes.teacher.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.hopes.teacher.models.BaseMainListModel

sealed class BaseMainListViewHolder<T: BaseMainListModel>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T)
}