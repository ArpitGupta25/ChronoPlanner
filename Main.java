
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        ChronoPlanner planner = new ChronoPlanner();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ChronoPlanner!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Event");
            System.out.println("2. Display Events");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter event title: ");
                    String title = scanner.nextLine();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

System.out.println("Enter start time (YYYY-MM-DD HH:MM): ");
LocalDateTime startTime = LocalDateTime.parse(scanner.nextLine().trim(), formatter);

System.out.println("Enter end time (YYYY-MM-DD HH:MM): ");
LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine().trim(), formatter);


                    if (startTime.equals(endTime)) {
                        System.out.println("Error: Start time and end time cannot be the same. Please enter valid times.");
                        break;
                    }

                    if (isOverlapping(planner, startTime, endTime)) {
                        System.out.println("Error: Event time overlaps with existing event. Please enter a different time.");
                        break;
                    }

                    Event event = new Event(title, startTime, endTime);
                    planner.addEvent(event);
                    System.out.println("Event added successfully!");
                    break;
                case 2:
                    planner.displayEvents();
                    break;
                case 3:
                    System.out.println("Exiting ChronoPlanner. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Check if the new event overlaps with any existing events in the planner
    private static boolean isOverlapping(ChronoPlanner planner, LocalDateTime newStartTime, LocalDateTime newEndTime) {
    for (Event event : planner.getEvents()) {
        LocalDateTime startTime = event.getStartTime();
        LocalDateTime endTime = event.getEndTime();
        if ((newStartTime.isAfter(startTime) && newStartTime.isBefore(endTime)) ||
                (newEndTime.isAfter(startTime) && newEndTime.isBefore(endTime)) ||
                (newStartTime.isBefore(startTime) && newEndTime.isAfter(endTime)) ||
                (newStartTime.equals(startTime) && newEndTime.equals(endTime))) { // New condition
            return true;
        }
    }
    return false;
}

}
