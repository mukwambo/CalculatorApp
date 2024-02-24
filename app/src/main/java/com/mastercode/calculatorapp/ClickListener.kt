package com.mastercode.calculatorapp

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ClickListener (private val context: Context, private val textView: TextView){

    // Listener for clicks on the calculator buttons

    // Special function buttons
    fun allClearClicked(view:View){
        textView.text = null
    }
    fun changeSignClicked(view:View){
        Toast.makeText(context,"You clicked changeSign", Toast.LENGTH_SHORT).show()
    }
    fun percentageSignClicked(view:View){
        Toast.makeText(context,"You clicked percentageSign", Toast.LENGTH_SHORT).show()
    }

    // The operator buttons
    fun divisionSignClicked(view:View){
        updateDisplayText(view)
    }
    fun multiplicationSignClicked(view:View){
        updateDisplayText(view)
    }
    fun subtractionSignClicked(view:View){
        updateDisplayText(view)
    }
    fun additionSignClicked(view:View){
        updateDisplayText(view)
    }

    // The decimal sign
    fun decimalClicked(view:View){
        updateDisplayText(view)
    }

    // The equal button
    fun equalSignClicked(view:View){
        updateDisplayText(view)
    }

    // Function to update the display text based on the clicked numeric button
    fun updateDisplayText(view: View) {

        if (view is Button) {
            val buttonText = view.text.toString()
            val currentText = textView.text.toString()

            // Concatenates the button and screen texts then sets the screen text to the new text
            (currentText + buttonText).also { textView.text = it }
        }
    }

}