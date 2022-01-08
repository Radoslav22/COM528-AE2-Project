# COM528-AE2-Project
### Shopping Card Application
### Contributer: Radoslav Takvoryan
# System Requirements 
The system requirements for this application is:
- A working PC with windows 10.
- Java JDK version 8 or newer.
- Apache Maven 3.8 or newer.
- Apache Tomcat 9.
- Working Internet Browser.
# How to run the application
- Download the zip folder and unzip it.
- Open it using Netbeans.
- Right click on the shoppingCartApplication and click on Clean and Build.
- The tomcat server will run automatically, just type your username and password for the server.
- Right click on shoppingCartApplication-web and then Run it. 
- The Shopping Card Application will be served at http://localhost:8080/shoppingCartApplication/index.html <br><br>
!!!NOTE!!!: The application is working with Bank Simulator given for the project and using the details for the user inside it.
You can find the simulator here: http://com528bank.ukwest.cloudapp.azure.com:8080/bank/index.html
In the admin Bank page use the Bank URL http://com528bank.ukwest.cloudapp.azure.com:8080/bank/rest for the properties.

# Features 
### From Admin side:
- Modifying users.
- Changing Bank Properties.
- Changing Catalog Items.
### From User side:
- Login and Register.
- Item list.
- Basket.
- Managing account info.
- Checkout.
# Use cases
| Admin | Action | Response|
|------|--------|---------|
| 1 | Admin logs in | The admin page becomes visible | 
| 2 | Admin can go to basket/ admin/ manage Users/ manage Catalog/ manage Bank | Redirects to a page where only admins can go |
| 3 | Admin can edit the Bank Properties details | Adds details in the Bank properties |
| 4 | Admin can add items to the catalog | Adds items to the catalogue page for admin and user |
| 5 | Admin can remove users and edit their details | Removes and edit user out of the database |
| 6 | Admin can view all users orders | Admin can view all orders in the my orders page |

|User | Action | Response|
|------|--------|---------|
| 1 | User enteres application URL in search engine | Redirects user to home page |
| 2 | User will need to log in the application | Redirects user to user view page |
| 3 | User can add items to shopping cart | automatically adds the item to basket and shopping cart |
| 4 | User can remove items from basket or shopping cart | automatically removes item deducting the price |
| 5 | User can purchase items in the basket link in the nav bar | redirects user to basket where the items added are viewd as well as price and quantity |
| 6 | User can buy the items by pressing on checkout in the basket | redirects user to the checkout |
| 7 | User enter the correct card information | Application send the details via ReST to the Bank Simulator |
| 8 | If user do not enter card details | An error message is shown letting user know the fields are required |
| 9 | If user enters the wrong details | An error message is shown to correct the details |
| 10 | If user enters the right details | a confirmation message will show |
# Test
Below are two charts one for the user and one for the admin tests. These charts below show which action is taken and how will my application react to the action preformed. It also shows which tests have passed and which have not been passed.
### Admin Tests
| Test | Action| Expected Reaction| Status |
| --------- | --------------------------- | -------------------------------- | ------ |
| T1 | Admin enters in the host url for the application. | If the server is running you will be redirected to a home page, if not you will get an error | PASSED ✅ |
| T2 | Admin can log in | application logs in admin or gives error due to wrong details | PASSED ✅ |
| T3 | Admin can modify user| Allows admin to remove or add users, enable or disable it and changing his details. | PASSED ✅  |
| T4 | Admin can modify catalog| Allows admin to remove or add items | FAILED ❌ | Wasn't able to add new products even when trying different ways | 
| T5 | Admin can view all users orders | It is not implemented | FAILED ❌ | 
| T6 | Admin can update the Bank Properties |  Successfully saving the bank properties |  PASSED ✅  |
| T6 | Admin can log out |  redirects them to home page in annonymous mode|  PASSED ✅  |
### User Tests
| Test | Action| Expected Reaction| Status |
| --------- | --------------------------- | -------------------------------- | ------ |
| T1 | User enters in the host url for the application. | If the server is running you will be redirected to a home page, if not you will get an error | PASSED ✅ |
| T2 | User can log in or create an account | application logs in user or creates user or gives error due to wrong details  | PASSED ✅ |
| T3 | User can look for items they want and add to cart | the apllication gets these items and adds them to cart (basket) while also adding the total and quantity | PASSED ✅ |
| T4 | User can press on the basket page and purchase (checkout) items | application will redirect to basket page when clicked and the chekout button will take the user to entere credit card details | PASSED ✅  |
| T5 | User submits a transaction request, without adding card details. | The request is rejected and becomes with a prompt to fill the fields. | PASSED ✅ | The tranaction design was not functioning and failing to show a succesful or unsuccussfail action|
| T6 | User entering card details for transaction. | The transaction passes, and becomes visible in the bank simulator page. |  PASSED ✅ | 
| T7 | User views order in the "my orders" page | application shows all orders and order status on the "my orders" page | FAILED ❌  |
| T8 | User can log out | redirects them to home page in annonymous mode | PASSED ✅   |
# Diagrams
