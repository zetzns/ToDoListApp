package com.example.todolistapp

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val todoList = mutableListOf<TodoItem>()
    private lateinit var toDoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        toDoAdapter = TodoAdapter(todoList)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = toDoAdapter
        }
        binding.fab.setOnClickListener {
            showAddTodoDialog()
        }
    }

    private fun showAddTodoDialog() {
        val editText = EditText(this)

        MaterialAlertDialogBuilder(this)
            .setTitle("Add new task")
            .setView(editText)
            .setPositiveButton("Add") { _, _ ->
                val task = editText.text.toString().trim()

                if (task.isNotEmpty()) {
                    todoList.add(TodoItem(task))
                    toDoAdapter.notifyItemInserted(todoList.size - 1)
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}