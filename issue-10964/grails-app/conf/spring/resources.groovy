import issue10964.EmbeddedPostgresFactory

// Place your Spring DSL code here
beans = {
    embeddedPostgresFactory(EmbeddedPostgresFactory) {
        port = application.config.dataSource?.embeddedPort
    }
    embeddedPostgres(embeddedPostgresFactory: "getDataBase")
    getBeanDefinition('hibernateDatastore').setDependsOn('embeddedPostgres')
}
