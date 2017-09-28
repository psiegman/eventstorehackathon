package nl.gerimedica.axoniqhack.gmhack.events;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import nl.gerimedica.axoniqhack.gmhack.events.domain.Severity;

@Data
@AllArgsConstructor
@Builder
public class IncreaseSeverityEvent {

    private String uuid;
    public Severity severity;
}
