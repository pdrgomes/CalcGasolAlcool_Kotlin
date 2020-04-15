package com.example.calculatorgasalcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.roundToLong
import kotlin.math.round


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var etGas = findViewById<View>(R.id.etGas) as EditText
        var etAlc = findViewById<View>(R.id.etAlc) as EditText

        var btnCalcular = findViewById<View>(R.id.etButtom) as Button

        btnCalcular.setOnClickListener(View.OnClickListener {
            var resultadoInicial =   etAlc.text.toString().toDouble() / etGas.text.toString().toDouble()
            var valorDecimal = BigDecimal(resultadoInicial).setScale(2, RoundingMode.HALF_EVEN)
            var resultadoFinal = valorDecimal * BigDecimal(100)

            if (resultadoInicial < 0.7){
                Toast.makeText(this, "Melhor abastecer com ETANOL, "+resultadoFinal+"% é o valor do alcool em relação á gasolina.", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Melhor abastecer com GASOLINA, "+resultadoFinal+"% é o valor da gasolina em relação ao alcool.", Toast.LENGTH_LONG).show()
            }
        })




    }
}
