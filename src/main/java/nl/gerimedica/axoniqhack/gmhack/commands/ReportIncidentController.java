package nl.gerimedica.axoniqhack.gmhack.commands;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import nl.gerimedica.axoniqhack.gmhack.domain.GeoLocation;
import nl.gerimedica.axoniqhack.gmhack.domain.Severity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportIncidentController {

    private final CommandGateway commandGateway;

    public ReportIncidentController(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/report-incident")
    public ResponseEntity<BankAccountResource> create(@RequestBody Incident request) {
        String id = UUID.randomUUID().toString();
        commandGateway.sendAndWait(ReportIncidentCommand.builder()

                .build());

        BankAccountResource bankAccountResource = new BankAccountResource(id);
        return new ResponseEntity<>(bankAccountResource, HttpStatus.CREATED);
    }

    @Data
    public class Incident {
        final String reporter;
        final LocalDateTime localDateTime;
        final Severity severity;
        final String comment;
        final GeoLocation crimeScene;
    }
}
