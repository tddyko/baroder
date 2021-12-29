package co.kr.cobosys.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore("settings")

@Singleton
class DataStoreManager @Inject constructor(@ApplicationContext appContext: Context) {

    private val setDataStoree = appContext.dataStore
    private val secureKey = stringPreferencesKey("secure_key")

    // 키값 가져오기
    val getSecureKey: Flow<String> = setDataStoree.data
        .catch { exception ->
            if(exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { prefs ->
            prefs[secureKey] ?: ""
        }
    // 키값 입력하기
    suspend fun setSecureKey(secureVal: String) {
        setDataStoree.edit { prefs ->
            prefs[secureKey] = secureVal
        }
    }

}