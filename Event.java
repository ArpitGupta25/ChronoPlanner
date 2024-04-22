import java.time.LocalDateTime;

public class Event {
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Event(String title, LocalDateTime startTime, LocalDateTime endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Event: " + title + "\nStart Time: " + startTime + "\nEnd Time: " + endTime + "\n";
    }
}
