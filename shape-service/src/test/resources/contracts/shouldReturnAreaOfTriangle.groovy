import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            description "Should return the area of a 100x100 triangle"
            request {
                url "/triangle?length=100.0&width=100.0"
                method GET()
            }
            response {
                status 200
                headers{
                    header 'Content-Type': 'application/json;charset=UTF-8'
                }
                body (
                        area: 5000
                )
            }
        },
        Contract.make {
            description "Should return the area of a 100x50 triangle"
            request {
                url "/triangle?length=100.0&width=200.0"
                method GET()
            }
            response {
                status 200
                headers{
                    header 'Content-Type': 'application/json;charset=UTF-8'
                }
                body (
                        area: 10000
                )
            }
        },
        Contract.make {
            description "Should return the area of a 50x100 triangle"
            request {
                url "/triangle?length=50.0&width=100.0"
                method GET()
            }
            response {
                status 200
                headers{
                    header 'Content-Type': 'application/json;charset=UTF-8'
                }
                body (
                        area: 2500
                )
            }
        },
        Contract.make {
            description "Should return the area of a 50x50 triangle"
            request {
                url "/triangle?length=50.0&width=50.0"
                method GET()
            }
            response {
                status 200
                headers{
                    header 'Content-Type': 'application/json;charset=UTF-8'
                }
                body (
                        area: 1250
                )
            }
        }
]
