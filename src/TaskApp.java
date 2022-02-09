
import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class TaskApp {

    /**
     * Test your methods using a real database connection. Should return 'null' and then a
     * ConditionalCheckFailedException for the 2nd example, which prints out 'JO1154'.
     * @param args main method values
     */
    public static void main(String[] args) {
        //GIVEN (1st example)
        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        Task taskNull = new Task();
        String partitionKeyNull = "JO9457";
        taskNull.setJobId(partitionKeyNull);

        //WHEN (1st example)
        TaskDAO taskDAO = new TaskDAO(mapper);
        taskDAO.deleteTask(taskNull);

        Task deletedTask = taskDAO.getTask(partitionKeyNull);

        //THEN (1st example)
        System.out.println("null value: " + deletedTask);

        //GIVEN (2nd example)
        Task taskValue = new Task();
        String partitionKeyValue = "JO1154";
        taskValue.setJobId(partitionKeyValue);

        //WHEN (2nd example)
        taskDAO.deleteTask(taskValue);

        Task notDeletedTask = taskDAO.getTask(partitionKeyValue);

        //THEN (2nd example)
        System.out.println("id value JO1154: " + notDeletedTask.getJobId());
    }
}
