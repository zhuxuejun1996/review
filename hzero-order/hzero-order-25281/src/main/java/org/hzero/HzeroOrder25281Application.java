package org.hzero;

import org.hzero.core.jackson.annotation.EnableObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;

@ComponentScan(value = {
        "org.hzero.api",
        "org.hzero.app",
        "org.hzero.config",
        "org.hzero.domain",
        "org.hzero.infra",
})
@EnableChoerodonResourceServer  //开启资源认证 关闭Security 安全认证
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableObjectMapper

@EnableDiscoveryClient
@SpringBootApplication
public class HzeroOrder25281Application {

    public static void main(String[] args) {
        SpringApplication.run(HzeroOrder25281Application.class, args);
    }

}
