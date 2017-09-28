package nl.gerimedica.axoniqhack.gmhack.commands;

import lombok.extern.slf4j.Slf4j;
import nl.gerimedica.axoniqhack.gmhack.events.CallReportedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
@Slf4j
public class IncidentSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    void on(final CallReportedEvent callReportedEvent) {

    }
}
