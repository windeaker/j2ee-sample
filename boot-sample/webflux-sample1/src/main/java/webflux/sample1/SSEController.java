package webflux.sample1;

import io.netty.util.internal.ThreadLocalRandom;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/sse")
public class SSEController {
    @GetMapping("/random")
    public Flux<ServerSentEvent<Integer>> random() {
        return Flux.interval(Duration.ofSeconds(1)) // 1
                .map(seq -> {
                            return ServerSentEvent.<Integer>builder() // 2
                                    .event("random")
                                    .id(seq.toString())
                                    .data(ThreadLocalRandom.current().nextInt())
                                    .build();
                        }
                );
    }
}
