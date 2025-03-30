@file:OptIn(ExperimentalBCVApi::class)

import cn.rtast.rob.buildSrc.excludeModuleNames
import com.vanniktech.maven.publish.SonatypeHost
import kotlinx.validation.ExperimentalBCVApi
import org.jetbrains.kotlin.gradle.targets.jvm.tasks.KotlinJvmTest
import org.jetbrains.kotlin.gradle.targets.native.tasks.KotlinNativeTest

plugins {
    alias(libs.plugins.signing)
    alias(libs.plugins.vanniktech.maven.publish)
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.binary.compatibility.validator)
}

val libVersion: String by project

allprojects {
    group = "cn.rtast.rob"
    version = libVersion

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://libraries.minecraft.net")
    }
}

subprojects {
    if (name in excludeModuleNames) return@subprojects
    apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
    apply(plugin = "com.vanniktech.maven.publish")
    apply(plugin = "signing")
    if (!project.name.contains("starter-backend")) {
        apply(plugin = "org.jetbrains.kotlin.multiplatform")
    } else {
        apply(plugin = "org.jetbrains.kotlin.jvm")
    }

    val wsAddress: String? by extra
    val wsPassword: String? by extra
    val qqGroupId: String? by extra

    tasks.withType<KotlinNativeTest> {
        environment("WS_ADDRESS", wsAddress ?: "")
        environment("WS_PASSWORD", wsPassword ?: "")
        environment("QQ_GROUP_ID", qqGroupId ?: "")
    }

    tasks.withType<KotlinJvmTest> {
        environment("WS_ADDRESS_PLAIN", wsAddress ?: "")
        environment("WS_PASSWORD", wsPassword ?: "")
        environment("QQ_GROUP_ID", qqGroupId ?: "")
    }

    mavenPublishing {
        publishing {
            repositories {
                maven {
                    name = "RTAST"
                    url = uri("https://maven.rtast.cn/releases")
                    credentials {
                        username = "RTAkland"
                        password = System.getenv("RTAST_PUBLISH_PASSWORD")
                    }
                }
            }
        }
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
        if (System.getenv("RTAST_PUBLISH_PASSWORD") != null) signAllPublications()
        coordinates("cn.rtast.rob", project.name, libVersion)
        pom {
            description = "A Kotlin multiplatform library for OneBot11 development"
            url = "https://github.com/RTAkland/ROneBot"
            developers {
                developer {
                    id = "rtakland"
                    name = "RTAkland"
                    email = "me@rtast.cn"
                }
            }

            licenses {
                license {
                    name = "The Apache License, Version 2.0"
                    url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                }
            }

            scm {
                url = "https://github.com/RTAkland/ROneBot"
                connection = "scm:git:git://github.com/RTAkland/ROneBot.git"
                developerConnection = "scm:git:ssh://git@github.com/RTAkland/ROneBot.git"
            }
        }
    }
}

apiValidation {
    klib {
        enabled = true
    }
    nonPublicMarkers.add("cn.rtast.rob.annotations.InternalROBApi")
}

if (System.getenv("RTAST_PUBLISH_PASSWORD") != null) {
    signing {
        useGpgCmd()
        sign(publishing.publications)
    }
}
