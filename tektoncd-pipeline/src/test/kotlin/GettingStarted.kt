import kinds.tekton.dev.v1beta1.task
import kinds.tekton.dev.v1beta1.taskRun

/**
 * Shows how the examples on the getting started page map when defined using the KubeRig DSL.
 *
 * https://tekton.dev/docs/getting-started/
 */
class GettingStarted {

    fun aTask() {

        task {
            metadata {
                name("hello")
            }
            spec {
                steps {
                    step {
                        name("hello")
                        image("ubuntu")
                        command("echo")
                        args {
                            arg("'Hello World!'")
                        }
                    }
                }
            }
        }

    }

    fun aTaskRun() {

        taskRun {
            metadata {
                generateName("hello-run-")
            }
            spec {
                taskRef {
                    name("hello")
                }
            }
        }

    }

}