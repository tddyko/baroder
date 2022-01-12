plugins {
    id("org.sonarqube") version co.kr.cobosys.baroder.buildsrc.Depends.Versions.sonarqubeVersion
    detekt
    id("com.github.ben-manes.versions") version co.kr.cobosys.baroder.buildsrc.Depends.Versions.checkDependencyVersionsVersion
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(co.kr.cobosys.baroder.buildsrc.Depends.ClassPaths.gradle)
        classpath(
            kotlin(
                co.kr.cobosys.baroder.buildsrc.Depends.ClassPaths.kotlin_gradle_plugin,
                version = co.kr.cobosys.baroder.buildsrc.Depends.Versions.kotlinVersion
            )
        )
        classpath(co.kr.cobosys.baroder.buildsrc.Depends.ClassPaths.navigation_safe_args_gradle_plugin)
        classpath(co.kr.cobosys.baroder.buildsrc.Depends.ClassPaths.hilt_android_gradle_plugin)
        classpath(co.kr.cobosys.baroder.buildsrc.Depends.ClassPaths.sonarqube_gradle_plugin)
    }
}