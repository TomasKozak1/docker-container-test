package com.samsung.healthcare.trinoruleupdateservice.application.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("config")
data class ApplicationProperties(
    val databaseConfig: DatabaseConfig,
    val accountService: AccountServiceConfig,
    val trino: TrinoConfig,
) {
    data class DatabaseConfig(
        val prefix: String,
        val postfix: String,
    )

    data class AccountServiceConfig(
        val url: String,
    )

    data class TrinoConfig(
        val catalogs: Catalogs,
        val accessControl: AccessControlConfig,
    ) {
        data class Catalogs(
            val originalDb: Db,
            val deIdentifiedDb: Db,
        ) {
            data class Db(
                val name: String,
            )
        }
    }

    data class AccessControlConfig(
        val configFilePath: String,
    )
}
