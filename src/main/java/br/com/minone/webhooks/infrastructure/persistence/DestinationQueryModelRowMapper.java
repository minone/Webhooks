package br.com.minone.webhooks.infrastructure.persistence;

import br.com.minone.webhooks.query.model.DestinationQueryModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DestinationQueryModelRowMapper implements RowMapper<DestinationQueryModel> {

    @Override
    public DestinationQueryModel mapRow(ResultSet resultSet, int i) throws SQLException {
        String destinationId = resultSet.getString("dest_id_destination");

        String destinationUrl = resultSet.getString("dest_tx_url");
        
        String secret = resultSet.getString("dest_tx_secret");

        return new DestinationQueryModel(destinationId, destinationUrl, secret);
    }
}
