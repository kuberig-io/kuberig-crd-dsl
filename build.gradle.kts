import com.jfrog.bintray.gradle.BintrayExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.kuberig.dsl.generator") apply false
    id("com.jfrog.bintray") apply(false)
}

val projectVersion = if (project.version.toString() == "unspecified") {
    println("Defaulting to version 0.0.0")
    "0.0.0"
} else {
    project.version.toString()
}
project.version = projectVersion

subprojects {
    apply {
        plugin("io.kuberig.dsl.generator")
        plugin("maven-publish")
        plugin("com.jfrog.bintray")
    }

    val subProject = this

    subProject.group = "io.kuberig.crd.dsl"
    subProject.version = projectVersion

    repositories {
        jcenter()
    }

    dependencies {
        val implementation by configurations
        val kuberigDslVersion : String by this@subprojects
        implementation("io.kuberig.dsl.kubernetes:kuberig-dsl-kubernetes-v1.20.0:$kuberigDslVersion")
    }

    val sourcesJar by tasks.registering(Jar::class) {
        archiveClassifier.set("sources")

        val sourceSets: SourceSetContainer by subProject
        from(sourceSets["main"].allSource)
    }

    configure<PublishingExtension> {

        publications {
            register(subProject.name, MavenPublication::class) {
                from(components["java"])
                artifact(sourcesJar.get())
            }
        }

    }

    val bintrayApiKey : String by project
    val bintrayUser : String by project

    configure<BintrayExtension> {
        user = bintrayUser
        key = bintrayApiKey
        publish = true

        pkg(closureOf<BintrayExtension.PackageConfig> {
            repo = "rigeldev-oss-maven"
            name = "io-kuberig-" + subProject.name
            setLicenses("Apache-2.0")
            isPublicDownloadNumbers = true
            websiteUrl = project.properties["websiteUrl"]!! as String
            vcsUrl = project.properties["vcsUrl"]!! as String
        })

        setPublications(subProject.name)
    }

    tasks.withType<Jar> {
        manifest {
            attributes(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version
            )
        }
    }
}