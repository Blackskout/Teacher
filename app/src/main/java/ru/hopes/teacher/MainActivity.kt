package ru.hopes.teacher

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.hopes.teacher.databinding.ActivityMainBinding
import ru.hopes.teacher.models.CategoryModel
import ru.hopes.teacher.models.QuestionModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter = MainListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.mainRv.adapter = adapter

        binding.root.postDelayed(
            {
                adapter.submitList(
                    listOf(
                        CategoryModel("Kotlin"),
                        QuestionModel("Что такое seald класс?", "Где и зачем используется?"),
                        CategoryModel("Android"),
                        QuestionModel(
                            "Основные компоненты Android?",
                            "Назовите все компоненты и для чего они используются",
                            listOf("Android SDK",)
                        ),
                        CategoryModel("Coroutines"),
                        QuestionModel(
                            "Что такое корутина?",
                            "Зачем они нужны и какую проблему они решают?"
                        ),
                        CategoryModel("Dagger 2"),
                        CategoryModel("Network"),
                        CategoryModel("Database"),
                    )
                )
            },
            10000
        )

        binding.root.postDelayed(
            {
                adapter.submitList(
                    listOf(
                        CategoryModel("Android"),
                        QuestionModel(
                            "Основные компоненты Android?",
                            "Назовите все компоненты и для чего они используются",
                            listOf("Android SDK",)
                        ),
                        CategoryModel("Dagger 2"),
                        CategoryModel("Network"),
                        CategoryModel("Database"),
                    )
                )
            },
            5000
        )
    }
}