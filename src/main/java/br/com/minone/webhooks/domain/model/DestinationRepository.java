package br.com.minone.webhooks.domain.model;

import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository {

    void registerDestination(Destination destination);

    void updateDestination(Destination destination);

    void deleteDestination(DestinationId destinationId);

    Destination loadDestination(DestinationId destinationId);
}
