# Simple Torrent-like Application (STA)

This project is a simple peer-to-peer (P2P) file-sharing application inspired by the BitTorrent protocol. It includes a tracker and multiple nodes (peers) that can share files with each other using TCP/IP and multi-threaded data transfer.

## Features
- Peer-to-peer file sharing using Java sockets.
- Multi-directional data transfer (MDDT) – download file pieces from multiple peers simultaneously.
- Tracker server to manage peer-to-peer communication.
- Command-line interface (CLI) using Spring Shell for easy interaction.
- H2 database for tracking file metadata.
- Lightweight, efficient file-sharing system.

## Tech Stack
- **Backend**: Java (Socket programming, multithreading)
- **CLI**: Spring Shell
- **Database**: H2
- **Build Tool**: Maven

## Requirements
- **Java**: JDK 21 or later
- **Maven**: Latest version (for building and managing dependencies)
- **Spring Boot**: 3.3.4
- **H2 Database**: Embedded mode for simplicity.

### Dependencies
- Spring Shell
- Spring Data JPA
- H2 Database
- Spring Web (optional, if planning to expose REST APIs)

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/DankoFox/STA.git
cd STA
```

### 2. Build the Project

To build the project and download dependencies:

```bash
mvn clean install
```

### 3. Running the Tracker

The tracker is the central server that keeps track of peers. Run it by executing:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="tracker"
```

### 4. Running a Node (Peer)

Each peer (or node) can be run as a separate instance. To run a peer, execute the following command:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="node"
```

### 5. Available Commands (CLI)

After running the node, you can interact with it using the following commands:

- `start-download <file-name>`: Start downloading a file from available peers.
- `stop-download <file-name>`: Stop the download process.
- `show-stats`: Display upload/download statistics.
- `upload <file-path>`: Share a file with the network.

### 6. Configuration

Database: The application uses H2 in embedded mode by default. Configuration for H2 is available in the `application.properties` file in the `src/main/resources` directory:

```ini
spring.datasource.url=jdbc:h2:file:./data
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

You can access the H2 console at http://localhost:8080/h2-console to view or manage the data.

## License

This project is licensed under the MIT License.
