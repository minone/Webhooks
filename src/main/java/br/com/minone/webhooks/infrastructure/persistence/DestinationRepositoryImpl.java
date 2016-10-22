package br.com.minone.webhooks.infrastructure.persistence;

import br.com.minone.webhooks.domain.model.Destination;
import br.com.minone.webhooks.domain.model.DestinationId;
import br.com.minone.webhooks.domain.model.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DestinationRepositoryImpl extends WebhookJdbcSupport
        implements DestinationRepository {

    @Autowired
    public DestinationRepositoryImpl(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public String registerDestination(Destination destination) {
        DestinationId destinationId = destination.getId();

        String url = destination.getURL();

        String insert = "insert into destination(dest_id_destination, dest_tx_url) " +
                "values(?,?)";

        getJdbcTemplate().update(insert, destinationId.getId(), url);

        return destinationId.getId();
    }

    @Override
    public void deleteDestination(DestinationId destinationId) {
        String id = destinationId.getId().toString();

        String delete = "delete from destination where dest_id_destination = ?";

        getJdbcTemplate().update(delete, id);
    }
}
