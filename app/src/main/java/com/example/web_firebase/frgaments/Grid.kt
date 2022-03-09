package com.example.web_firebase.frgaments

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.web_firebase.R
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import android.webkit.WebViewClient




class Grid : Fragment() {
    var firebaseDatabase: FirebaseDatabase? = null
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var databaseReference: DatabaseReference? = null
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_grid, container, false)

       val webView = view.findViewById<WebView>(R.id.myWebView)

        webView.settings.javaScriptEnabled = true

        ///
        callweb()
        //

        return  view
    }

    private fun callweb() {
        val database = Firebase.database
        val myRef = database.getReference("home").child("value").child("url1")

        myRef.addValueEventListener(object: ValueEventListener {

            @SuppressLint("SetJavaScriptEnabled")
            override fun onDataChange(snapshot: DataSnapshot) {

                val webView = view?.findViewById<WebView>(R.id.myWebView)

                val value = snapshot.getValue(String::class.java)
                webView!!.loadUrl(value!!)
                webView.settings.javaScriptEnabled = true
                webView.webViewClient = WebViewClient()


                Log.d(TAG, "Value is: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })

    }

}
