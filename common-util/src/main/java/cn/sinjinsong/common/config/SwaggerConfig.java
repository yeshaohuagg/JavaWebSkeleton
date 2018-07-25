package cn.sinjinsong.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SinjinSong on 2017/4/28.
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        ParameterBuilder builder = new ParameterBuilder();
        builder.name("Authentication").description("登录后需要携带token，获取图片验证码、登录、注册、激活不需要携带").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(builder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalOperationParameters(parameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.sinjinsong.skeleton.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("JavaWeb项目骨架")
                .description("集成了SpringMVC、Spring、MyBaits、MyBatis Generator、MyBatis PageHelper、Druid、Lombok、JWT、Spring Security、JavaMail、Thymeleaf(emailTemplate)、RestTemplate、FileUpload、Spring Scheduler、Hibernate Validator、Redis、Spring Async、Spring Cache、Swagger、Spring Test、(WebSocket、MockMvc、RabbitMQ、Netty、OAUTH、Payment)，REST风格的接口的Web项目")
                .termsOfServiceUrl("https://github.com/songxinjianqwe")
                .contact(new Contact("SinjinSong", "https://github.com/songxinjianqwe", "151070063@smail.nju.edu.cn"))
                .version("0.1")
                .build();
    }
}
