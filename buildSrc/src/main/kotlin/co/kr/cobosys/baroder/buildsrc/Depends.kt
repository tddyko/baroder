package co.kr.cobosys.baroder.buildsrc

import co.kr.cobosys.baroder.buildsrc.Depends.Versions.appVersionCode

object Depends {

    object Versions {
        // 그레들 세팅
        const val appVersionCode = 1_000_000
        const val gradleVersion = "7.0.4"
        // 안드로이드 버전 세팅
        const val androidCompileSdkVersion = 32
        const val targetSdkVersion = 32
        const val minSdkVersion = 21
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // 코틀린 세팅
        const val kotlinVersion = "1.6.10"
        // reactive 세팅
        const val coroutinesVersion = "1.5.2"
        // 네트워크 세팅
        const val retrofit2Version = "2.9.0"
        const val okhttpLoggingVersion = "5.0.0-alpha.2"
        const val chuckerVersion = "3.5.2"
        const val gsonVersion = "2.9.0"
        const val coroutineAdapterVersion = "0.9.2"
        // 제트팩 세팅
        const val lifecycleVersion = "2.4.0"
        const val coordinatorLayoutVersion = "1.1.0"
        const val constraintLayoutVersion = "2.1.3"
        const val flexboxLayoutVersion = "3.0.0"
        const val supportVersion = "1.4.1"
        const val materialVersion = "1.6.0-alpha02"
        const val coreKtxVersion = "1.7.0"
        const val navigationVersion = "2.4.0-beta02"
        const val pagingVersion = "3.1.0-rc01"
        const val multidexVersion = "2.0.1"
        const val fragmentExtVersion = "1.3.3"
        const val recyclerviewVersion = "1.2.1"
        const val viewpagerVersion = "1.0.0"
        const val roomVersion = "2.4.2"
        const val cryptoVersion = "1.0.0"
        const val workManagerVersion = "2.7.1"
        const val splashScreenVersion = "1.0.0-beta01"
        // DI 세팅
        const val hiltVersion = "2.40.1"
        const val hiltCompilerVersion = "1.0.0"
        const val hiltNavigationComposeVersion = "1.0.0-alpha03"
        const val javaxInjectVersion = "1"
        // 테스트 세팅
        const val mockitoKotlinVersion = "2.2.0"
        const val mockitoCoreVersion = "4.0.0"
        const val mockitoInlineVersion = "4.0.0"
        const val espressoVersion = "3.4.0"
        const val junitVersion = "4.13.2"
        const val supportTestVersion = "1.4.0"
        const val testCoreVersion = "1.4.0"
        const val testExtJunitVersion = "1.1.3"
        const val sonarqubeVersion = "3.3"
        const val detektVersion = "1.18.1"
        const val checkDependencyVersionsVersion = "0.39.0"
        const val leakCanaryVersion = "2.8.1"
        // 외부라이브러리
        const val progress = "1.1.3"
        const val shimmer = "0.5.0"
        const val shimmer_recyclerview = "0.4.0"
        const val timberVersion = "5.0.1"
        const val lottieVersion = "4.2.1"
        const val glideVersion = "4.13.0"
        const val dataStorePreferenceVersion = "1.0.0"
        const val indicatorVersion = "4.2"
        const val zxingVersion = "4.3.0"
        const val zxingCoreVersion = "3.3.0"
    }

    object ClassPaths {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
        const val kotlin_gradle_plugin = "gradle-plugin"
        const val navigation_safe_args_gradle_plugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"

        const val hilt_android_gradle_plugin =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
        const val sonarqube_gradle_plugin =
            "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:${Versions.sonarqubeVersion}"
        const val detekt_gradle_plugin =
            "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.detektVersion}"
    }

    object Libraries {
        // 코틀린 세팅
        const val kotlin =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
        const val kotlin_reflect =
            "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"
        const val multidex = "androidx.multidex:multidex:${Versions.multidexVersion}"
        // 의존성 주입 세팅
        const val hilt_android =
            "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val hilt_android_compiler =
            "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
        const val hilt_compiler =
            "androidx.hilt:hilt-compiler:${Versions.hiltCompilerVersion}"
        // 제트팩 세팅
        const val fragment_ktx =
            "androidx.fragment:fragment-ktx:${Versions.fragmentExtVersion}"
        const val android_core_ktx =
            "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val paging_runtime_ktx =
            "androidx.paging:paging-runtime-ktx:${Versions.pagingVersion}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.supportVersion}"
        const val lifecycle_livedata =
            "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycleVersion}"
        const val coordinatorlayout =
            "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorLayoutVersion}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
        const val flexboxLayout =
            "com.google.android.flexbox:flexbox:${Versions.flexboxLayoutVersion}"
        const val navigation_fragment_ktx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
        const val navigation_ui_ktx =
            "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
        const val lifecycle_livedata_ktx =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
        const val lifecycle_runtime_ktx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
        const val lifecycle_common =
            "androidx.lifecycle:lifecycle-common:${Versions.lifecycleVersion}"
        const val lifecycle_viewmodel_ktx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
        const val recyclerview =
            "androidx.recyclerview:recyclerview:${Versions.recyclerviewVersion}"
        const val viewpager =
            "androidx.viewpager2:viewpager2:${Versions.viewpagerVersion}"
        const val splash =
            "androidx.core:core-splashscreen:${Versions.splashScreenVersion}"
        const val room =
            "androidx.room:room-ktx:${Versions.roomVersion}"
        const val room_compiler =
            "androidx.room:room-compiler:${Versions.roomVersion}"
        const val work_manager =
            "androidx.work:work-runtime-ktx:${Versions.workManagerVersion}"
        const val crypto =
            "androidx.security:security-crypto:${Versions.cryptoVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
        // reactive 세팅
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
        const val java_inject = "javax.inject:javax.inject:${Versions.javaxInjectVersion}"
        // 네트워크 세팅
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}"
        const val logging_interceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingVersion}"
        const val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.gsonVersion}"
        const val coroutine_adapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutineAdapterVersion}"
        // 테스트 세팅
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val test_runner = "androidx.test:runner:${Versions.supportTestVersion}"
        const val test_rules = "androidx.test:rules:${Versions.supportTestVersion}"
        const val test_core = "androidx.test:core:${Versions.testCoreVersion}"
        const val test_ext_junit = "androidx.test.ext:junit:${Versions.testExtJunitVersion}"
        const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val mockito_core = "org.mockito:mockito-core:${Versions.mockitoCoreVersion}"
        const val mockito_inline = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"
        const val mockito_kotlin =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
        const val leak_canary =
            "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanaryVersion}"
        const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chuckerVersion}"
        const val chucker_no_op =
            "com.github.chuckerteam.chucker:library-no-op:${Versions.chuckerVersion}"
        const val dataStore_preferences =
            "androidx.datastore:datastore-preferences:${Versions.dataStorePreferenceVersion}"
        // 외부 라이브러리
        const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
        const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
        const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
        const val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"
        const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
        const val shimmer_recyclerview = "com.todkars:shimmer-recyclerview:${Versions.shimmer_recyclerview}"
        const val indicator = "com.tbuonomo:dotsindicator:${Versions.indicatorVersion}"
        const val progress = "com.github.skydoves:progressview:${Versions.progress}"
        const val zxing = "com.journeyapps:zxing-android-embedded:${Versions.zxingVersion}"
        const val zxingCore = "com.google.zxing:core:${Versions.zxingCoreVersion}"
    }

    object Environments {
        // 개발서버
        const val debugUrl = "https://apidevapp.baroder.co.kr/"
        /*🙄🙄🙄🙄🙄🙄　개발서버도 특별히 건들일 없으니 건드리지 말것. 🙄🙄🙄🙄🙄🙄*/
        // 상용서버
        /*☠️☠️☠️☠️☠️☠️☠️☠️☠️☠️☠️☠️ 건들지 말것 ☠️☠️☠️☠️☠️☠️☠️☠️☠️☠️☠️☠️*/
        const val releaseUrl = "https://apiapp.baroder.co.kr/"
        /*☠️☠️☠️☠️☠️☠️☠️☠️ 상용서버 이므로 절대 건들지 말것. ☠️☠️☠️☠️☠️☠️☠️☠️*/
    }

    fun generateVersionName(): String {
        val patch: Int = appVersionCode.rem(1000)
        val minor: Int = (appVersionCode / 1000).rem(1000)
        val major: Int = (appVersionCode / 1000000).rem(1000)

        return "$major.$minor.$patch"
    }

}