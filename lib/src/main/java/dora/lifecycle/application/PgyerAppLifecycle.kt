package dora.lifecycle.application

import android.app.Application
import android.content.Context
import com.pgyer.pgyersdk.PgyerSDKManager

class PgyerAppLifecycle : ApplicationLifecycleCallbacks {

    override fun attachBaseContext(base: Context) {
    }

    override fun onCreate(application: Application) {
        PgyerSDKManager.Init().setContext(application).start()
    }

    override fun onTerminate(application: Application) {
    }
}