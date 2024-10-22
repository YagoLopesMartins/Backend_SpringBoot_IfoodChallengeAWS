# Challenge AnotaAi - Ifood (Products - Catalog)

### Reference Documentation

 - https://github.com/githubanotaai/new-test-backend-nodejs

### Tecnologies

 - Spring Boot ( Java | Maven | Web | Lombok | DevTools | Data MongoDB)
 - Cloud
   - AWS SQS
   - AWS S3 bucket JSON
 - API REST
 - CRUD with SOLID principles
   - domain (Category, Product), DTO, Exception
   - controllers
   - repositories
   - services

### AWS SETUP

- Create SQS (Simple Queue Service)
- Create SNS (pub/sub) topic
- User setup IAM (polices and permissions)

#### Update application.properties
 - aws.accessKeyId=
 - aws.secretLKey=
 - aws.region=
 - aws.sns.topic.catalog.arn=
#### Update pom.xml Add AWS SDK dependency
#### config -> AwsSnsConfig
#### services -> aws


