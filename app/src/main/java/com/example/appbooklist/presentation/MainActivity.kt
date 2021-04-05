package com.example.appbooklist.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.appbooklist.R
import com.example.appbooklist.presentation.bookDetails.BookDetailsFragment
import com.example.appbooklist.presentation.bookList.BookListFragment
import com.example.appbooklist.repository.Repository

class MainActivity : AppCompatActivity(), BookInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = Repository.createList(this)
        val bookListFragment = BookListFragment()
        bookListFragment.setItems(data)

        //1. Iniciar llamada para obtener la información
        //2. Crear los fragmentos
        //3. Asignar información a fragmentos
        //4. Obtener en fragmento de lista el identificador del elemento y mandarlo a la actividad
    }

    override fun onBookFromListClicked(bookId: String) {
        Log.d("MainActivity_TAG:", "onBookFromListClicked: $bookId")
        showDetails(bookId)
    }

    private fun showDetails(bookId: String) {
        val data = Repository.getDetailsById(bookId) ?: return
        val bookDetailsFragment = BookDetailsFragment.newInstance(data)

    }
}