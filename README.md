# Microservices Inventory Application

This project implements a microservices-based inventory application using Spring Boot and Spring Cloud. It demonstrates key microservice patterns such as Service Discovery, API Gateway, and Centralized Configuration.

## Architecture Overview

The application consists of the following microservices:

*   **Discovery Service (Eureka Server)**: Acts as the service registry, allowing microservices to register themselves and discover other services.
*   **Config Service (Spring Cloud Config Server)**: Provides centralized configuration management for all microservices, pulling configurations from a Git repository.
*   **API Gateway (Spring Cloud Gateway)**: The single entry point for all client requests, responsible for routing requests to the appropriate downstream microservices and handling cross-cutting concerns like CORS.
*   **Customer Service**: Manages customer-related data and operations, exposing REST APIs for customer management.
*   **Inventory Service**: Manages product inventory data and operations, exposing REST APIs for inventory management.
*   **Billing Service**: Handles billing-related logic and data, likely interacting with customer and inventory services.

## Technologies Used

*   **Spring Boot**: For building standalone, production-grade Spring applications.
*   **Spring Cloud**: Provides tools for building common patterns in distributed systems (e.g., service discovery, configuration management, API Gateway).
    *   **Spring Cloud Netflix Eureka**: For Service Discovery.
    *   **Spring Cloud Config**: For Centralized Configuration.
    *   **Spring Cloud Gateway**: For API Gateway.
    *   **Spring Cloud OpenFeign**: For declarative REST clients (used in Billing Service).
*   **Spring Data JPA & Spring Data REST**: For simplified data access and exposing REST endpoints for entities.
*   **H2 Database**: An in-memory database used for development and testing (some services also include MySQL connector).
*   **Lombok**: To reduce boilerplate code.
*   **Maven**: For build automation.
*   **Docker**: For containerization of microservices.
