package com.example.appbooklist.presentation.bookList

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appbooklist.R
import com.example.appbooklist.model.Book

class BookListAdapter(items: ArrayList<Book>, private val clickListener: (Book) -> Unit) :
    RecyclerView.Adapter<BookListAdapter.ViewHolder>() {
    var items: ArrayList<Book>? = null
    private var viewHolder: ViewHolder? = null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.booklist_layout, parent, false)
        viewHolder = ViewHolder(view)
        return viewHolder!!
    }

    override fun getItemCount(): Int = items?.count()!!


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items!![position]
        holder.cover!!.setImageResource(item.cover)
        holder.title!!.text = item.title
        holder.bind(item, clickListener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var vista: View = view
        var title: TextView? = null
        var cover: ImageView? = null

        init {
            this.title = this.vista.findViewById(R.id.tvTitleListView)
            this.cover = this.vista.findViewById(R.id.ivCoverListView)
        }

        fun bind(item: Book, clickListener: (Book) -> Unit) {
            Log.d("Click", "ViewHolder_TAG: bind: ${item.title}")
            vista.rootView.setOnClickListener {
                clickListener(item)
            }
        }
    }

}