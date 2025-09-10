package ru.hopes.teacher.holders

import ru.hopes.teacher.databinding.ListItemCategoryBinding
import ru.hopes.teacher.models.CategoryModel

class CategoryViewHolder(
    private val binding: ListItemCategoryBinding,
) : BaseMainListViewHolder<CategoryModel>(binding.root) {

    override fun bind(item: CategoryModel) {
        binding.root.text = item.categoryTitle
    }
}