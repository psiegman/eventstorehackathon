package nl.gerimedica.axoniqhack.gmhack.commands;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;
import nl.gerimedica.axoniqhack.gmhack.GeoLocationService;
import nl.gerimedica.axoniqhack.gmhack.events.IncidentReportedEvent;
import nl.gerimedica.axoniqhack.gmhack.events.IncreaseSeverityEvent;
import nl.gerimedica.axoniqhack.gmhack.events.domain.GeoLocation;
import nl.gerimedica.axoniqhack.gmhack.events.domain.Severity;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class IncidentAggregate {

    @AggregateIdentifier
    private String id;

    private String phoneNumber;
    private GeoLocation geoLocation;
    private LocalDateTime localDateTime;
    private String comment;
    private Severity severity;

    // needed otherwise Spring cannot wire: No qualifying bean of type 'com.com.example.command.CreateBankAccountCommand'
    public IncidentAggregate() {
        log.info("creating aggregate instance");
    }

    @CommandHandler
    public void on(ReportIncidentCommand command) {
        log.info("received command {}", command);
        apply(IncidentReportedEvent.builder().id(command.getUuid()).severity(command.getSeverity()).comment(command.getComment()).geoLocation(command.getGeoLocation()).phoneNumber(command.getPhoneNumber()).build());
    }

    @CommandHandler
    public void on(UpdateIncidentCommand command) {
        log.info("received command {}", command);
        apply(IncreaseSeverityEvent.builder().uuid(command.getUuid()).severity(command.getSeverity()).build());
    }

    @EventSourcingHandler
    public void on(IncidentReportedEvent event) {
        log.info("event sourcing handler handling event {}", event);
        this.id = event.getId();
        this.comment = event.getComment();
        this.geoLocation = event.getGeoLocation();
        this.localDateTime = event.getLocalDateTime();
        this.phoneNumber = event.getPhoneNumber();
        this.severity = event.getSeverity();
    }

    @EventSourcingHandler
    public void on(IncreaseSeverityEvent event){
        this.severity = event.getSeverity();
    }
}
