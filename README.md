# TodoItems List

An Android exercise for developers teaching how to play around with RecyclerView and Adapter

## Background:

In this project, we are creating a TODO list app.
The user can insert TodoItems, mark them as DONE or IN-PROGRESS, and delete them.

The exact SPECS can be found at file `MainActivity.java`.

*NOTICE:*
The app implementation is extracted into logic and UI:

Pure-logic should be implemented at `TodoItemsHolderImpl.java`.

UI should be implemented at `MainActivity.java`.  

## To fulfill this exercise:

Take a look at the following files, read all of them, and make sure you understand them before starting to write any code:
* `TodoItemsHolder.java` (interface)
* `TodoItemsHolderImpl.java` (default implementation of the interface)
* `TodoItem` (data class representing a TODO item)
* `MainActivity.java` (screen)

After you understand them, go ahead and implement the needed SPECS as defined in `MainActivity`.

> 🛈 **NOTICE:** \
> You might need to modify classes, add fields, change methods etc etc.  
> Don't be afraid, it's completely ok to modify existing code.

## Tests:

*Logic tests:*
You are expected to add unit & flow tests to `TodoItemsHolderImplTest.java`.
Read the entire file and then implement the TODOs in that file. 

*UI tests:*
You are expected to add a few tests to `MainActivityTest.java`.
Read the entire file and then implement the TODOs in that file.

## Remarks:

Tests implementations should come *last*. Start with logic tests and then continue to UI tests. 
My request to write tests is only an added-value for you to sharp your testing skills.
If you see that the exercise takes too much time to implement even *without* writing the tests,
please **LET ME KNOW** and I will drop the request for tests from the exercise submission.

---
Q:
We didn't define any UX flow to let users edit a descrption on an existing TODO item.
Which UX flow will you define?
In your response notice the following:
1. how easy is it for users to figure out this flow in their first usage? (for example, a glowing button is more discoverable then a swipe-left gesture)
2. how hard to implement will your solution be?
3. how consistent is this flow with regular "edit" flows in the Android world?
A:
I would add an edit button with a pencil
The implentaion is pretty easy, use a built in button.
It is also pretty regular to Android users, so easy for me and easy for them:)

"I pledge the highest level of ethical principles in support of academic excellence.  I ensure that all of my work reflects my own abilities and not those of someone else."
✨ Good luck! ✨