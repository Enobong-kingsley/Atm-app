package com.example.automatedtallermachine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class CheckBalance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_balance)

        val mbundle = intent.extras
        val mbalance = findViewById<TextView>(R.id.balance)
        mbalance.setText(mbundle!!.getCharSequence("balance"))
    }
}