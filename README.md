# ptkl 🛠️
Ptkl is the official Logger by Pixel Services. It was previously part of the [PTK (Pixel Tool Kit)](https://github.com/Pixel-Services/PixelToolkit) library, but has been separated into its own library for easier use and maintenance. 

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven

## Installation
To include ptkl in your project, add the following dependency and repository to your ``pom.xml``:

### Dependency
```xml
<dependency>
    <groupId>com.pixelservices.logger</groupId>
    <artifactId>ptkl</artifactId>
    <version>${ptklversion}</version>
</dependency>
```
### Repository
```xml
<repository>
    <id>pixel-services-releases</id>
    <name>Pixel Services</name>
    <url>https://maven.pixel-services.com/releases</url>
</repository>
```

## Usage
### Logging
Create a logger instance and use it to log messages at different levels, create Listeners to handle log events, and set a custom formatter:
```java
import com.pixelservices.logger.Logger;
import com.pixelservices.logger.LoggerFactory;

public class Example {
    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    public static void main(String[] args) {
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        logger.debug("This is a debug message");
        
        // Create a listener to handle log events
        LoggerLogEventListener listener = event -> {
            if (event.getLevel() == Level.INFO){
                event.setCancelled(true);
                logger.debug("Event cancelled: " + event.getMessage());
            }
        };
        
        //Register the listener
        LoggerFactory.addListener(listener);
        
        // Set a custom formatter
        LoggerFactory.setFormatter((event) -> event.getLevel() + " - " + event.getMessage());
        logger.info("This message should be formatted");
        
    }
}
```


## Contributing
We welcome contributions! To contribute to ptkl:
1. Fork the repository: [PixelToolkit on GitHub](https://github.com/Pixel-Services/ptkl)
2. Create a feature branch: `git checkout -b feature-name`
3. Commit your changes: `git commit -m 'Add feature'`
4. Push to the branch: `git push origin feature-name`
5. Submit a pull request.
