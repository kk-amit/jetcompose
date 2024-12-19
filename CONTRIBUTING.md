# Contributing to JetCompose Library

We are excited to have you contribute to the JetCompose Library! Contributions can be in the form of bug fixes, new features, documentation improvements, or code optimization. Follow the guidelines below to ensure a smooth contribution process.

---

## Table of Contents

1. [Code of Conduct](#code-of-conduct)
2. [Getting Started](#getting-started)
3. [How to Contribute](#how-to-contribute)
    - [Bug Reports](#bug-reports)
    - [Feature Requests](#feature-requests)
    - [Code Contributions](#code-contributions)
4. [Pull Request Guidelines](#pull-request-guidelines)
5. [Development Workflow](#development-workflow)
6. [License](#license)

---

## Code of Conduct

Please read and adhere to our [Code of Conduct](CODE_OF_CONDUCT.md) to ensure a welcoming environment for all contributors.

---

## Getting Started

1. **Fork the Repository**: Click the "Fork" button at the top of this repository.
2. **Clone Your Fork**: Clone your forked repository to your local machine.
   ```bash
   git clone https://github.com/<your-username>/JetCompose.git
   ```
3. **Set Upstream Remote**: Add the original repository as an upstream remote.
   ```bash
   git remote add upstream https://github.com/kk-amit/JetCompose.git
   ```
4. **Install Dependencies**: Ensure you have the necessary tools and dependencies installed (e.g., Android Studio, Kotlin).
5. **Create a Branch**: Create a new branch for your feature or bug fix.
   ```bash
   git checkout -b feature-or-bug-branch
   ```

---

## How to Contribute

### Bug Reports

If you encounter any bugs, please [open an issue](https://github.com/kk-amit/JetCompose/issues) with the following information:
- A clear and descriptive title.
- Steps to reproduce the issue.
- Expected and actual results.
- Screenshots or error logs (if applicable).

### Feature Requests

We welcome suggestions for new features! To propose a feature:
- [Open an issue](https://github.com/kk-amit/JetCompose/issues) with a detailed description of the feature and its potential use cases.
- Explain how the feature aligns with the library's goals.

### Code Contributions

1. **Follow the Development Workflow** (see below).
2. **Write Tests**: Ensure that your code changes are covered with appropriate unit tests.
3. **Update Documentation**: If your contribution affects the usage of the library, update the relevant documentation.
4. **Run Tests Locally**: Before submitting your changes, ensure all tests pass locally.
   ```bash
   ./gradlew test
   ```

---

## Pull Request Guidelines

1. **Create a Pull Request**: Once your feature or fix is ready, push your branch to your fork and [create a pull request](https://github.com/kk-amit/JetCompose/pulls).
2. **Provide Context**: Clearly describe the purpose of the pull request, referencing the related issue (if any).
3. **Adhere to Style Guidelines**: Ensure your code follows the project's style conventions (e.g., formatting, naming).
4. **Address Review Feedback**: Collaborate with reviewers to address any feedback on your pull request.
5. **Keep Commits Clean**: Squash commits if necessary to maintain a clean commit history.

---

## Development Workflow

1. **Sync with Upstream**: Regularly sync your branch with the upstream repository to avoid conflicts.
   ```bash
   git fetch upstream
   git merge upstream/main
   ```
2. **Build the Project**: Use Android Studio to build and test your changes.
3. **Test Thoroughly**: Run all tests and ensure your changes do not introduce new issues.
4. **Document Changes**: Update README.md, CHANGELOG.md, or any other relevant documentation.

---

## License

By contributing to JetCompose, you agree that your contributions will be licensed under the [MIT License](LICENSE).

Thank you for contributing to JetCompose! 🎉
