package com.example.appbooklist.presentation.bookList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appbooklist.R
import com.example.appbooklist.model.Book
import com.example.appbooklist.presentation.BookInteractionListener


class BookListFragment : Fragment() {
    private lateinit var rvBooks: RecyclerView
    private var bookList: ArrayList<Book>? = null
    private lateinit var listener: BookInteractionListener
    private lateinit var v:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_book_list, container, false)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bookList = arguments?.getParcelableArrayList<Book>("data")
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvBooks = v.findViewById(R.id.rvBookList)
        rvBooks.setHasFixedSize(true)
        rvBooks.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
       /* bookList?.let {
            val adapter = BookListAdapter(it) { book ->
                listener.onBookFromListClicked(bookId = book.bookId)
            }
            rvBooks.adapter = adapter
        }*/
        val adapter2 = bookList?.let {
            BookListAdapter2(it,object :BookClickListener{
                override fun onClick(index: Int) {
                    val book = it[index]
                    listener.onBookFromListClicked(bookId = book.bookId)
                }
            })
        }
        rvBooks.adapter = adapter2
    }

    fun setItems(data: ArrayList<Book>) {
        bookList = data
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BookInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement BookInteractionListener")
        }
    }

    companion object {
        fun newInstance(data: ArrayList<Book>): BookListFragment {
            return BookListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList("data", data)
                }
            }
        }
    }

}