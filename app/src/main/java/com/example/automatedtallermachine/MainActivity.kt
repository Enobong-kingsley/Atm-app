package com.example.automatedtallermachine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val OkayBttn = findViewById<Button>(R.id.ok_button)
        val Balance = findViewById<EditText>(R.id.initial_balance)
        val Pin = findViewById<EditText>(R.id.pin_id)

            OkayBttn.setOnClickListener {
                val intent = Intent(this, TransactionActivity::class.java)
                if (TextUtils.isEmpty(Balance.text.toString())) {
                    Balance.setError("Enter Balance..")
                    return@setOnClickListener
                }
                if (TextUtils.isEmpty(Pin.text.toString())) {
                    Pin.setError("Enter Pin..")
                    return@setOnClickListener
                }
                val myBalance: Int = Balance.editableText.toString().toInt()
                val myPin:Int = Pin.editableText.toString().toInt()
                if (myBalance < 10000) {
                    Toast.makeText(this@MainActivity, "You Need More Cash", Toast.LENGTH_LONG)
                        .show()
                }else if  (myPin != 1234){
                        Toast.makeText(this,"You have entered an incorrect pin!!",Toast.LENGTH_LONG).show()
                }
               else{
                    val bundle = Bundle()
                    bundle.putString("amount",Balance.getText().toString())
                    intent.putExtras(bundle)

                startActivity(intent)
                }
        }
    }
}