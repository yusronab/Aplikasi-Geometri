package com.example.solvegeometry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.solvegeometry.databinding.ActivityRectangleBinding

class RectangleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRectangleBinding
    var panjang: Double? = null
    var lebar: Double? = null
    var tinggi: Double? = null
    var area: Int? = null
    var volume: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRectangleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnArea()
        btnVolume()
        btnBack()
        btnRefresh()
    }

    private fun btnArea(){
        binding.btnArea.setOnClickListener {
            if (binding.etPanjang.text.toString().trim().isEmpty() || binding.etLebar.text.toString().trim().isEmpty() || binding.etTinggi.text.toString().trim().isEmpty()){
                Toast.makeText(applicationContext, "Properties cannot empty", Toast.LENGTH_SHORT).show()
            }
            else{
                panjang = binding.etPanjang.text.toString().toDouble()
                lebar = binding.etLebar.text.toString().toDouble()
                tinggi = binding.etTinggi.text.toString().toDouble()
                area = (2 * ((panjang!!*lebar!!) + (panjang!!*tinggi!!) + (tinggi!!*lebar!!))).toInt()
                binding.tvArea.setText(area.toString())
            }
        }
    }

    private fun btnVolume(){
        binding.btnVolume.setOnClickListener {
            if (binding.etPanjang.text.toString().trim().isEmpty() || binding.etLebar.text.toString().trim().isEmpty() || binding.etTinggi.text.toString().trim().isEmpty()){
                Toast.makeText(applicationContext, "Properties cannot empty", Toast.LENGTH_SHORT).show()
            }
            else{
                panjang = binding.etPanjang.text.toString().toDouble()
                lebar = binding.etLebar.text.toString().toDouble()
                tinggi = binding.etTinggi.text.toString().toDouble()
                volume = (panjang!! * lebar!! * tinggi!!).toInt()
                binding.tvVolume.setText(volume.toString())
            }
        }
    }

    private fun btnBack(){
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun btnRefresh(){
        binding.btnRefresh.setOnClickListener {
            if (binding.etPanjang.text.toString().trim().isEmpty() || binding.etLebar.text.toString().trim().isEmpty() || binding.etTinggi.text.toString().trim().isEmpty()){
                Toast.makeText(applicationContext, "Already empty", Toast.LENGTH_SHORT).show()
            }
            else{
                binding.etPanjang.setText("")
                binding.etLebar.setText("")
                binding.etTinggi.setText("")
                binding.tvArea.setText("")
                binding.tvVolume.setText("")
            }
        }
    }
}