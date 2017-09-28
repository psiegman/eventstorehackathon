package nl.gerimedica.axoniqhack.gmhack.commands;

import lombok.Data;
import nl.gerimedica.axoniqhack.gmhack.domain.GeoLocation;
import nl.gerimedica.axoniqhack.gmhack.events.domain.Severity;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class ReportIncidentController {

	private final CommandGateway commandGateway;

	public ReportIncidentController(final CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping("/report-call")
	public ResponseEntity create(@RequestBody Call request) {
		String id = UUID.randomUUID().toString();
		commandGateway.sendAndWait(CallCommand.builder()
				.uuid(id)
				.comment(request.getComment())
				.geoLocation(request.getCrimeScene())
				.localDateTime(request.getLocalDateTime())
				.phoneNumber(request.getPhoneNumber())
				.build());

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Data
	public class Call {
		final String reporter;
		final LocalDateTime localDateTime;
		final Severity severity;
		final String comment;
		final GeoLocation crimeScene;
		final String phoneNumber;
	}
}

