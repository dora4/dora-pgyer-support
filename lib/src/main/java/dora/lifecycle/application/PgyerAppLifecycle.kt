package dora.lifecycle.application

import android.app.Application
import android.content.Context
import com.pgyer.pgyersdk.PgyerSDKManager

class PgyerAppLifecycle : ApplicationLifecycleCallbacks {

    override fun attachBaseContext(base: Context) {
        PgyerSDKManager.Init().setContext(base).start()
    }

    override fun onCreate(application: Application) {
    }

    override fun onTerminate(application: Application) {
    }
}