package com.bangkit.caraka.ui.camera

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.bangkit.caraka.databinding.ActivityCameraBinding
import com.bangkit.caraka.utill.showToast

class CameraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Deteksi Aksara"

        binding.btnMulaiDeteksi.setOnClickListener{
            if(isCameraPermissionGranted()){
                val intent = Intent(this, ScannerActivity::class.java)
                startActivity(intent)
            } else {
                requestCameraPermissionLauncher.launch(CAMERA_PERMISSION)
            }
        }
    }


    private fun allPermissionsGranted() =
        ContextCompat.checkSelfPermission(this, CAMERA_PERMISSION,) == PackageManager.PERMISSION_GRANTED

    private val requestCameraPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                showToast(this, "Izin Diberikan")
            } else {
                showToast(this, "Berikan Izin Terlebih Dahulu")
            }
        }

    private fun isCameraPermissionGranted(): Boolean = allPermissionsGranted()


    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return true
    }

    companion object {
        private const val CAMERA_PERMISSION = Manifest.permission.CAMERA
    }
}