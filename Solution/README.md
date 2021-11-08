### Conditionally deleting old tasks

**Branch name:** dynamodbdeleteiterators-prework

Expected time required: 10 min

In the previous activity, you worked with a table that keeps track of different tasks that need to be completed at work to
assist in increasing productivity. In the reading, we discussed keeping track of active vs. inactive tasks instead of 
deleting them, but it's the end of the year and you want to be able to clean up tasks that have been around for a while.
To prevent someone from deleting other tasks, however, you want to set-up a condition that only deletes a task if it was
completed in 2016, which is the oldest tasks you have left on the tracker.

The `TaskTracker` table looks the same as it did in the previous activity:

* `job_id` : partition key—unique `String` identifier for each job
* `completed_by` : name of the person who completed the job
* `hours_taken` : the number of hours it took it complete the job
* `year_completed` : the year the task was completed

Rewrite the `deleteTask()` method in the `TaskDAO` class to implement a condition that only deletes a task if 
`year_completed` = `2016`. The `Task` class is already written and annotated for you and the `TaskDAO` class also includes
a `getTask()` and `saveTask()` method for you. 

The unit tests in `TaskDAOTest` are set-up with a mock database so that you can test your methods offline. The `main()` 
method is set-up in `TaskApp` so that you can connect to the real TaskTracker table and test your methods that way.

When you've finished writing your code and testing, make sure `rde workflow run dynamodbdeleteiterators-prework-tasktracker2`
is passing and push.

HINTS:
* [The attribute name I'm passing in as the key for the HashMap isn't working properly.](./hints/hint-01.md)
* [The AttributeValue I'm passing in to the HashMap is looking for a String, but year_completed is an int.](./hints/hint-02.md)
