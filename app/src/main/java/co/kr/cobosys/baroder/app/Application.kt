package co.kr.cobosys.baroder.app

import android.os.StrictMode
import androidx.multidex.MultiDexApplication
import co.kr.cobosys.data.datastore.DataStoreManager
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class Application : MultiDexApplication() {

    @Inject
    lateinit var dataStoreManager: DataStoreManager

    override fun onCreate() {

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork() // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    //.penaltyDeath() //TODO
                    .build()
            )
        }
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}