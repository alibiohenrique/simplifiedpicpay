package com.simplifiedpicpay.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //  I was using RestTemplate dependencies in other classes, one for sending a message notification
    //  to the users when the transaction was successfully, and also sending an authorize message
    //  for the one that is calling the service.

    //  So now I'm creating this class which is a configuration class, and create the right instance of
    //  RestTemplate. Annotation @Bean will be capable to create the proper injection in the classes that are
    //  dependant of RestTemplate.
    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

}
