package com.agoda.demo.workflow.orchestrator.core
import com.agoda.commons.sql.hikari.HikariDataSourcePool
import com.agoda.commons.sql.hikari.load.balancing.DataSourcePoolLoadBalancer
import java.io.IOException
import java.time.Instant

/**
 * Simple Application
 */
fun main(args: Array<String>) {

    // Configure discovery/vault integrated balancer
    val balancer = DataSourcePoolLoadBalancer(
        "pool-balancer",
        HikariDataSourcePool.builder("mock").build().datasourcesState,
        DataSourcePoolLoadBalancer.DEFAULT_WEIGHT_STRATEGY
    )


    val id: Int = Instant.now().epochSecond.toInt()

    balancer.withConnection {
        it.beginRequest()
        it.prepareStatement("").executeQuery()
        it.commit()
    }
}
