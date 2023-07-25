package com.example.tutorial3_calculator

import android.content.Intent
import android.graphics.Insets.add
import android.graphics.Insets.subtract
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.tutorial3_calculator.models.Calculator

class MainActivity : AppCompatActivity() {

    lateinit var edtNumber1:EditText
    lateinit var edtNumber2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumber1 = findViewById (R.id.edtNumber1)
        edtNumber2 = findViewById(R.id.edtNumber2)
    }

    fun buttonClick(v: View){
        var ans = 0.0
        val Calculator = Calculator(
            edtNumber1.text.toString().toDouble(),
            edtNumber2.text.toString().toDouble())
        when(v.id){
            R.id.btnPlus -> ans = Calculator.add()
            R.id.btnMinus -> ans = Calculator.subtract()
            R.id.btnMultiply -> ans = Calculator.multiply()
            R.id.btnDivide -> ans = Calculator.divide()
        }
        println(ans)//this will print the output on the terminal


        val intent = Intent(this, Activity_Display::class.java)
        intent.putExtra("answer", ans)
        startActivity(intent)
        finish()


    }

}