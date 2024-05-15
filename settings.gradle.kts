pluginManagement {
    includeBuild("../build-logic")
}

plugins {
    id("multimodule")
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

listOf(
    "kommander", "koncurrent", "kase", "kollections",
    "epsilon-api", "symphony", "cinematic"
).forEach { includeBuild("../$it") }

rootProject.name = "epsilon-server"

includeSubs("epsilon-ktor","ktor","server")
