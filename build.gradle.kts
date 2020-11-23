buildscript {
    repositories {
        jcenter()
        mavenLocal()
    }
}


plugins {
    id("io.kuberig.dsl.generator") apply false
}

subprojects {
    apply {
        plugin("io.kuberig.dsl.generator")
    }

    repositories {
        jcenter()
        mavenLocal()
        maven("https://dl.bintray.com/teyckmans/rigeldev-oss-maven/")
    }

    dependencies {
        val implementation by configurations
        val kuberigDslVersion : String by this@subprojects
        implementation("io.kuberig.dsl.kubernetes:kuberig-dsl-kubernetes-v1.19.3:0.1.3")
    }
}