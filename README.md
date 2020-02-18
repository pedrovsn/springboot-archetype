# springboot-archetype

An archetype which contains a starter SpringBoot Microservice. More specifically, this archetype creates a project with the following layout:

```
my-app
|-- pom.xml
|-- src
|   -- main
|      -- resources
|         -- messages
|            -- messages.properties
|            -- messages-pt_BR.properties
|         -- application.yml
|         -- application-local.yml
|      -- java
|         -- com
|            -- yourcompany
|               -- config
|                  -- DataSourceConfig.java
|                  -- RestTemplateConfig.java
|                  -- SwaggerConfig.java
|                  -- SwaggerConfigProperties.java
|               -- controller
|                  -- DemoController.java
|                  -- HealthCheckController.java
|               -- domain
|                  -- bean
|                     -- ApiError.java
|                     -- ListResponse.java
|                     -- PageRequest.java
|                  -- dto
|                     -- DemoRequestDTO.java
|                     -- DemoResponseDTO.java
|                  -- enum
|                  -- orm
|                     -- Demo.java
|               -- exception
|                  -- DemoNotFoundException.java
|               -- handler
|                  -- business
|                     -- DemoExceptionHandler.java
|                  -- GlobalExceptionHandler.java
|               -- repository
|                  -- impl
|                     -- DemoRepository.java
|                     -- DemoRepositoryWithSQL.java
|                  -- DatabaseExternal.java
|               -- service
|                  -- impl
|                     -- DemoServiceImpl.java
|                  -- DemoService.java
|               -- DemoApplication.java
|   -- test
|      -- resources
|         -- application.yml
|      -- java
|         -- com
|            -- yourcompany
|               -- config
|                  -- ConfigRulesTest.java
|               -- controller
|                  -- ControllerRulesTest.java
|               -- domain
|                  -- dto
|                     -- DTORulesTest.java
|               -- repository
|                  -- RepositoryRulesTest.java
|               -- service
|                  -- impl
|                     -- DemoServiceImplTest.java
|                  -- ServiceRulesTest.java
|               -- DemoApplicationTests.java
```

## Getting Started

Clone from Github

`$ git clone https://github.com/pedrovsn/springboot-archetype`

Then install to your local repo

`mvn install archetype:update-local-catalog`

## Generate Your Project

```
$ mvn archetype:generate 
-DarchetypeGroupId=com.pedrovsn 
-DarchetypeArtifactId=springboot-archetype 
-DarchetypeVersion=0.0.1-SNAPSHOT 
-DgroupId=<your-group-id> 
-DartifactId=<your-artifcat-id> 
-Dversion=1.0-SNAPSHOT
```

## Copyright

Released under the Apache License 2.0. See the LICENSE file.
