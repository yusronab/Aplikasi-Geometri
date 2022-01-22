package com.example.solvegeometry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.solvegeometry.databinding.ActivityCubeBinding

class CubeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCubeBinding
    var side: Double? = null
    var area: Int? = null
    var volume: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCubeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnArea()
        btnVolume()
        btnBack()
        btnRefresh()
    }

    private fun btnArea(){
        binding.btnArea.setOnClickListener {
            if (binding.etSide.text.toString().trim().isEmpty()){
                Toast.makeText(applicationContext, "Side cannot empty", Toast.LENGTH_SHORT).show()
            }
            else {
                side = binding.etSide.text.toString().toDouble()
                area = (6 * side!! * side!!).toInt()
                binding.tvArea.setText(area.toString())
            }
        }
    }

    private fun btnVolume(){
        binding.btnVolume.setOnClickListener {
            if (binding.etSide.text.toString().trim().isEmpty()){
                Toast.makeText(applicationContext, "Cannot empty", Toast.LENGTH_SHORT).show()
            }
            else{
                side = binding.etSide.text.toString().toDouble()
                volume = (side!! * side!! * side!!).toInt()
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
            if (binding.etSide.text.toString().trim().isEmpty()){
                Toast.makeText(applicationContext, "Already empty", Toast.LENGTH_SHORT).show()
            }
            else{
                binding.etSide.setText("")
                binding.tvArea.setText("")
                binding.tvVolume.setText("")
            }
        }
    }
}