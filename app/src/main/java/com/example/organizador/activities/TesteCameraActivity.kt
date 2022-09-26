package com.example.organizador.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.organizador.databinding.ActivityTesteCameraBinding

class TesteCameraActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityTesteCameraBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.cameraButton.setOnClickListener {

            startActivity(Intent(Intent.ACTION_PICK).setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI))
//                .apply {
//                this.type = "image/*"
//                startActivity(this)
        }

    }
    on
}




