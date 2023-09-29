package com.samsung.healthcare.cloudstorageservice.adapter.web.router

import com.samsung.healthcare.cloudstorageservice.adapter.web.filter.IdTokenFilterFunction
import com.samsung.healthcare.cloudstorageservice.adapter.web.handler.DownloadObjectHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class ParticipantDownloadObjectRouter {
    @Bean
    fun routeParticipantDownloadObject(
        handler: DownloadObjectHandler,
        idTokenFilterFunction: IdTokenFilterFunction,
    ): RouterFunction<ServerResponse> =
        RouterFunctions.route()
            .GET(
                PARTICIPANT_DOWNLOAD_OBJECT_PATH,
                handler::participantDownload,
            )
            .filter(idTokenFilterFunction)
            .build()
}
