# Berlin Clock Kata

# Description

Implementation of the **Berlin Clock (Mengenlehreuhr)** using **Java**, **Spring Boot**, and **Test-Driven Development (TDD)**.

### Time Representation
```
[Seconds Lamp]     - Y (on for even seconds) / O (off)
[Five Hour Row]    - 4 red lamps (each = 5 hours)
[Single Hour Row]  - 4 red lamps (each = 1 hour)
[Five Minute Row]  - 11 lamps (Y=yellow, R=red for quarters)
[Single Minute Row]- 4 yellow lamps (each = 1 minute)
```

## Prerequisites

- Java 17+
- Maven 3.6+

## Build
```bash
./mvnw clean install
```

## Run
```bash
./mvnw spring-boot:run
```

Application runs on `http://localhost:8080`

## Tests
```bash
# Run all tests
./mvnw test

# Run with coverage
./mvnw clean test jacoco:report
```

Coverage report: `target/site/jacoco/index.html`

## API Usage

### Endpoint

**GET** `/api/berlin-clock?hours={h}&minutes={m}&seconds={s}`

### Example
```bash
curl "http://localhost:8080/api/berlin-clock?hours=13&minutes=17&seconds=1"
```

**Response:**
```json
{
  "secondsLamp": "O",
  "fiveHourRow": "RROO",
  "singleHourRow": "RRRO",
  "fiveMinuteRow": "YYROOOOOOOO",
  "singleMinuteRow": "YYOO"
}
```

## Design Decisions

- **TDD Approach**: All features developed test-first
- **Clean Code**: No magic values, meaningful names, low complexity
- **SOLID Principles**: Single responsibility, dependency injection
- **Immutability**: Domain models are immutable
- **Guard Clauses**: Input validation at controller level

## Code Quality

- **Test Coverage**: > 95%
- **Cyclomatic Complexity**: Average < 3
- **Total Tests**: 29+ unit and integration tests