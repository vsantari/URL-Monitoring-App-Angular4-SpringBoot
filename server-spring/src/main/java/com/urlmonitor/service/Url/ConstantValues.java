package com.urlmonitor.service.Url;

public class ConstantValues {
    public static final String COMPONENT_STATUS_GREEN = "Component Status: GREEN";
    public static final String NO_COMPONENT_STATUS_GREEN = "No \"Component Status: GREEN\" strings from URL content";
    public static final int CONNECTION_TIMEOUT = 3000;
    public static final long RESPONSE_TIME_THRESHOLD = 500;
    public static final long RETRY_DELAY_MS = 1000;

    public static final String MAP_STATUS_KEY = "status";
    public static final String MAP_TIMESTAMP_KEY = "timestamp";
    public static final String MAP_URL_KEY = "url";
    public static final String MAP_RESPONSE_TIME_KEY = "responsetime";
    public static final String MAP_RETRY_KEY = "retry";
    public static final String MAP_ERROR_KEY = "error";

    private ConstantValues() {}
}
