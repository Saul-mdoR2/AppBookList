package com.example.appbooklist.repository

import android.content.Context
import com.example.appbooklist.R
import com.example.appbooklist.model.Book

object Repository {
    var bookList = ArrayList<Book>()


    fun createList(context: Context): ArrayList<Book> {
        bookList = ArrayList()
        bookList.add(
            Book(
                cover = R.drawable.cover1,
                title = "Chain of Gold",
                author = "Cassandra Clare",
                synopsis = context.resources.getString(R.string.synopsis1)
            )
        )
        bookList.add(
            Book(
                R.drawable.cover2,
                "It",
                "Stephen King",
                context.resources.getString(R.string.synopsis2)
            )
        )
        bookList.add(
            Book(
                R.drawable.cover3,
                "Inferno",
                "Dan Brown",
                context.resources.getString(R.string.synopsis3)
            )
        )
        bookList.add(
            Book(
                R.drawable.cover4,
                "11/22/63",
                "Stephen King",
                context.resources.getString(R.string.synopsis4)
            )
        )
        bookList.add(
            Book(
                R.drawable.cover5,
                "World War Z",
                "Max Brooks",
                context.resources.getString(R.string.synopsis5)
            )
        )
        bookList.add(
            Book(
                R.drawable.cover6,
                "Mr. Mercedes",
                "Stephen King",
                context.resources.getString(R.string.synopsis6)
            )
        )

        return bookList
    }

    fun getDetailsById(bookId: String): Book? {
        return bookList.firstOrNull { it.bookId == bookId }
    }
}