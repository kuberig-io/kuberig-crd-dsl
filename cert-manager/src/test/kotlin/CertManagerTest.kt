import kinds.cert_manager.io.v1.certificate
import kinds.cert_manager.io.v1.issuer

class CertManagerTest {

    /**
     * Shows how the resources defined in the "Verifying the installation"
     * of the Kubernetes installation manual https://cert-manager.io/docs/installation/kubernetes/
     * can be written with the Kuberig DSL.
     */
    fun verifyTheInstallation() {

        issuer {
            metadata {
                name("test-selfsigned")
                namespace("cert-manager-test")
            }
            spec {
                selfSigned {

                }
            }
        }

        certificate {
            metadata {
                name("selfsigned-cert")
                namespace("cert-manager-test")
            }
            spec {
                dnsNames {
                    dnsName("example.com")
                }
                secretName("selfsigned-cert-tls")
                issuerRef {
                    name("test-selfsigned")
                }
            }
        }

    }

}