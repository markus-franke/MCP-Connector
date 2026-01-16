/*
 * (c) Copyright 2025 SQL Projekt AG. All rights reserved.
 */

package io.transconnect.connector.mcp;

import io.transconnect.connector.api.Context;
import io.transconnect.connector.api.consumer.ConsumerConnection;
import io.transconnect.connector.api.consumer.ConsumerConnector;
import io.transconnect.connector.api.consumer.ConsumerConnectorDescriptor;
import io.transconnect.connector.api.extension.Connector;
import io.transconnect.connector.api.extension.Extension;
import io.transconnect.connector.extension.jaxb.JaxbExtension;
import io.transconnect.connector.extension.yamldescriptor.ConnectorDescriptionUtils;

@Connector(extensions = {@Extension(JaxbExtension.class)})
public class McpClientConnector implements ConsumerConnector {
    private ConsumerConnectorDescriptor description;

    @Override
    public ConsumerConnection createConnection(Context context) {
        return new McpClientConnection(context);
    }

    @Override
    public ConsumerConnectorDescriptor getDescription() {
        if (description == null) {
            description = ConnectorDescriptionUtils.createConsumerDescriptionFromYaml(
                    getClass().getResourceAsStream("/McpClientConnector.yaml"));
        }
        return description;
    }
}
