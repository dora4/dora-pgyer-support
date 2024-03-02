package dora.pgyer

import android.content.Context
import dora.http.DoraCallback
import dora.http.retrofit.RetrofitManager
import dora.util.ApkUtils
import dora.widget.DoraLoadingDialog

object PgyVersionUpdate {

    interface UpdateListener {
        fun onUpdate(versionCode: Int, versionName: String, isForceUpdate: Boolean, updateLog: String, downloadUrl: String)
        fun onLatestVersion()
        fun onError(msg: String)
    }

    fun checkVersion(context: Context, apiKey: String, appKey: String, listener: UpdateListener) {
        val dialog = DoraLoadingDialog(context)
            .show(context.getString(dora.widget.loadingdialog.R.string.loading)) {
                setCancelable(false)
                messageTextSize(15f)
            }
        RetrofitManager.getService(PgyService::class.java).checkVersion(apiKey, appKey)
            .enqueue(object : DoraCallback<PgyApiResult<VersionResponse>>() {
                override fun onSuccess(model: PgyApiResult<VersionResponse>) {
                    dialog.dismissWithAnimation()
                    val response = model.data ?: return
                    if ((response.buildVersionNo?.toInt() ?: 0) > ApkUtils.getVersionCode(context)) {
                        listener.onUpdate(response.buildVersionNo?.toInt() ?: -1,
                            response.buildVersion ?: "",
                            response.isNeedForceUpdate,
                            response.buildUpdateDescription ?: "",
                            response.downloadURL ?: "")
                    } else {
                        listener.onLatestVersion()
                    }
                }

                override fun onFailure(msg: String) {
                    listener.onError(msg)
                    dialog.dismissWithAnimation()
                }
            })
    }
}