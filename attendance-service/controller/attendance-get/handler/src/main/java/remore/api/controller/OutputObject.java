package remore.api.controller;

import java.io.Serializable;

public class OutputObject implements Serializable {

    private int statusCode = 500;
    private String body = "";

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
