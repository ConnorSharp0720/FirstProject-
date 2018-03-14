import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.GregorianCalendar;

/**
 * @author CS2334, modified by Stephen Thung
 * @version 2018-02-26
 * Lab 8
 * 
 * Class to simulate a restaurant comparison system. A user is able to place orders at a restaurant and
 * give completion times. A user can also check to see what the next order to be completed is. The system by
 * which the restaurant determines which order to complete next is dependent on the implementation (i.e. which
 * subclass of Restaurant it is).
 */
public class Driver
{
    /**
     * Main method for the Restaurant Comparison system.
     * 
     * @param args command-line arguments [not used]
     */
    public static void main(String[] args)
    {
        // Set up the restaurants to compare:
        GregorianCalendar calendar = new GregorianCalendar();
        StackRestaurant<String> stack = new StackRestaurant<String>(calendar);
        QueueRestaurant<String> queue = new QueueRestaurant<String>(calendar);
        PriorityQueueRestaurant<String> pqueue = new PriorityQueueRestaurant<String>(calendar);
        
        // Set up the user input loop:
        boolean done = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(!done)
        {
            System.out.println("Please choose a restaurant option:");
            System.out.println("\t1. [enter] an order.");
            System.out.println("\t2. [complete] an order.");
            System.out.println("\t3. [check] the next order to be completed.");
            System.out.println("\t4. [quit]");
            
            try
            {
                String input = reader.readLine();
                if (input.equalsIgnoreCase("quit"))
                {
                    done = true;
                }
                else if (input.equalsIgnoreCase("enter"))
                {
                    System.out.println("Please enter an order description and an order time (comma separated) with "
                            + "the following format:");
                    System.out.println("<description>,<time as a long>");
                    String[] entry = reader.readLine().split(",");
                    // Verify that entry matches expected format:
                    if (entry.length != 2)
                    {
                        System.out.println("Please enter an appropriate order!");
                    }
                    else
                    {
                        try
                        {
                            long timeOrdered = Long.parseLong(entry[1]);
                        
                            Date timeOrderedDate = new Date(timeOrdered);
                            Order<String> order = new Order<String>(entry[0], timeOrderedDate);
                            stack.addOrder(order);
                            queue.addOrder(order);
                            pqueue.addOrder(order);
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Please enter an appropriate order!");
                        }
                    }
                }
                else if (input.equalsIgnoreCase("complete"))
                {
                    System.out.println("Please enter the time of completion as a long:");
                    // Verify that entry matches expected format:
                    try
                    {
                        long timeCompleted = Long.parseLong(reader.readLine());
                        Date timeCompletedDate = new Date(timeCompleted);
                        System.out.println("The completion for the stack restaurant:\n" +
                                stack.completeOrder(timeCompletedDate) + "\n");
                        System.out.println("The completion for the queue restaurant:\n" +
                                queue.completeOrder(timeCompletedDate) + "\n");
                        System.out.println("The completion for the priority queue restaurant:\n" +
                                pqueue.completeOrder(timeCompletedDate) + "\n");
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Please enter an appropriate completion time!");
                    }
                }
                else if (input.equalsIgnoreCase("check"))
                {
                    System.out.println("For the stack restaurant: ");
                    System.out.println(stack.checkTopOrder().toString());
                    System.out.println("For the queue restaurant: ");
                    System.out.println(queue.checkTopOrder().toString());
                    System.out.println("For the priority queue restaurant: ");
                    System.out.println(pqueue.checkTopOrder().toString());
                }
            }
            catch (IOException e)
            {
                // Something bad has happened, quit the program:
                e.printStackTrace();
                done = true;
            }
            catch (EmptyStackException e)
            {
                System.out.println("There were not enough orders in the stack. Try adding more.");
            }
        }
    }
}
