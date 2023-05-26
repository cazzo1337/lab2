package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.ceil
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(view: View){
        val a:Double? = findViewById<EditText>(R.id.a).text.toString().toDoubleOrNull()
        val b:Double? = findViewById<EditText>(R.id.b).text.toString().toDoubleOrNull()
        val c:Double? = findViewById<EditText>(R.id.c).text.toString().toDoubleOrNull()

        if(a == null || b == null || c == null){
            Toast.makeText(this, "Одно из полей пустое!", Toast.LENGTH_SHORT).show()
            return
        }
        if ( a == 0.0 && b != 0.0){
            val x: Double = (-1 * c) / b
            Toast.makeText(this, "Уравение является линейным и имеет корень: x = $x", Toast.LENGTH_SHORT).show()
            return
        }
        if (a == 0.0 && b == 0.0 && c == 0.0){
            Toast.makeText(this, "Бесконечное множество корней", Toast.LENGTH_SHORT).show()
            return
        }
        if (a == 0.0 && b == 0.0 && c != 0.0){
            Toast.makeText(this, "Корней нет", Toast.LENGTH_SHORT).show()
            return

        }

        val d : Double = Math.pow(b, 2.0) - 4 * a * c

        if (d > 0){
            val x1 = (-b + sqrt(d)) / (2 * a)
            val x2 = (-b - sqrt(d)) / (2 * a)
            Toast.makeText(this, "Уравнение имеет два корня: x1 = $x1, x2 = $x2", Toast.LENGTH_SHORT).show()
        }
        else if (d == 0.0){
            val x = -b / (2 * a)
            Toast.makeText(this, "Уравнение имеет один корень: x = $x", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Уравнение не имеет корней", Toast.LENGTH_SHORT).show()

        }

    }
}
