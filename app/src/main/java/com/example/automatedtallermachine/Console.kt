package com.example.automatedtallermachine

import android.text.TextUtils
import java.util.*

fun main(args: Array<String>) {
        val number = Scanner(System.`in`)
        print("Enter Pin")
       var fPin = number.nextInt()
    println("Your pin is $fPin")
    println("Enter Current Balance")
    var fBalance = number.nextInt()
    println("Your Current Balance is $fBalance")
    println("What type of transaction would you like to do ?")
    val read = readLine()!!
    println("You currently want to: $read")
    println("Enter Amount")
    var fAmount = number.nextInt()
    var sub = fBalance - fAmount
    println("Transaction Successful ")
    println("Your current balance is $sub")
    println("What type of transaction would you like to do next ?")
    val sread = readLine()!!
    println("You currently want to: $sread")
    println("Enter Amount")
    var sAmount = number.nextInt()
    var add = fBalance - (sAmount)
    println("Your current balance is $add")



    }

