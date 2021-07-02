package com.example;

import com.example.model.Greeting;
import com.example.model.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;
import java.util.function.Function;

@Component
public class Hello implements Function<Mono<User>, Mono<Greeting>> {

    public Mono<Greeting> apply(Mono<User> mono) {
        try {
            return mono.map(user -> new Greeting("Hello I guess, at 2:42, turn and face the strange 7/2 with run from package " + user.getName() + "!\n"));
        
        } catch (FileNotFoundException ffe){
            return mono.map(user -> new Greeting("We had a problem " + user.getName() + "!\n"));
        }
    }
}