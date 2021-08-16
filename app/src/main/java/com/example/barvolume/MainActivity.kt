package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.barvolume.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /* KODE DI HAPUS INGIN DI REFACTOR DENGAN VIEW BINDING
    private lateinit var edtLength : EditText
    private lateinit var edtWeight : EditText
    private lateinit var edtHeight : EditText
    private lateinit var calculate : Button
    private lateinit var result : TextView
     */

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* KODE DI HAPUS INGIN DI REFACTOR DENGAN VIEW BINDING
        edtLength = findViewById(R.id.ET_panjang)
        edtWeight = findViewById(R.id.ET_lebar)
        edtHeight = findViewById(R.id.ET_tinggi)
        calculate = findViewById(R.id.btn_hitung)
        result = findViewById(R.id.hasil)
         */

        //calculate.setOnClickListener(this) // refactor menjadi
        binding.btnHitung.setOnClickListener(this)

        if (savedInstanceState != null) {
            val resultt = savedInstanceState.getString(STATE_RESULT)
            // result.text = resultt // refactor
            binding.hasil.text = resultt
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.hasil.text.toString())
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.btn_hitung) {
            // refactor
//            val inputLength = edtLength.text.toString().trim()
//            val inputWeight = edtWeight.text.toString().trim()
//            val inputHeight = edtHeight.text.toString().trim()
            val inputLength = binding.ETPanjang.text.toString().trim()
            val inputWeight = binding.ETLebar.text.toString().trim()
            val inputHeight = binding.ETTinggi.text.toString().trim()

            var isEmptyFields = false

            if (inputLength.isEmpty()) {
                isEmptyFields = true
//                    edtLength.error = "Panjang tidak boleh kosong"
                binding.ETPanjang.error = "Panjang tidak boleh kosong"
            }
            if (inputWeight.isEmpty()) {
                isEmptyFields = true
//                    edtWeight.error = "Lebar tidak boleh kosong"
                binding.ETLebar.error = "Lebar tidak boleh kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                binding.ETTinggi.error = "Tinggi tidak boleh kosong"
            }
            if (!isEmptyFields) {
                val volume =
                    inputLength.toDouble() * inputHeight.toDouble() * inputWeight.toDouble()
                binding.hasil.text = volume.toString()
            }
        }
    }
}