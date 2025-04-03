plugins {
    alias(libs.plugins.rkmbed)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    linuxX64 {
        binaries.executable {
            entryPoint = "cn.rtast.rob.starter.backend.main"
        }
    }
    linuxArm64 {
        binaries.executable {
            entryPoint = "cn.rtast.rob.starter.backend.main"
        }
    }
    mingwX64 {
        binaries.executable {
            entryPoint = "cn.rtast.rob.starter.backend.main"
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.rkmbed.runtime)
                implementation(libs.kzip)
                implementation(libs.ktor.server.core)
                implementation(libs.ktor.server.cio)
                implementation(libs.ktor.server.cors)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.cio)
                implementation(libs.kotlin.serialization)
                implementation(project(":ronebot-starter:starter-common"))
            }
        }
    }
}

rkmbed {
    packageName = "cn.rtast.rob.starter.backend.resources"
    resourcePath.add("nativeMain/resources")
}

tasks.withType<AbstractPublishToMaven>().configureEach {
    onlyIf { false }
}
