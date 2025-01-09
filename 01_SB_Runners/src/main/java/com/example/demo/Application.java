package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    // Main entry point of the Spring Boot Application
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // First CommandLineRunner bean with @Order(1)
    @Bean
    @Order(1)
    public CommandLineRunner firstRunner() {
        return args -> {
            System.out.println("First CLR executed");
        };
    }

    // Second CommandLineRunner bean with @Order(2)
    @Bean
    @Order(2)
    public CommandLineRunner secondRunner() {
        return args -> {
            System.out.println("Second CLR executed");
        };
    }

    // Third CommandLineRunner bean with @Order(3)
    @Bean
    @Order(3)
    public CommandLineRunner thirdRunner() {
        return args -> {
            System.out.println("Third CLR executed");
        };
    }

    // REST controller to handle GET requests
    @GetMapping("/welcome")
    public String greetUser() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Welcome to My Page</title>
                    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&family=Pacifico&display=swap" rel="stylesheet">
                    <style>
                        body, html {
                            margin: 0;
                            padding: 0;
                            height: 100%;
                            background: linear-gradient(135deg, #ff007f, #ff6600, #0099ff);
                            font-family: 'Roboto', sans-serif;
                            overflow: hidden;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                        }
                        .container {
                            text-align: center;
                            color: white;
                            font-size: 3rem;
                            font-weight: 700;
                        }
                        .greeting {
                            font-family: 'Pacifico', cursive;
                            font-size: 5rem;
                            margin-bottom: 20px;
                        }
                        .sub-text {
                            font-size: 1.5rem;
                            color: #fefefe;
                            margin-bottom: 30px;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <div class="greeting">Welcome to My World!</div>
                        <div class="sub-text">Let's create something amazing together.</div>
                    </div>
                </body>
                </html>
        """;
    }
}
