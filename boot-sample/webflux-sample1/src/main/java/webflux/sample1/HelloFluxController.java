package webflux.sample1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloFluxController {

    @GetMapping("/sayHelloFlux")
    public Flux<String> sayHelloFlux(){
        return Flux.just("sayHelloFlux");
    }

    @GetMapping("/sayHelloMono")
    public Mono<String> sayHelloMono(){
        return Mono.just("sayHelloMono");
    }
}

