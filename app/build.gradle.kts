import co.kr.cobosys.baroder.buildsrc.Depends
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Depends.Versions.androidCompileSdkVersion

    defaultConfig {
        multiDexEnabled = true
        applicationId = "app.web.drjackycv.mvvmtemplate"
        minSdk = Depends.Versions.minSdkVersion
        targetSdk = Depends.Versions.targetSdkVersion
        versionCode = Depends.Versions.appVersionCode
        versionName = Depends.generateVersionName()
        testInstrumentationRunner =
            Depends.Versions.testInstrumentationRunner
        javaCompileOptions.annotationProcessorOptions.arguments += mapOf(
            "room.schemaLocation" to "$projectDir/schemas"
        )
    }
    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
    }
    buildTypes {
        named("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
            signingConfig = signingConfigs.getByName("debug")
        }
        named("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    lintOptions {
        isAbortOnError = false
    }
    packagingOptions {
        resources {
            excludes += setOf(
                "META-INF/rxjava.properties",
                "META-INF/proguard/androidx-annotations.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
    }
    //testOptions.unitTests.returnDefaultValues = true
}

tasks.withType<KotlinCompile> {
    sourceCompatibility = "unused"
    targetCompatibility = "unused"
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
        freeCompilerArgs = freeCompilerArgs + listOf("-XXLanguage:+InlineClasses")
    }
}

dependencies {
    implementation(Depends.Libraries.kotlin)
    implementation(Depends.Libraries.kotlin_reflect)

    //dependency injection
    implementation(Depends.Libraries.hilt_android)
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    kapt(Depends.Libraries.hilt_android_compiler)
    kapt(Depends.Libraries.hilt_compiler)
    implementation(Depends.Libraries.java_inject)
    //other
    implementation(Depends.Libraries.timber)
    //android
    implementation(Depends.Libraries.appcompat)
    implementation(Depends.Libraries.coordinatorlayout)
    implementation(Depends.Libraries.constraintlayout)
    implementation(Depends.Libraries.material)
    implementation(Depends.Libraries.navigation_fragment_ktx)
    implementation(Depends.Libraries.navigation_ui_ktx)
    implementation(Depends.Libraries.paging_runtime_ktx)
    implementation(Depends.Libraries.lifecycle_livedata_ktx)
    implementation(Depends.Libraries.lifecycle_runtime_ktx)
    implementation(Depends.Libraries.lifecycle_common)
    implementation(Depends.Libraries.lifecycle_viewmodel_ktx)
    implementation(Depends.Libraries.multidex)
    implementation(Depends.Libraries.android_core_ktx)
    implementation(Depends.Libraries.fragment_ktx)
    implementation(Depends.Libraries.recyclerview)
    implementation(Depends.Libraries.dataStore_preferences)
    implementation(Depends.Libraries.viewpager)
    //reactive
    implementation(Depends.Libraries.coroutines)
    //ui
    implementation(Depends.Libraries.glide)
    kapt(Depends.Libraries.glide_compiler)
    implementation(Depends.Libraries.lottie)
    implementation(Depends.Libraries.indicator)
    implementation(Depends.Libraries.shimmer)
    implementation(Depends.Libraries.shimmer_recyclerview)
    //network
    implementation(Depends.Libraries.retrofit)
    implementation(Depends.Libraries.logging_interceptor)
    //test
    testImplementation(Depends.Libraries.junit)
    androidTestImplementation(Depends.Libraries.test_runner)
    androidTestImplementation(Depends.Libraries.espresso_core)
    debugImplementation(Depends.Libraries.leak_canary)
    debugImplementation(Depends.Libraries.chucker)
    releaseImplementation(Depends.Libraries.chucker_no_op)

    implementation(project(":data"))
    implementation(project(":domain"))
}