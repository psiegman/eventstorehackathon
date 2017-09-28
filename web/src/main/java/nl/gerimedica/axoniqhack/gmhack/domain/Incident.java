package nl.gerimedica.axoniqhack.gmhack.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.gerimedica.axoniqhack.gmhack.events.domain.GeoLocation;
import nl.gerimedica.axoniqhack.gmhack.events.domain.Severity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Incident {

    @Id
    @GeneratedValue
    Long id;

    @Embedded
    private GeoLocation geoLocation;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    private String phoneNumber;
    private LocalDateTime start;
    private LocalDate localDate;
    private String comment;
}
