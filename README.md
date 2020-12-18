# csv-parser-task
Coding task assigned by Coda Payments

Parsing the CSV file delimited with comma(,)

## Prerequisites

Following frameworks/tools required to run this project

* Apache Maven 3.6.2
* Spring Boot 2.4.1
* IDE (IntellijIDEA OR Spring Tool Suites)


## Configuration

Configure the input CSV file and output json files path in application.properties file

```
csv.input.file = <your-file-path>/<file-name>.csv
```

```
json.output.file = <your-file-path>/<file-name>.json
```


## Running the code

Use following maven command to run the code

If using IntellijIDEA IDE

```
mvn idea:idea
```

If using Eclipse/STS

```
mvn eclipse:eclipse
```

Compile the code using following command

```
mvn clean compile
```

Start the application using following command

```
mvn spring-boot:run
```

