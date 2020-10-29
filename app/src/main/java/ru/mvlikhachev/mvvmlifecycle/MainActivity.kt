package ru.mvlikhachev.mvvmlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Transformation
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val liveDataString = MutableLiveData<String>()
    val liveDataString2 = MutableLiveData<String>()
    val mediatorLiveData = MediatorLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text1TextView : TextView = findViewById(R.id.text1TextView)
        val text2TextView : TextView = findViewById(R.id.text2TextView)
        val saveButton1 : Button = findViewById(R.id.saveButton1)
        val saveButton2 : Button = findViewById(R.id.saveButton2)
        val dataEditText : EditText = findViewById(R.id.dataEditText)

        liveDataString.value = "String"
        liveDataString2.value = "String2"

        mediatorLiveData.addSource(liveDataString,{
            text1TextView.text = it
        })

        mediatorLiveData.addSource(liveDataString2, {
            text2TextView.text = it
        })

        mediatorLiveData.observe(this, Observer {

        })

        saveButton1.setOnClickListener {
            liveDataString.value = dataEditText.text.toString()
        }
        saveButton2.setOnClickListener {
            liveDataString2.value = dataEditText.text.toString()
        }

    }


}