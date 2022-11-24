package com.bruce.springboot.lab47.server.autoconfig;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author Bruce
 */
@Configuration
@EnableConfigurationProperties(BruceServerProperties.class)
public class BruceServerAutoConfiguration {

    private final Logger logger = LoggerFactory.getLogger(BruceServerAutoConfiguration.class);

    @Bean
    @ConditionalOnClass(HttpServer.class)
    public HttpServer httpServer(BruceServerProperties bruceServerProperties) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(bruceServerProperties.getPort()), 0);
        httpServer.start();
        logger.info("[HTTPServer] 【启动服务器成功，端口为：{}】", bruceServerProperties.getPort());

        return httpServer;
    }
}
