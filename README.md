# ktor-light-app
REST API server


## DataBase and DataSource

Default, this app use H2DB(in memory DB), but you can use other DBs.
For example, MySQL..

```DataSource.kt
private fun connectDb() {
    Database.connect(
        "jdbc:mysql://localhost:3306/schema_name?autoReconnect=true&useSSL=false",
        driver = "com.mysql.jdbc.Driver",
        user = "root",
        password = "password"
    )
}
```

```build.gradle
dependencies {
    // add this sentence
    implementation "mysql:mysql-connector-java:5.1.46"
    
}
```
