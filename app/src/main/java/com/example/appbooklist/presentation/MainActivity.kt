package com.example.appbooklist.presentation

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.appbooklist.R
import com.example.appbooklist.presentation.bookDetails.BookDetailsFragment
import com.example.appbooklist.presentation.bookList.BookListFragment
import com.example.appbooklist.repository.Repository

class MainActivity : AppCompatActivity(), BookInteractionListener {
    private lateinit var bookListFragment: BookListFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = Repository.createList()
        bookListFragment = BookListFragment.newInstance(data)
        bookListFragment.setItems(data)
        showFragment(bookListFragment)
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
        showFragment(bookDetailsFragment)
    }

    private fun showFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        when (fragment::class.java) {
            BookListFragment::class.java -> {
                fragmentTransaction.replace(R.id.flListLand, fragment)
            }
            else -> {
                fragmentTransaction.replace(R.id.flDetailsLand, fragment)
                fragmentTransaction.addToBackStack(null)
            }
        }
        fragmentTransaction.commit()
    }
}