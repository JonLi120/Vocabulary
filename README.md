## Vocabulary Certification Exam
Vocabulary is an application that helps people study a specific topic. This application is not yet feature complete. The work was started, but the previous developer was pulled off to work on another project, and we need to ship this application as soon as possible!
### Exam Download
Download project zip file of the initial project and import the project into Android Studio. Sample vocabularies data is bundled with the application as JSON data as ares/raw/ resource. The following is an example of the data model:
`   {
     "word: "malfunction",
     "means": "fail to work properly"
   }
### Project Requirements
The following tools and SDK components are required to import and complete this project:
•	Android Studio 2.1+
•	Android SDK Platform-tools 24+
•	Android SDK Tools 25+
•	SDK Build Tools 24.0.0
•	Android Support Repository 34+
•	Android SDK Platform 24
Your submission should follow Android UI best practices. Don't transfer data to disk or to the network on the main thread. Abstract strings and dimensions into resources whenever possible. Never lock activity orientations, and preserve the user experience between rotations.
### Application Design Requirements
The Vocabulary project management and design teams have provided you with the following requirements and UI mock-ups. Use these as a guide for implementing the required application features.
The colors our design team have chosen for Vocabulary are as follows:
R.color.colorPrimary: #FFAB91
R.color.colorPrimaryDark: #FF7043
R.color.colorAccent: #FFB74D 

### Functional Requirements
As a user, I should be able to:
•	View a list of vocabularies.
•	Tap a vocabulary to launch a new screen and see the meaning of the word.
•	Add new vocabulary to the vocabulary list.
•	Schedule a once-daily reminder to study.
•	Add a widget to my home screen that displays a random vocabulary.
•	Tap the home screen widget to open the app and view the means to the displayed vocabulary.
### Main Screen
![](http://litotom.com/wp-content/uploads/2016/11/C1-1.png)

•	Add Floating Action Button
- Color: R.color.colorAccent
- Icon: R.drawable.ic_add
- Navigates to Add Vocabulary Screen
 •	Options Menu
	Settings
    - Tiitle: R.string.settings
    - Display in overflow; no icon
    - Navigates to Settings Screen

•	Question
- Large Text Appearance
- Background Color:R.color.colorPrimary
- Text Color: R.color.textColor
- Layout Gravity: center

### Answer Screen
![](http://litotom.com/wp-content/uploads/2016/11/C2-1.png)

•	Question View
- Large Text Appearance
- Text Size: 40sp

•	Equals View
- Text: R.string.explain
- Text Size: 40sp

•	Answer View
- Medium Text Appearance
- Background Color:R.color.meaningBackground
- Text Size: 40sp

•	Up Navigation Button
•	Navigates to Main Screen
### Add Vocabulary Screen
![](http://litotom.com/wp-content/uploads/2016/11/C3-1.png)

•	Question Edit Text
- Hint: R.string.form_word

•	Answer Edit Text
- Hint: R.string.form_means

•	Add Button
- Text: R.string.add
- Text Color: R.color.textColor
- If no word provided, show an Error
•	Text:R.string.error_input_word
- If no means provided, show an Error
•	Text:R.string.error_input_means
- If form is not completed, display a snackbar
•	Text: R.string.complete_form

•	Up Navigation Button
- Navigates to Main Screen
### Settings Screen
![](http://litotom.com/wp-content/uploads/2016/11/C5.png)

•	Toggle setting to turn on/turn off practice reminders
•	A change in either setting should immediately reschedule or cancel the reminder alert
•	Up Navigation Button
- Navigates to Main Screen
### Notifications
![](http://litotom.com/wp-content/uploads/2016/11/C6.png)
•	Reminder Notification
- Title: R.string.time_to_practice
- Text:R.string.it_is_time_to_practice 
- Icon:R.drawable.sym_action_email

### Feature Tasks
To complete the application’s feature set, you need to complete the following tasks based on the application architecture and design mock-ups provided above:
1.	Implement the query method of VocabularyProvider to return:
•	Selected vocabularies (using selection criteria) via
content://com.google.developer.vocabulary/vocabulary
•	A single vocabulary by ID via
content://com.google.developer.vocabulary/vocabulary/{id}
2.	Implement the insert method of VocabularyProvider to accept new vocabulary data via
content://com.google.developer.vocabulary/vocabulary.
3.	When the database is created, populate the database with the contents of the res/raw/vocabularies.json data model.
4.	Create a new list item layout for a vocabulary item per the Main Screen design.
5.	Bind a database query for all vocabularies to the main RecyclerView in a vertical list.
•	TIP: Your adapter must extend AbstractRecyclerAdapter and implement the required methods.
6.	Add functionality to listen for click events on a RecyclerView list item.
7.	Create a new activity layout per the Meaning Screen design.
8.	Create an MeaningActivity that is launched when a vocabulary is selected and displays the means to the selected vocabulary.
9.	Create the action bar menu that launches the SettingsActivity per the Main Screen design.
10.	Implement the notification that reminds users to practice inside theNotificationService, using the resources defined in the Notifications design.

### Testing Tasks
Now that you have finished implementing the application’s required features, write a test to help us ensure that regressions don’t creep into the code later on.
1. 	Write a UI test to validate that clicking the Add floating action button results in displaying the AddActivity.

### Debugging Tasks
QA has reported a number of errors discovered in the previous developer’s code that we would like you to address.
1.	The colors used in the app don’t match our branding. Change them to the colors outlined in the design document.
2.	I noticed that the app adds new vocabularies to the database on the main thread. Utilize the provided service class to perform the database insert.
3.	When adding new vocabulary, the word and means are reversed. 
4.	The home screen widget is showing a greeting. Shouldn’t it show a random vocabulary?
5.	I turned on the reminder to practice, but I never get notifications.

