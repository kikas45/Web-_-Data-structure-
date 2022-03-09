package com.example.web_firebase.frgaments

import android.annotation.SuppressLint
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.web_firebase.R
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference








class Home : Fragment() {
    var firebaseDatabase: FirebaseDatabase? = null
    var databaseReference: DatabaseReference? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_grid, container, false)


        val webView = view.findViewById<WebView>(R.id.myWebView)

        webView.settings.javaScriptEnabled = true

        ///
        callweb()
        //

        return  view
    }

    private fun callweb() {

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase!!.getReference("home").child("value").child("url2")

        databaseReference?.addValueEventListener(object: ValueEventListener {

            @SuppressLint("SetJavaScriptEnabled")
            override fun onDataChange(snapshot: DataSnapshot) {

                val webView = view?.findViewById<WebView>(R.id.myWebView)

                val value = snapshot.getValue(String::class.java)
                webView!!.loadUrl(value!!)
                webView.settings.javaScriptEnabled = true
                webView.webViewClient = WebViewClient()


                Log.d(ContentValues.TAG, "Value is: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())

                Toast.makeText(context, "message" , Toast.LENGTH_LONG).show()
            }

        })

    }

}