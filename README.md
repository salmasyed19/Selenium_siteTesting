
# Magento Automation Project

## Overview

This project automates the testing of various functionalities on the Magento Software Testing Board's Luma website using Selenium, TestNG, DataProvider, and the Page Object Model (POM) design pattern. The functionalities include registration, sign-in, password change, adding addresses, adding products to the wishlist, and adding products to the cart.

## Project Structure

- **src/main/java**: Contains the main Java files for the project.
  - **pages**: Page Object Model classes representing the web pages.
  - **tests**: Test classes containing the test methods.

- **src/test/resources**: Contains the test resources.
  - **testdata**: Test data files.

- **pom.xml**: Maven configuration file.
- **testng.xml**: TestNG configuration file.

## Tools and Technologies

- **Java**: Programming language (JDK 21).
- **Selenium WebDriver**: For browser automation.
- **TestNG**: Testing framework.
- **POM (Page Object Model)**: Design pattern for enhancing test maintenance and reducing code duplication.
- **Eclipse IDE**: Integrated development environment.
- **Maven**: Dependency management tool.

## Getting Started

### Prerequisites

- Java JDK 21
- Selenium WebDriver
- TestNG
- Eclipse IDE
- Maven

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/magento-automation.git
   ```
2. Open the project in Eclipse.

3. Configure Maven to download the required dependencies:
   ```bash
   mvn clean install
   ```

### Running Tests

1. Navigate to the `src/test/java` directory.

2. Run the desired test classes using TestNG.

### Project Scenarios

1. **Registration**:
   - Test creating an account with first name, last name, email, password, and confirm password.
   - [Registration Test Code](./src/test/java/tests/RegistrationTest.java)

2. **Sign-In**:
   - Test the login functionality with valid and invalid credentials.
   - [Sign-In Test Code](./src/test/java/tests/SignInTest.java)

3. **Change Password**:
   - Test changing the password for a user.
   - [Change Password Test Code](./src/test/java/tests/ChangePasswordTest.java)

4. **Add Address**:
   - Test adding a new address for a user.
   - [Add Address Test Code](./src/test/java/tests/AddAddressTest.java)

5. **Wishlist**:
   - Test adding products to the wishlist.
   - [Wishlist Test Code](./src/test/java/tests/WishlistTest.java)

6. **Add to Cart**:
   - Test adding products to the cart.
   - [Add to Cart Test Code](./src/test/java/tests/AddToCartTest.java)

## Data-Driven Testing

Test data for the scenarios are provided using DataProvider methods. The data provider methods supply the test data to the test methods.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.

## Contact

For any inquiries or support, please contact Syed Salma at [syedsalma42267@gmail.com](syedsalma42267@gmail.com).

---

Feel free to adjust the links, email, and any other details to match your specific project setup and personal information.
