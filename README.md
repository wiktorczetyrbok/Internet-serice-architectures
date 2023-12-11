# Internet Service Architecture Project

## Overview

This project demonstrates the implementation of an Internet service architecture using various technologies. The application is built using Spring Boot, PostgreSQL for the database, Docker for containerization, JPA for data persistence, Angular for the frontend, and a gateway for routing. To run the application, follow the instructions below.

## Technologies Used

- Spring Boot
- PostgreSQL
- Docker
- JPA
- Angular
- Gateway

## Getting Started

### Prerequisites

Make sure you have the following installed on your system:

- Docker
- Angular.js
- Java Development Kit (JDK)

### Running the Application

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/your-username/internet-service-architecture.git
   cd internet-service-architecture
   ```

2. Navigate to the project directory and run the build script:
   ```bash
   sh build.sh
   ```
   This script will handle the compilation and packaging of the Spring Boot application and Angular frontend.
   
3. Start the application using Docker Compose:
   ```bash
   docker-compose up
   ```
   This command will launch the necessary containers, including the Spring Boot application, PostgreSQL database, and Angular frontend.

4. Access the application.
  Open your web browser and go to ```http://localhost:8087``` to access the application.
