package com.leahnjambi.morningintents

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    lateinit var btnCall :Button
    lateinit var btnSms :Button
    lateinit var btnEml :Button
    lateinit var btnShare :Button
    lateinit var btnMpesa :Button
    lateinit var btnWeb :Button
    lateinit var btnCam :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCall = findViewById(R.id.btnCall)
        btnEml = findViewById(R.id.btnEml)
        btnSms = findViewById(R.id.btnSms)
        btnCam = findViewById(R.id.btnCam)
        btnMpesa = findViewById(R.id.btnMpesa)
        btnWeb = findViewById(R.id.btnWeb)
        btnShare = findViewById(R.id.btnShare)

        // Set onClick listeners to all Buttons
        btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0795549871"))
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        btnEml.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "njambileah07@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Leah,following the recent....")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
        btnSms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0795549871")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello there")
            startActivity(intent)

        }
        btnCam.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)

        }
        btnMpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }

        }
        btnWeb.setOnClickListener {
            var tembea = Intent(this@MainActivity,WebActivity::class.java)
            startActivity(tembea)

        }
        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app from https://www")
            startActivity(shareIntent)

        }
    }
}