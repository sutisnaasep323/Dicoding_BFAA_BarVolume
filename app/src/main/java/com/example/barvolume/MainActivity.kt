package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtLength : EditText
    private lateinit var edtWeight : EditText
    private lateinit var edtHeight : EditText
    private lateinit var calculate : Button
    private lateinit var result : TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtLength = findViewById(R.id.ET_panjang)
        edtWeight = findViewById(R.id.ET_lebar)
        edtHeight = findViewById(R.id.ET_tinggi)
        calculate = findViewById(R.id.btn_hitung)
        result = findViewById(R.id.hasil)

        calculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val resultt = savedInstanceState.getString(STATE_RESULT)
            result.text = resultt
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, result.text.toString())
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.btn_hitung){
            val inputLength = edtLength.text.toString().trim()
            val inputWeight = edtWeight.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyFields = false

            if (inputLength.isEmpty()){
                isEmptyFields = true
                edtLength.error = "Panjang tidak boleh kosong"
            }
            if (inputWeight.isEmpty()){
                isEmptyFields = true
                edtWeight.error = "Lebar tidak boleh kosong"
            }
            if (inputHeight.isEmpty()){
                isEmptyFields = true
                edtHeight.error = "Tinggi tidak boleh kosong"
            }

            if (!isEmptyFields){
                val volume = inputLength.toDouble() * inputHeight.toDouble() * inputWeight.toDouble()
                result.text = volume.toString()
            }

        }
    }
}