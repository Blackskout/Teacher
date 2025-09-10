package ru.hopes.teacher.holders

import androidx.recyclerview.widget.RecyclerView
import ru.hopes.teacher.databinding.ListItemCategoryBinding
import ru.hopes.teacher.models.CategoryModel

class CategoryViewHolder(
    private val binding: ListItemCategoryBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CategoryModel) {
        binding.root.text = item.categoryTitle
    }
}