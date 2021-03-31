package com.example.appbooklist.presentation.bookDetails

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appbooklist.R

class BookDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish()
            return
        }

        val fragmentDetails =
            BookDetailsFragment()
        val bundle = Bundle()
        bundle.putInt("INDEX", intent.getIntExtra("INDEX", 0))
        fragmentDetails.arguments = bundle
        supportFragmentManager.beginTransaction().add(R.id.flDetails, fragmentDetails).commit()
    }
}