### Project0
Project0 aka "spoofify" is hopefully the start of a longer term project. 
The current implementation (3/16/2022) is a placeholder for when I am able to interface with the Spotify API. This will allow me to retrieve all the data I need without having to rely on third party apps. Currently, users are able to import csv files that have been gotten from Exportify (https://watsonbox.github.io/exportify/) and store them in a database. There is a main database that holds all music, then there is a User Library for each individual user to store their music. This serves as a backup and eventually, when I implement a write to CSV/JSON, the user will be able to export their library and import to any other cloud music streaming service. You can store libraries for multiple users and view the libraries for each.

### Details
### Project 0
A Scala CLI (Command Line Interface) application.  Data should be parsed from a CSV OR JSON file and persisted to  MySQL. The functionality of the application beyond that is up to you, but here are a few suggestions:
- journal app
- banking app
- business management system
- simple text-based game
- productivity tool
- ...?

## Application Requirements
- Your application must be able to read JSON or CSV files, and store the data contained within those files in a database (really you should have a JDBC that connects to atleast 3 tables in your database, and takes user input)
- Your application should have a CLI where users can interact with the application while it is running
- Include an Entity Relationship Diagram (ERD) with your presentation
- Other than those requirements, the kind of application you have is up to you.

## Tech Stack
- Scala 2.12
  - File I/O
  - Collections
- MySQL
- sbt
- git SCM (+ GitHub)

## Presentation
- 5 minute live demo.  Present the application, not the code.

## Due Date
- Project 0 will be presented Wednesday, March 16/2022 (10 am)

Finishing your MVP (Minimum Viable Product) as early as possible before iterating new features upon the project is highly recommended.  Plan ahead, and be sure to reach out to others when you need guidance (or offer your own to those in need).  You are *REQUIRED* to be able to explain your project functionality and write your own code, but feel free to have in-depth discussions with others.

## Git Help

For this project, we only need basic Git and GitHub usage.  You should do these steps once, to set up:
- Make a Github Account
- Create a repository
- Use the git clone command on your local machine to clone the repository to your local machine

You should run the following commands frequently, while working on your project, in your git repo:
- git status (just to see what has changed)
- git add .
- git commit -m "a message describing the work you've done goes here"
- git push

If you receive an error message that you aren't in a git repo, cd to your cloned git repository on your local machine.
