package ank.reactivespring.web.handlers

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

@Service
class ReactiveHandler {

    fun handle(request: ServerRequest): Mono<ServerResponse> {
        return Mono.from(blocking())
                .flatMap {
                    ServerResponse.ok().bodyValue(it)
                }
    }

    fun blocking(): Mono<String> {
        return Mono.just("hello")
                .doOnNext { Thread.sleep(4000) }
                .subscribeOn(Schedulers.elastic())
    }
}