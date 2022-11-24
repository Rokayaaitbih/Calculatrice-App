package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.appcalcul.R
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        effacer.setOnClickListener {
            entrer.text = ""
            afficher.text = ""
        }

        parenthese_gauche.setOnClickListener {
            entrer.text = addToInput("(")
        }
        parenthese_droite.setOnClickListener {
            entrer.text = addToInput(")")
        }
        bouton_0.setOnClickListener {
            entrer.text = addToInput("0")
        }
        bouton_1.setOnClickListener {
            entrer.text = addToInput("1")
        }
        bouton_2.setOnClickListener {
            entrer.text = addToInput("2")
        }
        bouton_3.setOnClickListener {
            entrer.text = addToInput("3")
        }
        bouton_4.setOnClickListener {
            entrer.text = addToInput("4")
        }
        bouton_5.setOnClickListener {
            entrer.text = addToInput("5")
        }
        bouton_6.setOnClickListener {
            entrer.text = addToInput("6")
        }
        bouton_7.setOnClickListener {
            entrer.text = addToInput("7")
        }
        bouton_8.setOnClickListener {
            entrer.text = addToInput("8")
        }
        bouton_9.setOnClickListener {
            entrer.text = addToInput("9")
        }
        point.setOnClickListener {
            entrer.text = addToInput(".")
        }
        division.setOnClickListener {
            entrer.text = addToInput("÷")
        }
        multiplier.setOnClickListener {
            entrer.text = addToInput("×")
        }
        soustraction.setOnClickListener {
            entrer.text = addToInput("-")
        }
        addition.setOnClickListener {
            entrer.text = addToInput("+")
        }
        egale.setOnClickListener {
            Result()
        }
    }


    private fun getInputExpression(): String {
        var expression = entrer.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }
    private fun addToInput(buttonValue: String): String {
        return "${entrer.text}$buttonValue"
    }


    private fun Result() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {

                afficher.text = "Erreur"
                afficher.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {

                afficher.text = DecimalFormat("0.######").format(result).toString()
                afficher.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {

            afficher.text = "Erreur"
            afficher.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }}
