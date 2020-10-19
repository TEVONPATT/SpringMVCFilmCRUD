# Spring MVC Film C.R.U.D. Project
### Collaborative Project - Christina, Tevon, & Ryan

## Project Overview
This full web-based program using Spring MVC allows a user to access a database of films and modify it as the user pleases.

## Lessons Used
* Handling requests
* Exceptions
* OOP
* DAO implementation
* JDBC
* Accessing SQL in Java
* Controller
* Collaboration - first group project!

## Technologies Used
* Spring Tool Suite
* Maven projects
* CSS/HTML
* JSP files
* SQL
* Java
* GitHub
* MAMP
* Gradle

## How to Run
1. The user is greeted by the homepage, with options to go to three different pages depending on the action the user wishes to choose. The page is displayed with formatting and CSS consistent on every page.
2. The user can select to view a film in the database by film ID. Once retrieved, the user can see all information about this film.
3. The user can delete a film that they have created from the database. This is done by selecting the radio button "yes" for delete film.
4. The user can add a new film by being directed to a page with a form to fill out for all the details of the film. Once filled out and submitted, the film is now in the database and they can search for this film.
5. The user can update information about any film in the database. After selecting the film they wish to edit, they are brought to a form to enter the edits. Once submitted, the new information is displayed whenever they try to retrieve data for the film. It is updated in the SQL database.
6. There are homepage/back buttons to add functionality to the used when navigating through the pages.

## Lesson Takeaways
1. The Database Accessor (DAO) class works directly with the database in order to make film objects. The DAO has a method to find films by the ID the user inputs. The other classes implement displaying the data that corresponds with the ID. The SQL statements are in the DAO class.
2. SQL statements such as INSERT. DELETE and UPDATE were used to allow the user to interact with the database.
3. The controller class (FilmController.java) takes database information from the DAO and passes it to the corresponding JSP files in order for the information to be displayed.
4. JSP files were utilized in this program because they are dynamic and can display the html forms that were needed for user input and also can display information from java classes.
5. Simple CSS was added to the JSP or HTML files so that they displayed on the webpage.
6. Teamwork- this is the first collaborative group project and it definitely was learned that it is important to communicate. While some roles were split between us, other roles were worked on together through pair programming. We were able to work together and pull and push projects to GitHub in order to access changes the other teammates had worked on. Overall, group projects allow lots of different sets of eyes on an issue and it was a great way to see how the problem solving process varies by every individual!
