import kinds.serving.knative.dev.v1.service

/**
 * Based on https://knative.dev/docs/serving/getting-started-knative-app/
 */
class GettingStartedKNativeApp {

    fun creatingYourDeploymentWithYaml() {

        service {
            metadata {
                name("helloworld-go")
                namespace("default")
            }
            spec {
                template {
                    spec {
                        containers {
                            container {
                                image("gcr.io/knative-samples/helloworld-go")
                                env {
                                    name("TARGET")
                                    value("Go Sample v1")
                                }
                            }
                        }
                    }
                }
            }
        }

    }

}