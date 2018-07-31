package com.codeclub.shareapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener{
            Log.i("Main Activity", "Button is clicked")
            Toast.makeText(this, "Button is clicked !", Toast.LENGTH_SHORT).show()
        }

        btnMoveToNext.setOnClickListener{
            val msg : String = txtUsrMsg.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", msg);
            startActivity(intent)
        }

        btnShareTo.setOnClickListener{
            val intent = Intent();
            intent.action = Intent.ACTION_SEND
            val msg : String = txtUsrMsg.text.toString()
            intent.putExtra(Intent.EXTRA_TEXT, msg);
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to:"))
        }
    }
}
