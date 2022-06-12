package com.example.mvpsimple

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var etPanjang: EditText
    private lateinit var etLebar: EditText
    private lateinit var btnHitungLuas: Button
    private lateinit var btnHitungKeliling: Button
    private lateinit var tvHasil: TextView

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        etPanjang = findViewById(R.id.et_panjang)
        etLebar = findViewById(R.id.et_lebar)
        btnHitungKeliling = findViewById(R.id.btn_hitung_keliling)
        btnHitungLuas = findViewById(R.id.btn_hitung_luas)
        tvHasil = findViewById(R.id.tv_hasil)

        btnHitungLuas.setOnClickListener {
            val panjang = etPanjang.text.toString().toFloat()
            val lebar = etLebar.text.toString().toFloat()
            mainPresenter.hitungLuasPersegiPanjang(panjang, lebar)
        }
        btnHitungKeliling.setOnClickListener {
            val panjang = etPanjang.text.toString().toFloat()
            val lebar = etLebar.text.toString().toFloat()
            mainPresenter.hitungkelilingPersegiPanjang(panjang, lebar)
        }
    }



    fun updateLuas(luas:Float) {
        tvHasil.text = luas.toString()
    }

     fun updateKeliling(keliling: Float) {
        tvHasil.text = keliling.toString()
    }

     fun showError(errorMsg: String) {
        tvHasil.text = errorMsg
    }

}