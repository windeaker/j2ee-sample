package cloud.gateway.gateway9527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/28
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudGatewayGateWay9527Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayGateWay9527Bootstrap.class,args);
    }

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder){

        return locatorBuilder.routes().route( "baidu_forward",new Function<PredicateSpec, Route.AsyncBuilder>() {
            @Override
            public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
                return predicateSpec.path("/baidu").uri("https://www.baidu.com").predicate(new Predicate<ServerWebExchange>() {
                    @Override
                    public boolean test(ServerWebExchange serverWebExchange) {
                        return false;
                    }
                });
            }
        }).build();

    }
}
