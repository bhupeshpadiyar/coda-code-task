# csv-parser-task
Coding task assigned by Coda Payments

Parsing the CSV file delimited with comma(,)

## Getting Started

This project helps to parse a CSV file (with the specified delimiter) located in local drive and writes the equivalent JSON file with key as header column name and value as corrosponding row column value

i.e. The following CSV

```
name,email,phone,department,salary, age
Bhupesh , bhupeshpadiyar@gmail.com, +60-01135629408, IT, 10000.00, 25
David,david@gmail.com, +1-0123456789,Sales , -15000.10, 30
```


Will be translated to the following JSON data and will be written in a JSON file configured in application.properties file

```
[{"name":"Bhupesh","email":"bhupeshpadiyar@gmail.com","phone":"+60-01135629408","department":"IT","salary":10000.0," age":25}
,{"name":"David","email":"david@gmail.com","phone":"+1-0123456789","department":"Sales","salary":-15000.1," age":30}]
```



### Prerequisites

Following frameworks/tools required to run this project

* Apache Maven 3.6.2
* Spring Boot 2.4.1
* IDE (IntellijIDEA OR Spring Tool Suites)


### Configuration

Configure the input CSV file and output json files path in application.properties file

```
csv.input.file = <your-file-path>/<file-name>.csv
```

```
json.output.file = <your-file-path>/<file-name>.json
```


### Running the code

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

### Verify the output

Check the output JSON file configured in application.properties file.

### Authors

* **Bhupesh Singh Padiyar** - *Initial work* - [Bhupesh Singh Padiyar](https://github.com/bhupeshpadiyar)
