# API Automation

1. Create an account https://www.mockapi.io/projects and set up an endpoint for Bank transactions (only 1 endpoint required)
2. For every request please make sure to include at least an assertion for the Status Code.
3. Create the following tests using the Bank transactions endpoint:
- Verify the Endpoint is empty (If it has any data use the DELETE request to clean and leave it empty)
- Initialize the POJO with 10 random data. Also, make a code verification for avoiding duplicate email accounts. Then, perform the POST request.
- Make the GET request, asserting that there are not duplicate email accounts.
- Add a test to update an existing AccountNumber.

Note: to run all test you can run DataSetSuite.xml

Test evidence

![test_1](https://raw.githubusercontent.com/am-garc1a/api_automation/main/src/assets/images/1.PNG)
![test_2](https://raw.githubusercontent.com/am-garc1a/api_automation/main/src/assets/images/2.PNG)