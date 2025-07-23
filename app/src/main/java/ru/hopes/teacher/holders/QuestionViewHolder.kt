package ru.hopes.teacher.holders


import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import androidx.core.view.isVisible
import ru.hopes.teacher.R
import ru.hopes.teacher.databinding.ListItemQuestionBinding

class QuestionViewHolder(
    private val questionBinding: ListItemQuestionBinding,
) {

    fun bind(
        titleText: String,
        descriptionText: String,
        tagList: List<String>,
    ) {
        questionBinding.questionTitle.text = titleText

        questionBinding.questionDescription.isVisible = descriptionText.isNotBlank()
        questionBinding.questionDescription.text = descriptionText

        questionBinding.questionTagList.isVisible = tagList.isNotEmpty()
        questionBinding.questionTagList.bindTagList(tagList)
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
                layoutParams = LinearLayout.LayoutParams(size,size)
            }
            addView(tagView)
            addView(space)
        }
    }
}