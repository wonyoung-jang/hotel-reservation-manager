## Hotel Reservation Manager
The Hotel Reservation Manager is designed to accommodate the specific needs of the fictional Landon Hotel's business in Toronto, Canada. This project is developed with a Spring Boot Java backend, an Angular frontend, and is localized for English and French languages, with additional functionalities for currency display and time zone conversion.

## Technologies Used
- Spring Boot (Java)
- Angular
- Maven
- Docker
- Localization and Internationalization with Java Resource Bundles
- Currency Conversion (Frontend Logic)
- Time Zone Conversion (Java Backend Logic)

## Setup and Running the Application
Ensure you have Java, Maven, Node.js, and Angular CLI installed on your system.

### Backend Setup
1. In your terminal, run:
    ```
    mvn clean install
    mvn spring-boot:run
    ```

    This will start the Spring Boot application.

### Frontend Setup
1. Navigate to the `UI` folder.
2. Run `npm install` to install dependencies.
3. Build and serve the Angular application:
   ```
   ng build
   ng serve
   ```
   Access the frontend at `localhost:4200`.

## Features
### Localization and Internationalization
- Define welcome messages in English and French using Resource Bundles.
- Display both messages simultaneously using multithreading.

### Currency Display
- Modify the Angular frontend to show reservation prices in USD, CAD, and EUR without backend changes.

### Time Zone Conversion
- Implement a Java class for converting times between ET, MT, and UTC.
- Use a REST controller to expose the time conversion to the frontend.

## Docker Deployment
1. Package the application with Maven: `mvn clean package`   
2. Create a `Dockerfile` in the main project directory.
3. Build the Docker image and run it in a container, exposing it on port `8080`.


## License
This project is licensed under the MIT License - see [LICENSE](LICENSE) for details.
