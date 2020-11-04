import kinds.cloudstate.io.v1alpha1.statefulService
import kinds.cloudstate.io.v1alpha1.statefulStore

class CloudstateTest {

    fun aStatefulStore() {
        statefulStore {
            metadata {
                name("cassandra")
            }
            spec {
                cassandra {
                    host("cassandra-cassandra-0.cassandra-cassandra-svc.cassandra.svc.cluster.local")
                }
            }
        }
    }

    fun aStatefulService() {
        statefulService {
            metadata {
                name("shopping-cart")
            }
            spec {
                storeConfig {
                    database("shoppingcart")
                    statefulStore {
                        name("cassandra")
                    }
                }
                containers {
                    container {
                        image("gcr.io/stateserv/js-shopping-cart:latest")
                    }
                }
            }
        }
    }

}