package remore.api.controller;

import java.util.Collections;
import java.util.Map;

public class OutputObject {

    private int statusCode = 500;
    private Map<String, String> headers = Collections.emptyMap();
    private String body = "";

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
