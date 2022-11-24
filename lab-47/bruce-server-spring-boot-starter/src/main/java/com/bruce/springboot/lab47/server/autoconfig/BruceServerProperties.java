package com.bruce.springboot.lab47.server.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Bruce
 */
@ConfigurationProperties(prefix = "bruce.server")
public class BruceServerProperties {

    /**
     * 默认端口
     */
    private static final Integer DEFAULT_PORT = 8000;

    /**
     * 端口
     */
    private Integer port = DEFAULT_PORT;

    public static Integer getDefaultPort() {
        return DEFAULT_PORT;
    }

    public Integer getPort() {
        return port;
    }

    public BruceServerProperties setPort(Integer port) {
        this.port = port;
        return this;
    }
}
