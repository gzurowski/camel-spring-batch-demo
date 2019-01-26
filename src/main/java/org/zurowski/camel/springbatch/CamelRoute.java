package org.zurowski.camel.springbatch;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("file:test")
                .log("Received file: '${body.fileName}'")
                .to("spring-batch:importUserJob")
                .log("Finished batch job with status: '${body.status}'");
    }

}
