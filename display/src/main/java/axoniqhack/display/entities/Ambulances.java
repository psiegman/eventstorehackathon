package axoniqhack.display.entities;

import javafx.scene.Node;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Listens to events and updates the display
 */
@Component
public class Ambulances {

    private class Ambulance {


        private class Location {
            public final int x;
            public final int y;

            private Location(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        private final String id;
        private final Location location;
        private final String name;

        private Ambulance(String id, Location location, String name) {
            this.id = id;
            this.location = location;
            this.name = name;
        }

    }

    private final ConcurrentMap<String, Ambulance> incidents = new ConcurrentHashMap<>();

    public void drawAmbulances() {
        incidents.forEach( (key, value) -> drawAmbulance(value));
    }

    private void drawAmbulance(Ambulance value) {

    }

//    @EventHandler
//    public void on(DispatchEvent event) {
//
//    }

}
