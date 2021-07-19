package osu.events;

import java.util.ArrayList;
import java.util.Arrays;

public class Events {
    private ArrayList<Event> events = new ArrayList<>();

    public Events() {
        this.events = new ArrayList<>();
    }

    public Events(Event[] events) {
        this((ArrayList<Event>) Arrays.asList(events));
    }

    public Events(ArrayList<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[Events]\n");
        if(this.events.size() != 0) {
            for(Event event: this.events) {
                sb.append(event.toString()+"\n");
            }
        }
        return sb.toString();
    }
}
