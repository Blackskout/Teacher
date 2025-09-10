package ru.hopes.teacher.holders


import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import androidx.core.view.isVisible
import ru.hopes.teacher.R
import ru.hopes.teacher.databinding.ListItemQuestionBinding
import ru.hopes.teacher.models.QuestionModel

class QuestionViewHolder(
    private val binding: ListItemQuestionBinding,
) : BaseMainListViewHolder<QuestionModel>(binding.root) {


    override fun bind(item: QuestionModel) {
        binding.questionTitle.text = item.titleText

        binding.questionDescription.isVisible = item.descriptionText.isNotBlank()
        binding.questionDescription.text = item.descriptionText

        binding.questionTagList.isVisible = item.tagList.isNotEmpty()
        binding.questionTagList.bindTagList(item.tagList)
    }

    private fun LinearLayout.bindTagList(tagList: List<String>) {
        removeAllViews()
        for (tag in tagList) {
            val tagView = TextView(context).apply {
                text = tag
                setTextColor(context.getColor(R.color.tag_text_color))
                textSize = 12f
            }
            val space = Space(context).apply {
                val size = context.resources.getDimension(R.dimen.space_small).toInt()
                layoutParams = LinearLayout.LayoutParams(size, size)
            }
            addView(tagView)
            addView(space)
        }
    }
}