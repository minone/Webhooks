package br.com.minone.webhooks.domain.model;

import java.util.UUID;

public class DestinationId {

    private UUID id;

    public DestinationId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
