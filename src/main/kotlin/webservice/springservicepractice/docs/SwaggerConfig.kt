package webservice.springservicepractice.docs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    // https://velog.io/@borab/Spring-boot-Swagger-%EC%84%A4%EC%A0%95-gradle
    // apis는 일단 뭐가 뭔지 모르겠음.
    @Bean
    fun restAPI() : Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.any())    // 모든 RequestMapping URI 추출
            // .apis(RequestHandlerSelectors.basePackage("com."))   // 패키지 기준 추출
            // .paths(PathSelectors.ant("/v2/**")) // 경로 패턴 URI만 추출
            .paths(PathSelectors.any())
            .build()
            // .useDefaultResponseMessages(false)  // Response 응답 메시지 디폴트값 적용 X
    }

    private fun apiInfo() : ApiInfo {
        return ApiInfoBuilder()
            .title("Panda의 Spring boot Rest API 공부")
            .version("1.0.0")
            .termsOfServiceUrl("서비스 약관 url")
            .license("MIT")
            .licenseUrl("http://license.com")
            .description("Spring boot swagger api 구현 공부용입니다.")
            .contact(
                Contact(
                    "Contect us",
                    "연락할 주소",
                    "이메일")
            )
            .build()
    }
}