import co.kr.cobosys.baroder.buildsrc.Depends

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    compileSdk = Depends.Versions.androidCompileSdkVersion

    defaultConfig {
        minSdk = Depends.Versions.minSdkVersion
        targetSdk = Depends.Versions.targetSdkVersion
        testInstrumentationRunner =
            Depends.Versions.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
        freeCompilerArgs = freeCompilerArgs + listOf("-XXLanguage:+InlineClasses")
    }
    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
    }
    buildTypes {
        named("debug") { }
        named("release") {
            isMinifyEnabled = true
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
}
dependencies {
    implementation(Depends.Libraries.kotlin)
    //android
    implementation(Depends.Libraries.paging_runtime_ktx)
    implementation(Depends.Libraries.lifecycle_livedata)
    implementation(Depends.Libraries.multidex)
    //reactive
    implementation(Depends.Libraries.coroutines)
    //dependency injection
    implementation(Depends.Libraries.java_inject)
    //test
    testImplementation(Depends.Libraries.junit)
    testImplementation(Depends.Libraries.mockito_core)
    testImplementation(Depends.Libraries.mockito_inline)
    testImplementation(Depends.Libraries.mockito_kotlin)
}