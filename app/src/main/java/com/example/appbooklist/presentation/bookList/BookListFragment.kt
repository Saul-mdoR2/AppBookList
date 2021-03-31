package com.example.appbooklist.presentation.bookList

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ListView
import androidx.fragment.app.FragmentTransaction
import com.example.appbooklist.R
import com.example.appbooklist.presentation.bookDetails.BookDetails
import com.example.appbooklist.model.Book
import com.example.appbooklist.presentation.bookDetails.BookDetailsFragment


class BookListFragment : Fragment() {
    private lateinit var lstBooks: ListView
    private var actualPosition = 0
    private var landScreen = false

    companion object {
        lateinit var bookList: ArrayList<Book>
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)
        lstBooks = view.findViewById(R.id.lvBookList)
        initListView()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListView()
        val flDetails = activity!!.findViewById<FrameLayout>(R.id.flDetailsLand)
        landScreen = flDetails != null && flDetails.visibility == View.VISIBLE

        if (landScreen) {
            lstBooks.choiceMode = ListView.CHOICE_MODE_SINGLE
            showDetails(actualPosition)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createList()
    }
    private fun createList() {
        bookList = ArrayList()
        bookList.add(
            Book(
                R.drawable.cover1,
                "Chain of Gold",
                "Cassandra Clare",
                resources.getString(R.string.synopsis1)
            )
        )
        bookList.add(
            Book(
                R.drawable.cover2,
                "It",
                "Stephen King",
                resources.getString(R.string.synopsis2)
            )
        )
        bookList.add(
            Book(
                R.drawable.cover3,
                "Inferno",
                "Dan Brown",
                resources.getString(R.string.synopsis3)
            )
        )
        bookList.add(
            Book(
                R.drawable.cover4,
                "11/22/63",
                "Stephen King",
                resources.getString(R.string.synopsis4)
            )
        )
        bookList.add(
            Book(
                R.drawable.cover5,
                "World War Z",
                "Max Brooks",
                resources.getString(R.string.synopsis5)
            )
        )
        bookList.add(
            Book(
                R.drawable.cover6,
                "Mr. Mercedes",
                "Stephen King",
                resources.getString(R.string.synopsis6)
            )
        )
    }
    private fun initListView() {
        val adapter =
            BookListAdapter(
                activity!!,
                bookList
            )
        lstBooks.adapter = adapter
        lstBooks.setOnItemClickListener { _, _, position, _ ->
            showDetails(position)
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

}