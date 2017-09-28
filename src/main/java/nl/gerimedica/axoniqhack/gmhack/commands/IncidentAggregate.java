package nl.gerimedica.axoniqhack.gmhack.commands;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class IncidentAggregate {

    @AggregateIdentifier
    private String id;

    // needed otherwise Spring cannot wire: No qualifying bean of type 'com.com.example.command.CreateBankAccountCommand'
    public IncidentAggregate() {
        log.info("creating aggregate instance");
    }


}
