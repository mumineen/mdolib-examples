package com.example.mdokotlinexample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.mumineen.MdoSalaat
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.*
import java.util.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById(R.id.helloView) as TextView

        val year = LocalDate.now().year
        val month = LocalDate.now().monthValue
        val day = LocalDate.now().dayOfMonth


        val lat = 19.0760
        val lon = 72.8777

        val sdf = SimpleDateFormat("hh:mm a")

        val times = MdoSalaat.getAllTimesRounded(year, month, day, lat, lon, 0.0)

        val netDate = Date(times[6] * 1000) //Date() expects milliseconds
        val date = sdf.format(netDate)

        textView.text = "Maghrib in Mumbai is \n" + date
    }
}