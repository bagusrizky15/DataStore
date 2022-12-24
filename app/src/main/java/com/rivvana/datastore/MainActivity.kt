package com.rivvana.datastore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.rivvana.datastore.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow
import java.util.prefs.Preferences
import androidx.datastore.preferences.core.Preferences as Preferences1

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        


    }
}