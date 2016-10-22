package br.com.minone.webhooks.domain.model;

import br.com.minone.webhooks.exception.BusinessException;
import br.com.minone.webhooks.util.StringUtils;

public class Destination {

    private DestinationId id;

    private String URL;

    public Destination(DestinationId id, String URL) {
        this.id = id;
        this.URL = URL;
    }

    public DestinationId getId() {
        return id;
    }

    public String getURL() {
        return URL;
    }
}
