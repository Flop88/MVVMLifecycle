package ru.mvlikhachev.mvvmlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val myLiveData = MyLiveData()

    private var liveDataString = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testText : TextView = findViewById(R.id.testTextView)
        val saveButton : Button = findViewById(R.id.saveButton)
        val dataEditText : EditText = findViewById(R.id.dataEditText)

        myLiveData.observe(this, Observer {
            testText.text = it
        })



        saveButton.setOnClickListener {
            myLiveData.setValueToLiveData(dataEditText.text.toString())
        }
    }



}