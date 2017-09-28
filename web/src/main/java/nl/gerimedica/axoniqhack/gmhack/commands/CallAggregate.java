package nl.gerimedica.axoniqhack.gmhack.commands;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;
import nl.gerimedica.axoniqhack.gmhack.GeoLocationService;
import nl.gerimedica.axoniqhack.gmhack.events.IncidentReportedEvent;
import nl.gerimedica.axoniqhack.gmhack.events.domain.GeoLocation;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class CallAggregate {

    @AggregateIdentifier
    private String id;

    private String phoneNumber;
    private GeoLocation geoLocation;
    private LocalDateTime localDateTime;
    private String comment;

    public CallAggregate() {
        log.info("creating aggregate instance");
    }

    @CommandHandler
    public void on(CallCommand command) {
        log.info("received command {}", command);
        apply(IncidentReportedEvent.builder().id(command.getUuid()).comment(command.getComment()).geoLocation(command.getGeoLocation()).phoneNumber(command.getPhoneNumber()).build());
    }

    @EventSourcingHandler
    public void on(IncidentReportedEvent event) {
        log.info("event sourcing handler handling event {}", event);
        this.id = event.getId();
        this.comment = event.getComment();
        this.geoLocation = event.getGeoLocation();
        this.localDateTime = event.getLocalDateTime();
        this.phoneNumber = event.getPhoneNumber();
    }
}
