package nl.gerimedica.axoniqhack.gmhack.commands;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import nl.gerimedica.axoniqhack.gmhack.domain.Incident;
import nl.gerimedica.axoniqhack.gmhack.events.CallReportedEvent;
import nl.gerimedica.axoniqhack.gmhack.events.IncidentResolvedEvent;
import nl.gerimedica.axoniqhack.gmhack.events.domain.Severity;
import nl.gerimedica.axoniqhack.gmhack.repository.IncidentRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.saga.EndSaga;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
@Slf4j
public class IncidentSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @Autowired
    private transient IncidentRepository incidentRepository;

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    void on(final CallReportedEvent event) {
        List<Incident> bygeoLocationAndLocalDate = incidentRepository.findBygeoLocationAndLocalDate(event.getGeoLocation(), event.getLocalDateTime().toLocalDate());

        if (bygeoLocationAndLocalDate != null && !bygeoLocationAndLocalDate.isEmpty()) {

            // map to that incident and increase severity
        } else {
            commandGateway.send(ReportIncidentCommand.builder().comment(event.getComment()).geoLocation(event.getGeoLocation()).localDateTime(event.getLocalDateTime())
                    .phoneNumber(event.getPhoneNumber()).severity(Severity.LOW).build());
        }
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "id")
    void on(IncidentResolvedEvent incidentResolvedEvent) {
        // send a command to put aggragete status on finished
    }
}
