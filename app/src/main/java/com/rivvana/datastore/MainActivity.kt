package com.rivvana.datastore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow

class MainActivity : AppCompatActivity() {
    // At the top level of your kotlin file:
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "counter")
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

        suspend fun getPreferencs(context: Context): Flow<Preferences>{
            return context.dataStore.data
        }

        suspend fun getCounter(context: Context): Flow<Int> {
            return context.dataStore.data.map { preferences ->
                preferences[COUNTER_KEY]
            }
        }
    }
}