package remore.api.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Handler {

    protected final ObjectMapper mapper;

    protected Handler() {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private Map<String, String> corsHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Access-Control-Allow-Origin", "*");
        headers.put("Content-Type", "application/json");
        return headers;
    }

    protected OutputObject handle(InputObject input, Context context) throws IOException {
        Result result = new Result();
        result.setId("1");
        result.setUid("test@acme.org");
        result.setDate("2020-03-29T09:12:53.523Z");
        result.setAction("ATTEND");
        result.setMemo("memo");
        OutputObject output = new OutputObject();
        output.setStatusCode(200);
        output.setHeaders(corsHeaders());
        output.setBody(mapper.writeValueAsString(result));
        return output;
    }
}
