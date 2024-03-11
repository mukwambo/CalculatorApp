package com.mastercode.calculatorapp

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.sql.Array

class ClickListener (private val context: Context, private var textView: TextView){

    // Listener for clicks on the calculator buttons

    // Special function buttons
    fun allClearClicked(view:View){
        textView.text = null
    }
    fun changeSignClicked(view: View) {
        val originalText = textView.text.toString()

        /* We use a StringBuilder to help us modify the string from the display.
         Since Strings are immutable(You cannot directly modify them once declared), you aught to
         use StringBuilders which give the modification functionality on strings.
         */

        val modifiedText = StringBuilder()

        // Loop through the text on the display and replace the "+" with "-" and vice-versa

        for (i in originalText) {
            when (i) {
                '+' -> modifiedText.append('-')
                '-' -> modifiedText.append('+')
                else -> modifiedText.append(i)
            }
        }

        textView.text = modifiedText.toString()
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

            // Concatenate the button and screen texts then set the screen text to the new text
            (currentText + buttonText).also { textView.text = it }
        }
    }

}