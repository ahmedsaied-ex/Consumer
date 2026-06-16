import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties
import kotlin.apply

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}
val localProperties =
    Properties().apply {
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            localPropertiesFile.inputStream().use { load(it) }
        }
    }

kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.activity.compose)

            implementation(libs.ktor.android)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)



            // lottie
//            implementation("io.github.alexzhirkevich:compottie:2.0.0")
            implementation(libs.compottie.resources)
            implementation(libs.compottie.network)
            implementation(libs.compottie.dot)
            implementation(libs.compottie.lite)

            implementation(libs.bignum)


            implementation(libs.kotlinx.serialization.json)

            implementation(libs.bundles.ktor)
            implementation(libs.bundles.ktor)
            implementation(libs.coil.network.ktor)
            implementation(libs.coil.compose.core)
            implementation(libs.coil.compose)
            implementation(libs.coil.core)
            implementation(libs.coil.svg)
            implementation(libs.kermit)

            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.compose.navigation)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        iosMain.dependencies {
            implementation(libs.ktor.ios)
        }

    }
}
android {
    namespace = "com.example.consumer"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.example.consumer"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    // Build variants for different environments
    flavorDimensions += "environment"
    productFlavors {
        create("dev") {
            dimension = "environment"
            applicationIdSuffix = ""

            val devApiKey =
                localProperties.getProperty("DEV_API_KEY")
                    ?: System.getenv("DEV_API_KEY")
                    ?: ""
            val devApiUrl =
                localProperties.getProperty("DEV_API_BASE_URL")
                    ?: System.getenv("DEV_API_BASE_URL")
                    ?: "https://dev.example.com/api/"

            buildConfigField("String", "ENVIRONMENT", "\"development\"")
            buildConfigField("String", "API_KEY", "\"$devApiKey\"")
            buildConfigField("String", "API_BASE_URL", "\"$devApiUrl\"")
            buildConfigField("boolean", "IS_DEBUG", "true")
            buildConfigField("boolean", "ENABLE_ANALYTICS", "false")
            buildConfigField("boolean", "ENABLE_CRASH_REPORTING", "false")
        }

        create("staging") {
            dimension = "environment"
            applicationIdSuffix = ".staging"
            versionNameSuffix = "-staging"

            val stagingApiKey =
                localProperties.getProperty("STAGING_API_KEY")
                    ?: System.getenv("STAGING_API_KEY")
                    ?: ""
            val stagingApiUrl =
                localProperties.getProperty("STAGING_API_BASE_URL")
                    ?: System.getenv("STAGING_API_BASE_URL")
                    ?: "https://staging.example.com/api/"

            buildConfigField("String", "ENVIRONMENT", "\"staging\"")
            buildConfigField("String", "API_KEY", "\"$stagingApiKey\"")
            buildConfigField("String", "API_BASE_URL", "\"$stagingApiUrl\"")
            buildConfigField("boolean", "IS_DEBUG", "false")
            buildConfigField("boolean", "ENABLE_ANALYTICS", "true")
            buildConfigField("boolean", "ENABLE_CRASH_REPORTING", "true")
        }

        create("prod") {
            dimension = "environment"

            val prodApiKey =
                localProperties.getProperty("PROD_API_KEY")
                    ?: System.getenv("PROD_API_KEY")
                    ?: ""
            val prodApiUrl =
                localProperties.getProperty("PROD_API_BASE_URL")
                    ?: System.getenv("PROD_API_BASE_URL")
                    ?: "https://api.example.com/api/"

            buildConfigField("String", "ENVIRONMENT", "\"production\"")
            buildConfigField("String", "API_KEY", "\"$prodApiKey\"")
            buildConfigField("String", "API_BASE_URL", "\"$prodApiUrl\"")
            buildConfigField("boolean", "IS_DEBUG", "false")
            buildConfigField("boolean", "ENABLE_ANALYTICS", "true")
            buildConfigField("boolean", "ENABLE_CRASH_REPORTING", "true")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        getByName("debug") {
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(libs.compose.uiTooling)
}