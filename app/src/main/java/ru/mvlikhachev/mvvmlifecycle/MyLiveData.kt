package ru.mvlikhachev.mvvmlifecycle

import androidx.lifecycle.LiveData

class MyLiveData: LiveData<String>() {

    fun setValueToLiveData(string: String) {
        value = string
    }

    override fun onActive() {
        super.onActive()

        println("onActive")
        println("Подключились к БД")
    }

    override fun onInactive() {
        super.onInactive()

        println("onInactive")
        println("Отключились от БД")
    }
}