package ru.hopes.teacher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.hopes.teacher.databinding.ListItemCategoryBinding
import ru.hopes.teacher.databinding.ListItemQuestionBinding
import ru.hopes.teacher.holders.BaseMainListViewHolder
import ru.hopes.teacher.holders.CategoryViewHolder
import ru.hopes.teacher.holders.QuestionViewHolder
import ru.hopes.teacher.models.BaseMainListModel
import ru.hopes.teacher.models.CategoryModel
import ru.hopes.teacher.models.QuestionModel

class MainListAdapter :
    ListAdapter<BaseMainListModel, BaseMainListViewHolder<*>>(MainListDiffUtil) {

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
            is CategoryViewHolder -> holder.bind(getItem(position) as CategoryModel)
            is QuestionViewHolder -> holder.bind(getItem(position) as QuestionModel)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is CategoryModel -> CATEGORY_VIEW_TYPE
            is QuestionModel -> QUESTION_VIEW_TYPE
        }
    }

    companion object {
        const val CATEGORY_VIEW_TYPE = 0
        const val QUESTION_VIEW_TYPE = 1

        object MainListDiffUtil : DiffUtil.ItemCallback<BaseMainListModel>() {
            override fun areItemsTheSame(
                oldItem: BaseMainListModel,
                newItem: BaseMainListModel
            ): Boolean {
                return oldItem.javaClass == newItem.javaClass
            }

            override fun areContentsTheSame(
                oldItem: BaseMainListModel,
                newItem: BaseMainListModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}