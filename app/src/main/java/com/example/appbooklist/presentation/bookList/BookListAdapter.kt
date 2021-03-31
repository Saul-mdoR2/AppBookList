package com.example.appbooklist.presentation.bookList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.appbooklist.R
import com.example.appbooklist.model.Book

class BookListAdapter(private var context: Context, items: ArrayList<Book>) : BaseAdapter() {
    var items: ArrayList<Book>? = null

    init {
        this.items = items
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder: ViewHolder?
        var view: View? = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.booklist_layout, null)
            viewHolder =
                ViewHolder(
                    view
                )
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as? ViewHolder
        }

        val item = getItem(position) as Book
        viewHolder?.title!!.text = item.title
        viewHolder.cover?.setImageResource(item.cover)

        return view!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items?.count()!!
    }

    private class ViewHolder(vista: View) {
        var title: TextView? = null
        var cover: ImageView? = null

        init {
            this.title = vista.findViewById(R.id.tvTitleListView)
            this.cover = vista.findViewById(R.id.ivCoverListView)
        }
    }
}