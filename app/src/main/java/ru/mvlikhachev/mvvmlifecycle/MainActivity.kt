package ru.mvlikhachev.mvvmlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Transformation
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    var ldString = MutableLiveData<String>()
    var ldInt = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stringTextView : TextView = findViewById(R.id.stringTextView)
        val intTextView : TextView = findViewById(R.id.intTextView)
        val saveButton : Button = findViewById(R.id.saveButton)
        val dataEditText : EditText = findViewById(R.id.dataEditText)

        ldString.value = "ldString"
        ldInt.value = 1

        stringTextView.text = ldString.value + " String"
        intTextView.text = ldInt.value.toString() + " Int"

        saveButton.setOnClickListener {
            ldString = Transformations.map(ldInt) {
                it.toString()
            } as MutableLiveData<String>

            ldString.observe(this, Observer {
                stringTextView.text = it
            })
        }




    }


}