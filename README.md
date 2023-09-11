dora-pgyer-support
![Release](https://jitpack.io/v/dora4/dora-pgyer-support.svg)
--------------------------------

#### gradle依赖配置

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
    implementation 'com.github.dora4:dora:1.1.12'
    implementation 'com.github.dora4:dora-pgyer-support:1.2'
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
            android:name="PGYER_FEATURE_CHECK_UNPDATE"
            android:value="true" />
</application>

