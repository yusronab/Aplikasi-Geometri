package com.example.solvegeometry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.solvegeometry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnCube()
        btnRectangle()
        btnCylinder()
        btnCone()
    }

    private fun btnCube(){
        binding.btnCube.setOnClickListener {
            startActivity(Intent(this, CubeActivity::class.java))
            finish()
        }
    }

    private fun btnRectangle(){
        binding.btnRectangle.setOnClickListener {
            startActivity(Intent(this, RectangleActivity::class.java))
            finish()
        }
    }

    private fun btnCylinder(){
        binding.btnCylinder.setOnClickListener {
            startActivity(Intent(this, CylinderActivity::class.java))
            finish()
        }
    }

    private fun btnCone(){
        binding.btnCone.setOnClickListener {
            startActivity(Intent(this, ConeActivity::class.java))
            finish()
        }
    }
}