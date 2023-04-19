
# Project Title
Spring AOP logger


## Acknowledgements

 - [Spring AOP](https://docs.spring.io/spring-framework/docs/2.5.x/reference/aop.html)

## Authors

- [Mahmud Bodurov](https://www.github.com/Mahmud989)


## Features

- Dynamic endpoint auth


## 🚀 About 
Auth tool uses spring aop

## Publishing
 ``` ./gradlew clean build publish  -PrepoPassword=  -PrepoUser=```

## Usage/Examples

```java

import com.mb.tool.aop.authenticator.AuthenticationResolver;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomAuthenticationResolver implements AuthenticationResolver {
    private final AuthClient authClient;

    @Override
    public Object authenticate(String authorization) {
        if (StringUtils.isBlank(authorization)) {
            throw new ClientException("", "USER_UNAUTHORIZED", HttpStatus.UNAUTHORIZED.value());
        }
        return authClient.verifyTokenAndGetPayload(authorization);
    }
}

@RestController
@RequiredArgsConstructor
@RequestMapping("/example")
public class ExampleController {

    private final ExampleService service;
    
    @GetMapping
    @AuthenticationRequired
    public List<Example> getExamples(@AuthenticationUser User user){
        return service.getExamples(user);
    }
}
```


## Tech Stack
 Aspectj, Spring Boot, Spring AOP



