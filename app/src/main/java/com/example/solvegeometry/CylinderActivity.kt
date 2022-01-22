package com.example.solvegeometry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.solvegeometry.databinding.ActivityCylinderBinding

class CylinderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCylinderBinding
    var tinggi: Double? = null
    var radius: Double? = null
    var area: Int? = null
    var volume: Int? = null
    private val phi: Double = 3.14

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCylinderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnArea()
        btnVolume()
        btnBack()
        btnRefresh()
    }

    private fun btnArea(){
        binding.btnArea.setOnClickListener {
            if (binding.etRadius.text.toString().trim().isEmpty() || binding.etTinggi.text.toString().trim().isEmpty()){
                Toast.makeText(applicationContext, "Properties cannot empty", Toast.LENGTH_SHORT).show()
            }
            else{
                radius = binding.etRadius.text.toString().toDouble()
                tinggi = binding.etTinggi.text.toString().toDouble()
                area = (((2 * phi * radius!!) * tinggi!!) + (2 * phi * radius!! * radius!!)).toInt()
                binding.tvArea.setText(area.toString())
            }
        }
    }

    private fun btnVolume(){
        binding.btnVolume.setOnClickListener {
            if (binding.etRadius.text.toString().trim().isEmpty() || binding.etTinggi.text.toString().trim().isEmpty()){
                Toast.makeText(applicationContext, "Properties cannot empty", Toast.LENGTH_SHORT).show()
            }
            else{
                radius = binding.etRadius.text.toString().toDouble()
                tinggi = binding.etTinggi.text.toString().toDouble()
                volume = ((phi * radius!! * radius!! * tinggi!!)).toInt()
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
            if (binding.etRadius.text.toString().trim().isEmpty() || binding.etTinggi.text.toString().trim().isEmpty()){
                Toast.makeText(applicationContext, "Already empty", Toast.LENGTH_SHORT).show()
            }
            else{
                binding.etRadius.setText("")
                binding.etTinggi.setText("")
                binding.tvArea.setText("")
                binding.tvVolume.setText("")
            }
        }
    }
}