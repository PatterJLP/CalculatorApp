package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val firstNumber = findViewById<EditText>(R.id.firstNumber)
        val secondNumber = findViewById<EditText>(R.id.secondNumber)
        val additionButton = findViewById<Button>(R.id.button)
        val subtractionButton = findViewById<Button>(R.id.button2)
        val multiplicationButton = findViewById<Button>(R.id.button3)
        val divisionButton = findViewById<Button>(R.id.button4)
        additionButton.setOnClickListener{
            val userNumberOne = firstNumber.text.toString().toIntOrNull()
            val userNumberTwo = secondNumber.text.toString().toIntOrNull()

            if (userNumberOne != null && userNumberTwo != null) {
                val addition = userNumberOne + userNumberTwo
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", addition.toString())
                startActivity(intent)

            }else{
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", "ERROR MAKE SURE YOU ONLY INPUT INTEGERS AND BOTH NUMBERS ARE FULL")
                startActivity(intent)
            }
        }
        subtractionButton.setOnClickListener{
            val userNumberOne = firstNumber.text.toString().toIntOrNull()
            val userNumberTwo = secondNumber.text.toString().toIntOrNull()

            if (userNumberOne != null && userNumberTwo != null) {
                val subtraction = userNumberOne - userNumberTwo
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", subtraction.toString())
                startActivity(intent)

            }else{
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", "ERROR MAKE SURE YOU ONLY INPUT INTEGERS AND BOTH NUMBERS ARE FULL")
                startActivity(intent)
            }
        }
        multiplicationButton.setOnClickListener{
            val userNumberOne = firstNumber.text.toString().toIntOrNull()
            val userNumberTwo = secondNumber.text.toString().toIntOrNull()

            if (userNumberOne != null && userNumberTwo != null) {
                val multiplication = userNumberOne * userNumberTwo
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", multiplication.toString())
                startActivity(intent)

            }else{
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", "ERROR MAKE SURE YOU ONLY INPUT INTEGERS AND BOTH NUMBERS ARE FULL")
                startActivity(intent)
            }
        }
        divisionButton.setOnClickListener{
            val userNumberOne = firstNumber.text.toString().toIntOrNull()
            val userNumberTwo = secondNumber.text.toString().toIntOrNull()

            if (userNumberOne != null && userNumberTwo != null && userNumberTwo != 0) {
                val division = userNumberOne / userNumberTwo
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", division.toString())
                startActivity(intent)

            }else if(userNumberTwo == 0){
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", "ERROR: CANNOT DIVIDE BY 0")
                startActivity(intent)
            }else{
                val intent = Intent(this, CalculatorActivity::class.java)
                intent.putExtra("EXTRA_MESSAGE", "ERROR MAKE SURE YOU ONLY INPUT INTEGERS AND BOTH NUMBERS ARE FULL")
                startActivity(intent)
            }
        }

    }
}