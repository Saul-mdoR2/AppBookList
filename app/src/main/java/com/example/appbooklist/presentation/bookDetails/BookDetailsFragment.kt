package com.example.appbooklist.presentation.bookDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.appbooklist.R
import com.example.appbooklist.model.Book
import com.example.appbooklist.presentation.bookList.BookListFragment


class BookDetailsFragment : Fragment() {
    var v: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_book_details, container, false)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        updateBookDetails()
    }

    private fun updateBookDetails() {
        val cover: ImageView = v!!.findViewById(R.id.ivCover)
        val title: TextView = v!!.findViewById(R.id.tvTitle)
        val author: TextView = v!!.findViewById(R.id.tvAuthor)
        val synopsis: TextView = v!!.findViewById(R.id.tvSynopsis)

        val data = arguments?.getParcelable<Book>("data")

        cover.setImageResource(data!!.cover)
        title.text = data.title
        author.text = data.author
        synopsis.text = data.synopsis
    }

    companion object {
        fun newInstance(data: Book): BookDetailsFragment {
            return BookDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("data", data)
                }
            }
        }
    }
}