package com.example.appbooklist.presentation.bookList

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appbooklist.R
import com.example.appbooklist.model.Book
import com.example.appbooklist.presentation.BookInteractionListener
import com.example.appbooklist.presentation.bookDetails.BookDetails
import com.example.appbooklist.presentation.bookDetails.BookDetailsFragment


class BookListFragment : Fragment() {
    private lateinit var rvBooks: RecyclerView
    private var actualPosition = 0
    private var landScreen = false
    private var bookList: ArrayList<Book>? = null
    private lateinit var listener: BookInteractionListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)
        rvBooks = view.findViewById(R.id.rvBookList)
        initListView()
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BookInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement BookInteractionListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListView()
        val flDetails = activity!!.findViewById<FrameLayout>(R.id.flDetailsLand)
        landScreen = flDetails != null && flDetails.visibility == View.VISIBLE

        if (landScreen) {
            showDetails(actualPosition)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bookList = arguments?.getParcelableArrayList<Book>("data")
    }

    private fun initListView() {
        rvBooks.setHasFixedSize(true)
        rvBooks.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        bookList?.let {
            val adapter = BookListAdapter(it, object : BookClickListener {
                override fun onClick(vista: View, index: Int) {
//                    showDetails(index)
                    listener.onBookFromListClicked(it[index].bookId)
                }
            })
            rvBooks.adapter = adapter
        }

    }

    private fun showDetails(index: Int) {
        actualPosition = index
        if (landScreen) {
            var fragmentDetails =
                activity!!.supportFragmentManager.findFragmentById(R.id.flDetailsLand) as? BookDetailsFragment

            if (fragmentDetails == null || fragmentDetails.arguments?.getInt("INDEX", 0) != index) {
                fragmentDetails =
                    BookDetailsFragment()
                val args = Bundle()
                args.putInt("INDEX", index)
                fragmentDetails.arguments = args
                val fragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.flDetailsLand, fragmentDetails)
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                fragmentTransaction.commit()
            }
        } else {
            val intent = Intent(activity, BookDetails::class.java)
            intent.putExtra("INDEX", index)
            startActivity(intent)
        }
    }

    fun setItems(data: ArrayList<Book>) {
        bookList = data
        initListView()
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