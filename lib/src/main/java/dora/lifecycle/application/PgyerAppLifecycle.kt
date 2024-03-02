package dora.lifecycle.application

import android.app.Application
import android.content.Context
import com.pgyer.pgyersdk.PgyerSDKManager
import dora.http.log.FormatLogInterceptor
import dora.http.retrofit.RetrofitManager
import dora.pgyer.PgyService
import java.util.concurrent.TimeUnit

class PgyerAppLifecycle : ApplicationLifecycleCallbacks {

    override fun attachBaseContext(base: Context) {
        // 应早于开发者自己的RetrofitManager配置初始化，建议在Application的onCreate中初始化自己的RetrofitManager
        RetrofitManager.initConfig {
            okhttp {
                connectTimeout(3, TimeUnit.SECONDS)
                readTimeout(10, TimeUnit.SECONDS)
                addNetworkInterceptor(FormatLogInterceptor())
                build()
            }
            mappingBaseUrl(PgyService::class.java, "http://www.pgyer.com/apiv2/")
        }
    }

    override fun onCreate(application: Application) {
        PgyerSDKManager.Init().setContext(application).start()
    }

    override fun onTerminate(application: Application) {
    }
}