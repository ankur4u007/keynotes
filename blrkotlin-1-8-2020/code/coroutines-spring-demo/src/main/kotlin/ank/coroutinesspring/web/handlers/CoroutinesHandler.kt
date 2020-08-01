package ank.coroutinesspring.web.handlers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Service
class CoroutinesHandler {

    suspend fun handle(request: ServerRequest): ServerResponse {
        return ServerResponse.ok().bodyValueAndAwait(blocking())
    }

    suspend fun blocking(): String {
        return withContext(Dispatchers.IO) {
            Thread.sleep(4000)
            "hello"
        }
    }
}