package net.urflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}

