Please run the app using the tomcat server or run from the main method. 
Run browse and open the link: http://localhost:8080/swagger-ui.html#/
You will see the swagger UI to test the API.
Also please refer to application properties


Tools to be used
•	Java 8-10-11
•	Spring or SpringBoot
•	Hibernate
•	MySQL Dialect

Description
The client needs an API to manage and sell his products. The product has a name, a description, a category, the quantity in the inventory, CreatedOn, CreatedBy, ModifiedOn and Modified By. The products belong to one of the following categories: Woodworking, Tools, Garden, Automotive, Bricolage.
There are two types of user: Customer and Employee.
The employee can add/edit/remove the products, the customer can view a list of products and order them one at a time (no cart needed).
There will be no login functionality but with each request will contain a UserId that will be used to determine the permissions.
The quantity cannot be a negative number. 
We need to have:
•	A swagger interface to test the API
•	The ability to create automatically the DB structure on an empty DB
•	A seed function that will create two employee and three customer default users named emp1, emp2, cust1, cust2, cust3 and two default products for each category.
