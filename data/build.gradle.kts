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
        multiDexEnabled = true
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
    }
    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
    }
    buildTypes {
        named("debug") {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"" + Depends.Environments.debugUrl + "\""
            )
        }
        named("release") {
            isMinifyEnabled = true
            buildConfigField(
                "String",
                "BASE_URL",
                "\"" + Depends.Environments.releaseUrl + "\""
            )
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
    implementation(Depends.Libraries.android_core_ktx)
    implementation(Depends.Libraries.paging_runtime_ktx)
    implementation(Depends.Libraries.multidex)
    //dependency injection
    implementation(Depends.Libraries.java_inject)
    implementation(Depends.Libraries.hilt_android)
    kapt(Depends.Libraries.hilt_android_compiler)
    kapt(Depends.Libraries.hilt_compiler)
    //parser
    api(Depends.Libraries.converter_gson)
    //network
    implementation(Depends.Libraries.retrofit)
    implementation(Depends.Libraries.logging_interceptor)
    //localDB
    implementation(Depends.Libraries.dataStore_preferences)
    implementation(Depends.Libraries.room)
    //other
    implementation(Depends.Libraries.timber)
    implementation(Depends.Libraries.material)
    //test
    testImplementation(Depends.Libraries.junit)
    testImplementation(Depends.Libraries.mockito_core)
    debugImplementation(Depends.Libraries.chucker)
    releaseImplementation(Depends.Libraries.chucker_no_op)
    testImplementation(Depends.Libraries.mockito_inline)
    testImplementation(Depends.Libraries.mockito_kotlin)

    testImplementation(project(path = ":domain", configuration = "unitTestImplementation"))
    implementation(project(":domain"))
}