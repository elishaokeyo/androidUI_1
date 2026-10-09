package com.example.isaac

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity(), View.OnClickListener {
    //An int property to hold a value
    private var value = 0
    private lateinit var txtValue: TextView
    private lateinit var btnHide: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtValue = findViewById<TextView>(R.id.txtValue)
        txtValue.setOnClickListener(this)
        val btnAdd   = findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener(this)
        val btnTake   = findViewById<Button>(R.id.btnTake)
        btnTake.setOnClickListener(this)
        val btnGrow   = findViewById<Button>(R.id.btnGrow)
        btnGrow.setOnClickListener(this)
        val btnShrink   = findViewById<Button>(R.id.btnShrink)
        btnShrink.setOnClickListener(this)
        val btnReset   = findViewById<Button>(R.id.btnReset)
        btnReset.setOnClickListener(this)
        btnHide   = findViewById<Button>(R.id.btnHide)
        btnHide.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        // A local variable to use later
        val size: Float
        when (v.id){
            R.id.btnAdd ->{
                value++
                txtValue.text ="$value"
            }
            R.id.btnTake ->{
                value--
                txtValue.text ="$value"
            }
            R.id.btnReset ->{
                value =0
                txtValue.text ="$value"
            }
            R.id.btnGrow ->{
                size = txtValue.textScaleX
                txtValue.scaleX = size +1
            }
            R.id.btnShrink -> {
                size = txtValue.textScaleX
                txtValue.scaleX = size -1
            }
            R.id.btnHide ->
                if (txtValue.visibility == View.VISIBLE){
                    //Current visible so hide it
                    txtValue.visibility = View.INVISIBLE
                    //Change text on the button
                    btnHide.text = "SHOW"
                }else{
                    //Currently hidden so show it
                    txtValue.visibility = View.VISIBLE
                    //Change text on the button
                    btnHide.text = "HIDE"
                }

        }
    }
}