package remore.api.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Handler {

    protected final ObjectMapper mapper;

    protected Handler() {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    protected OutputObject handle(InputObject input, Context context) throws IOException {
        Result result = new Result();
        result.setId(input.getId());
        result.setUid(input.getUid());
        result.setDate("2020-03-31H00:00:00");
        result.setAction(input.getAction());
        result.setMemo(input.getMemo());
        OutputObject output = new OutputObject();
        output.setStatusCode(200);
        output.setBody(mapper.writeValueAsString(result));
        return output;
    }
}
