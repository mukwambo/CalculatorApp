package com.mastercode.calculatorapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.HorizontalScrollView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.mastercode.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var horizontalScrollView: HorizontalScrollView
    private lateinit var displayTextView: TextView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.clickListener = ClickListener(this, binding.displayTextView)

        // Change the status bar color to match that of our App
        changeStatusBarColor(resources.getColor(R.color.backGroundBlack))

        // Initialize the views from the XML file
        horizontalScrollView = binding.horizontalScrollView
        displayTextView = binding.displayTextView

        // Enable the autoscroll feature when the input text exceeds the display width
        displayTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed in this case
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                // Scroll the HorizontalScrollView to the left
                horizontalScrollView.post {
                    horizontalScrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
                }
            }

            override fun afterTextChanged(editable: Editable?) {
                // Not needed in this case
            }
        })

    }
    // This method changes the status bar color
    private fun changeStatusBarColor(color: Int) {
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = color
    }

}