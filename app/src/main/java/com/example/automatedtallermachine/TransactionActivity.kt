package com.example.automatedtallermachine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_check_balance.*
import kotlinx.android.synthetic.main.activity_transaction.*

class TransactionActivity : AppCompatActivity() {
    var Dbalance: CharSequence? = "0"
    private lateinit var AmountDis: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)
        AmountDis = findViewById(R.id.amount_display)
        val bundle = intent.extras
        bundle.let {
            Dbalance = bundle?.getCharSequence("amount")
            AmountDis.text = Dbalance
        }



        val Withdraw = findViewById<Button>(R.id.withdraw)
        val Deposit = findViewById<Button>(R.id.deposit)
        val Transfer = findViewById<Button>(R.id.transfer)
        val mCheckBalance = findViewById<Button>(R.id.check_balance)


        Transfer.setOnClickListener {
            (showTransferAlert(v = Transfer))
        }
        Deposit.setOnClickListener {
            (showDepositAlert(v = Deposit))
        }
        Withdraw.setOnClickListener {
            (showWithdrawAlert(v = Withdraw))
        }

        val mi : Int = AmountDis.text.toString().toInt()
        mCheckBalance.setOnClickListener{
            val intent = Intent(this,CheckBalance::class.java)
            if (mi > 0){
                val m_bundle = Bundle()
                m_bundle.putString("balance",AmountDis.getText().toString())
                intent.putExtras(m_bundle)
                startActivity(intent)
            }

        }

    }

    fun showWithdrawAlert(v: View) {
        val inflater = layoutInflater
        val inflate_view = inflater.inflate(R.layout.withdraw_transaction, null)
        val WithdrawDial = inflate_view.findViewById<EditText>(R.id.withdraw_dialog)

        val WidrawDialogBuilder = AlertDialog.Builder(this)
        WidrawDialogBuilder.setTitle("Withdrawal Transaction")
        WidrawDialogBuilder.setView(inflate_view)
        WidrawDialogBuilder.setCancelable(false)
        WidrawDialogBuilder.setNegativeButton("Cancel") { dialogInterface, i ->
            Toast.makeText(this, "Canceled", Toast.LENGTH_LONG).show()
        }

        WidrawDialogBuilder.setPositiveButton("Ok") { dialogInterface, i ->
            val Withdrawal = WithdrawDial.text.toString()

            if (TextUtils.isEmpty(WithdrawDial.text.toString())) {
                WithdrawDial.setError("Enter Amount")
                Toast.makeText(this, "Please input amount ", Toast.LENGTH_SHORT).show()
            }else {
                val widthdraw = WithdrawDial.text.toString().toInt()
                Dbalance = (Dbalance.toString().toInt() - widthdraw).toString()
                AmountDis.text = Dbalance

                Toast.makeText(this, "Transaction Successful", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Amount Withdraw: $Withdrawal", Toast.LENGTH_LONG).show()
            }
        }
        val dialog = WidrawDialogBuilder.create()
        dialog.show()
    }
    fun showDepositAlert(v: View) {
        val inflater = layoutInflater
        val inflate_view = inflater.inflate(R.layout.deposit_tansaction, null)
        val DepositDial = inflate_view.findViewById<EditText>(R.id.deposit_amount_dialog)

        val DepositDialogBuilder = AlertDialog.Builder(this)
        DepositDialogBuilder.setTitle("Deposit Transaction")
        DepositDialogBuilder.setView(inflate_view)
        DepositDialogBuilder.setCancelable(false)
        DepositDialogBuilder.setNegativeButton("Cancel") { dialogInterface, i ->
            Toast.makeText(this, "Canceled", Toast.LENGTH_LONG).show()
        }

        DepositDialogBuilder.setPositiveButton("Ok") { dialogInterface, i ->
            val Withdrawal = DepositDial.text.toString()

            if (TextUtils.isEmpty(DepositDial.text.toString())) {
                DepositDial.setError("Enter Amount")
                Toast.makeText(this, "Please input amount ", Toast.LENGTH_SHORT).show()
            }else {
                val widthdraw = DepositDial.text.toString().toInt()
                Dbalance = (Dbalance.toString().toInt() + widthdraw).toString()
                AmountDis.text = Dbalance

                Toast.makeText(this, "Transaction Successful", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Amount Deposit: $Withdrawal", Toast.LENGTH_LONG).show()
            }
        }
        val dialog = DepositDialogBuilder.create()
        dialog.show()
    }
    fun showTransferAlert(v: View) {
        val inflater = layoutInflater
        val inflate_view = inflater.inflate(R.layout.withdraw_transaction, null)
        val WithdrawDial = inflate_view.findViewById<EditText>(R.id.withdraw_dialog)

        val WidrawDialogBuilder = AlertDialog.Builder(this)
        WidrawDialogBuilder.setTitle("Transfer Transaction")
        WidrawDialogBuilder.setView(inflate_view)
        WidrawDialogBuilder.setCancelable(false)
        WidrawDialogBuilder.setNegativeButton("Cancel") { dialogInterface, i ->
            Toast.makeText(this, "Canceled", Toast.LENGTH_LONG).show()
        }

        WidrawDialogBuilder.setPositiveButton("Ok") { dialogInterface, i ->
            val Withdrawal = WithdrawDial.text.toString()

            if (TextUtils.isEmpty(WithdrawDial.text.toString())) {
                WithdrawDial.setError("Enter Amount")
                Toast.makeText(this, "Please input amount ", Toast.LENGTH_SHORT).show()
            }else {
                val widthdraw = WithdrawDial.text.toString().toInt()
                Dbalance = (Dbalance.toString().toInt() - widthdraw).toString()
                AmountDis.text = Dbalance

                Toast.makeText(this, "Transaction Successful", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Amount Transfer: $Withdrawal", Toast.LENGTH_LONG).show()
            }
        }
        val dialog = WidrawDialogBuilder.create()
        dialog.show()
    }
}

