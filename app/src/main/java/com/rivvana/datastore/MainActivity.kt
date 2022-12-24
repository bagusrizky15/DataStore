package com.rivvana.datastore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow
import java.util.prefs.Preferences
import androidx.datastore.preferences.core.Preferences as Preferences1

class MainActivity : AppCompatActivity() {
    // At the top level of your kotlin file:
    val Context.dataStore: DataStore<Preferences1> by preferencesDataStore(name = "counter")
    private val COUNTER_KEY = intPreferencesKey("counter_key")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        suspend fun incrementCounter(context: Context){
            context.dataStore.edit { preferences ->
                val currentCounterValue = preferences[COUNTER_KEY] ?:0
                preferences[COUNTER_KEY] = currentCounterValue + 1
            }
        }

        suspend fun getPreferences(context: Context): kotlinx.coroutines.flow.Flow<androidx.datastore.preferences.core.Preferences>{
            return context.dataStore.data
        }

        suspend fun getCounter(context: Context): kotlinx.coroutines.flow.Flow<Int>{
            return context.dataStore.data.map { preferences ->
                preferences[COUNTER_KEY] ?:0
            }
        }

        suspend fun getPreferences(context: Context): Flow<Preferences>{

        }
    }
}