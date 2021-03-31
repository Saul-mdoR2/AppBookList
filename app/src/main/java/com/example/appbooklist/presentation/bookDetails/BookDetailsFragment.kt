package com.example.appbooklist.presentation.bookDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.appbooklist.R
import com.example.appbooklist.presentation.bookList.BookListFragment


class BookDetailsFragment : Fragment() {

    var v: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_book_details, container, false)
        updateBookDetails()
        return v
    }

    private fun updateBookDetails() {
        val cover: ImageView = v!!.findViewById(R.id.ivCover)
        val title: TextView = v!!.findViewById(R.id.tvTitle)
        val author: TextView = v!!.findViewById(R.id.tvAuthor)
        val synopsis: TextView = v!!.findViewById(R.id.tvSynopsis)
        val index = arguments!!.getInt("INDEX", 0)

        val currentBook = BookListFragment.bookList[index]

        cover.setImageResource(currentBook.cover)
        title.text = currentBook.title
        author.text = currentBook.author
        synopsis.text = currentBook.synopsis
    }
}