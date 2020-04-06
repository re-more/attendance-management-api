package remore.api.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class App extends Handler implements RequestStreamHandler {

    private InputObject parseInputStream(InputStream inputStream, Context context) throws IOException {
        // input
        ByteArrayOutputStream inputBuf = new ByteArrayOutputStream();
        while (true) {
            int c = inputStream.read();
            if (c == -1) {
                break;
            }
            inputBuf.write(c);
        }
        byte[] inputJson = inputBuf.toByteArray();
        context.getLogger().log(new String(inputJson, StandardCharsets.UTF_8));

        return mapper.readValue(inputJson, InputObject.class);
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        InputObject input = parseInputStream(inputStream, context);
        OutputObject output = handle(input, context);
        context.getLogger().log(mapper.writeValueAsString(output));
        outputStream.write(mapper.writeValueAsBytes(output));
    }
}
