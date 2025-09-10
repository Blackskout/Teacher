package ru.hopes.teacher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.hopes.teacher.databinding.ListItemCategoryBinding
import ru.hopes.teacher.holders.CategoryViewHolder
import ru.hopes.teacher.models.CategoryModel

class MainListAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    var items = listOf<CategoryModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemCategoryBinding.inflate(layoutInflater, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int
    ) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setupList(items: List<CategoryModel>) {
        this.items = items
        notifyDataSetChanged()
    }
}