package ru.hopes.teacher.models

data class QuestionModel(
    val titleText: String,
    val descriptionText: String,
    val tagList: List<String> = emptyList(),
) : BaseMainListModel