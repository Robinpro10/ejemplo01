package com.example.ejemplo01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1: EditText = findViewById(R.id.txtnum1)
        val num2: EditText = findViewById(R.id.txtnum2)
        val select: RadioGroup = findViewById(R.id.roper)
        val botonCalcular: Button = findViewById(R.id.calcular)
        val result: TextView = findViewById(R.id.lblres)
        val resultF: TextView = findViewById(R.id.lblres2)


        botonCalcular.setOnClickListener {
            val n1 = num1.text.toString().toIntOrNull()
            val n2 = num2.text.toString().toIntOrNull()
            val selectOperationId = select.checkedRadioButtonId

            if (n1 == null || n2 == null) {
                Toast.makeText(this, "Digite los dos números.", Toast.LENGTH_SHORT).show()
            } else {
                val res = when (selectOperationId) {
                    R.id.rsuma -> n1 + n2
                    R.id.rresta -> n1 - n2
                    R.id.rmult -> n1 * n2
                    R.id.rdiv -> {
                        if (n2 != 0) n1 / n2
                        else {
                            Toast.makeText(this, "Error!! No se puede dividir por cero", Toast.LENGTH_SHORT).show()
                            null
                        }
                    }
                    R.id.rfacto ->
                    {
                        factorial(n1);

                    }
                    else -> null

                }
                result.text = res?.toString() ?: "Error en la operación"
            }
        }
    }
    fun factorial(n: Int): Int {
        require(n >= 0) { "El número debe ser mayor o igual a 0" }
        var resultado: Int = 1
        for (i in 1..n) {
            resultado *= i
        }
        return resultado
    }
}
