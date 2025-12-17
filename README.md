# Selenium Java Framework

[![CI](https://github.com/anand125jha/selenium-java-framework/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/anand125jha/selenium-java-framework/actions/workflows/ci.yml)

Lightweight Selenium + TestNG Java framework with Extent report integration and CI.

## What's included

- Maven project
- TestNG test runner (`testng.xml`)
- `src/main/resources/config.properties` for configuration
- `DriverFactory` with ThreadLocal driver support
- Extent reports saved to `reports/`
- GitHub Actions workflow (`.github/workflows/ci.yml`) to run tests and upload reports

## Requirements

- Java 21 (JDK)
- Maven 3.6+

## Quick start (local)

1. Clone the repository

```bash
git clone https://github.com/anand125jha/selenium-java-framework.git
cd selenium-java-framework
```

2. Run all tests (default uses config properties)

PowerShell (Windows):

```powershell
mvn test
```

Linux/macOS:

```bash
mvn test
```

3. Run a single test (PowerShell needs quoting for `#`):

```powershell
mvn "-Dtest=tests.GoogleTest#verifyHomePage" test
```

4. Toggle headless mode (overrides `config.properties`):

```bash
mvn -Dheadless=false test
```

## Configuration

- `src/main/resources/config.properties` contains main settings such as `baseUrl` and `headless`.
- You can override any property via `-Dproperty=value` on the `mvn` command line.

## Reports

- Extent report is written to `reports/AutomationReport.html` after test runs.
- On CI the workflow uploads `reports` and `target/surefire-reports/` as artifacts — download them from the Actions run page.

## CI

- GitHub Actions workflow runs `mvn test` and uploads test reports.
- If you use GitLab CI or another runner, adapt the job to run `mvn test` and collect `reports/`.

## Next plan

- Add `README` badges for coverage, code quality
- Add logback/SLF4J for better logging
- Add Wait utilities, RetryAnalyzer for flaky tests
- Provide Docker Compose (Selenium Grid) for local cross-browser testing

## Contributing

- Please open issues or PRs for suggestions or fixes.

---

Generated on project setup. For support, reach out in issues.
