package ru.hopes.teacher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.hopes.teacher.databinding.ListItemCategoryBinding
import ru.hopes.teacher.databinding.ListItemQuestionBinding
import ru.hopes.teacher.holders.BaseMainListViewHolder
import ru.hopes.teacher.holders.CategoryViewHolder
import ru.hopes.teacher.holders.QuestionViewHolder
import ru.hopes.teacher.models.BaseMainListModel
import ru.hopes.teacher.models.CategoryModel
import ru.hopes.teacher.models.QuestionModel

class MainListAdapter : RecyclerView.Adapter<BaseMainListViewHolder<*>>() {

    var items = listOf<BaseMainListModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseMainListViewHolder<*> {
        val layoutInflater = LayoutInflater.from(parent.context)
        when (viewType) {
            QUESTION_VIEW_TYPE -> {
                val binding = ListItemQuestionBinding.inflate(layoutInflater, parent, false)
                return QuestionViewHolder(binding)
            }

            else -> {
                val binding = ListItemCategoryBinding.inflate(layoutInflater, parent, false)
                return CategoryViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(
        holder: BaseMainListViewHolder<*>,
        position: Int
    ) {
        when (holder) {
            is CategoryViewHolder -> holder.bind(items[position] as CategoryModel)
            is QuestionViewHolder -> holder.bind(items[position] as QuestionModel)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is CategoryModel -> CATEGORY_VIEW_TYPE
            is QuestionModel -> QUESTION_VIEW_TYPE
        }
    }

    fun setupList(items: List<BaseMainListModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    companion object {
        const val CATEGORY_VIEW_TYPE = 0
        const val QUESTION_VIEW_TYPE = 1
    }
}