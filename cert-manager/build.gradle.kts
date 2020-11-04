buildscript {
    repositories {
        jcenter()
        maven("https://dl.bintray.com/teyckmans/rigeldev-oss-maven/")
    }
    dependencies {
        classpath("io.kuberig:kuberig-dsl-generator-gradle-plugin:0.1.3")
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
}
apply(plugin="io.kuberig.dsl.generator")


repositories {
    jcenter()
    maven("https://dl.bintray.com/teyckmans/rigeldev-oss-maven/")
}

dependencies {
    implementation("io.kuberig.dsl.kubernetes:kuberig-dsl-kubernetes-v1.19.3:0.1.2")
}