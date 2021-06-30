package com.example;

import com.example.model.Greeting;
import com.example.model.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class Hello implements Function<Mono<User>, Mono<Greeting>> {

    public Mono<Greeting> apply(Mono<User> mono) {
        return mono.map(user -> new Greeting("Hello I guess, at 2:13, everything should be working, about to try and make disappear " + user.getName() + "!\n"));
    }
}