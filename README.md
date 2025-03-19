dora-pgyer-support
![Release](https://jitpack.io/v/dora4/dora-pgyer-support.svg)
--------------------------------

#### 依赖仓库配置

```kts
dependencyResolutionManagement {
    repositories {
        // 蒲公英的仓库
        maven { setUrl("https://frontjs-static.pgyer.com/dist/sdk/pgyersdk") }
    }
}
```

#### Gradle依赖配置

```groovy
// 添加以下代码到项目根目录下的build.gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
// 添加以下代码到app模块的build.gradle
dependencies {
     // 扩展包必须在有主框架dora的情况下使用
    implementation 'com.github.dora4:dora:1.3.3'
    implementation 'com.github.dora4:dora-pgyer-support:1.8'
    // 1.7版本开始需要依赖dcache-android
    implementation 'com.github.dora4:dcache-android:2.3.1'
    // 1.7版本开始需要依赖dview-loading-dialog
    implementation 'com.github.dora4:dview-loading-dialog:1.5'
}
```

#### 使用方式

在AndroidManifest中加入配置。
```xml
<application>
        <!-- Dora生命周期注入的配置 -->
        <meta-data
            android:name="dora.lifecycle.config.PgyerGlobalConfig"
            android:value="GlobalConfig"/>
            
        <!-- 蒲公英的SDK的配置 -->
        <meta-data
            android:name="PGYER_API_KEY"
            android:value="改成你的蒲公英的API Key" />
        <meta-data
            android:name="PGYER_FRONTJS_KEY"
            android:value="改成你的蒲公英的SDK Token" />
        <meta-data
            android:name="PGYER_FEATURE_CHECK_UPDATE"
            android:value="true" />
</application>
```

检测版本更新（1.7版本新增）。
```kotlin
    // 检测蒲公英的版本更新，apiKey对应PGYER_API_KEY，appKey对应PGYER_FRONTJS_KEY
    PgyVersionUpdate.checkVersion(context, apiKey, appKey, object : PgyVersionUpdate.UpdateListener {
        override fun onUpdate(
            versionCode: Int,
            versionName: String,
            isForceUpdate: Boolean,
            updateLog: String,
            downloadUrl: String) {
        }

