import java.util.ArrayList;
import java.util.List;

public class ChronoPlanner {
    private List<Event> events;

    public ChronoPlanner() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void displayEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }
}
