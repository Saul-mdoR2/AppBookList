package com.example.appbooklist.presentation.bookList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appbooklist.R
import com.example.appbooklist.model.Book

class BookListAdapter(
    private var context: Context,
    items: ArrayList<Book>,
    private var listener: BookClickListener
) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {
    var items: ArrayList<Book>? = null
    private var viewHolder: ViewHolder? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.booklist_layout, parent, false)
        viewHolder = ViewHolder(view, listener)
        return viewHolder!!
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items!![position]
        holder.cover!!.setImageResource(item.cover)
        holder.title!!.text = item.title
    }

    class ViewHolder(vista: View, listener: BookClickListener) : RecyclerView.ViewHolder(vista),
        View.OnClickListener {
        private var view: View = vista
        var title: TextView? = null
        var cover: ImageView? = null


        private var clickListener: BookClickListener? = null

        init {
            this.title = view.findViewById(R.id.tvTitleListView)
            this.cover = view.findViewById(R.id.ivCoverListView)

            clickListener = listener

            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            clickListener?.onClick(v!!, adapterPosition)
        }
    }

}