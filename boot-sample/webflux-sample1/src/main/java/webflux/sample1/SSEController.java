package webflux.sample1;

import io.netty.util.internal.ThreadLocalRandom;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Function;

@RestController
@RequestMapping("/sse")
public class SSEController {
    @GetMapping("/random")
    public Flux<ServerSentEvent<Integer>> random() {
        return Flux.interval(Duration.ofSeconds(1)).map(new Function<Long, ServerSentEvent<Integer>>() {
            @Override
            public ServerSentEvent<Integer> apply(Long aLong) {
                return ServerSentEvent.<Integer>builder()
                        .event("random")//事件名称
                        .id(aLong.toString())
                        .data(aLong.intValue())
                        .retry(Duration.ofMillis(100))//客户端断开连接后，再次连接服务器的间隔。
                        .build();
            }
        });
    }

    @GetMapping(value = "/sequence")
    public Flux<String> sequence() {
        return Flux.interval(Duration.ofSeconds(1)).map(new Function<Long, String>() {
            @Override
            public String apply(Long aLong) {
                return "->" + aLong;
            }
        });
    }
}
