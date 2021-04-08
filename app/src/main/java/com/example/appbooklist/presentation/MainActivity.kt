package com.example.appbooklist.presentation

import android.content.SharedPreferences
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
    private lateinit var currentBookId: String
    val KEY = "com.example.appbooklist.presentation.MainActivity.bookId"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = Repository.createList()
        bookListFragment = BookListFragment.newInstance(data)
        bookListFragment.setItems(data)
        showFragment(bookListFragment)
    }

    override fun onBookFromListClicked(bookId: String) {
        Log.d("MainActivity_TAG:", "onBookFromListClicked: $bookId")
        currentBookId = bookId
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
                fragmentTransaction.replace(R.id.flListFragment, fragment)
            }
            else -> {
                fragmentTransaction.replace(R.id.flDetailsFragment, fragment)
                fragmentTransaction.addToBackStack(null)
            }
        }
        fragmentTransaction.commit()
    }

}