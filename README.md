# PhantomEye

Cybersecurity monitoring tool for network asset management, port scanning, and automated threat detection.

## Tech Stack

- **Backend:** Java 21, Spring Boot 3.4
- **Database:** PostgreSQL (via Docker)
- **ORM:** Spring Data JPA / Hibernate
- **Scanning:** TCP socket-based port scanner

## Features

- Network asset inventory (servers, computers, routers, medical machines)
- Real-time TCP port scanning (SSH, HTTP, HTTPS, MySQL, PostgreSQL)
- Automated alert generation when open ports are detected
- Severity classification (LOW, MEDIUM, HIGH)
- Alert lifecycle management (OPEN, CLOSED, PENDING, IGNORED)
- RESTful API for all operations

## Architecture

```
Controller → Service → Repository → PostgreSQL
     ↓
PortScannerService (TCP scan)
     ↓
AlertService (automated threat evaluation)
```

## Getting Started

### Prerequisites
- Java 21
- Docker & Docker Compose
- Maven

### Run

```bash
# Start PostgreSQL
docker-compose up -d

# Run the API
mvn spring-boot:run
```

The API runs on `http://localhost:5042`.

### API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/assets` | List all assets |
| POST | `/api/assets` | Register new asset |
| POST | `/api/scan/{assetId}` | Scan asset ports |
| GET | `/api/alerts` | List all alerts |

## License

MIT
