[![KubeRig Logo](https://kuberig.io/img/logo/website_logo_transparent_background.png)](https://kuberig.io)

# KubeRig CRD DSL

This repository contains KubeRig DSL generator projects for Kubernetes Custom Resource Definitions. 

Please note: this repo is in early stage development and will change a lot. At this point the DSLs are not yet published to JCenter.

It can serve as a starting point for finding ready to go KubeRig DSL dependencies. 
It can also show you how to generate a KubeRig DSL when the CRDs you want to consume have not been added yet.

## Background

Read about how we do this [here](https://kuberig.io/blog/2020/10/16/crd-support-a-challenge).

# Dependencies

The modules are deployed to bintray in the following repository. They are not available on JCenter at the moment. 
```kotlin
repositories {
  maven("https://dl.bintray.com/teyckmans/rigeldev-oss-maven")
}
```

If you want to give a CRD DSL a try add an implementation dependency to one of the available packages.

|module|dependency|
|------|----------|
|cert-manager|io.kuberig.crd.dsl:cert-manager:0.1.0|
|knative-eventing|io.kuberig.crd.dsl:knative-eventing:0.1.0|
|knative-serving|io.kuberig.crd.dsl:knative-serving:0.1.0|
|tektoncd-pipeline|io.kuberig.crd.dsl:tektoncd-pipeline:0.1.0|