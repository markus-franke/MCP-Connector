/*
 * (c) Copyright 2025 SQL Projekt AG. All rights reserved.
 */

package io.transconnect.connector.mcp;

/**
 * Enum representing the different transport methods available for the MCP client connection.
 */
public enum Transport {
    STDIO,
    HTTP_SSE,
    STREAMABLE_HTTP
}
