package id.giyomi.vms.backend.configuration;

import id.giyomi.vms.backend.component.authentication.JwtTokenUtil;
import id.giyomi.vms.backend.service.UserPrincipalDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

//    private UserPrincipalDetailService userPrincipalDetailService;
//    private JwtTokenUtil jwtTokenUtil;
//
//    public SpringFoxConfig(UserPrincipalDetailService userPrincipalDetailService, JwtTokenUtil jwtTokenUtil) {
//        this.userPrincipalDetailService = userPrincipalDetailService;
//        this.jwtTokenUtil = jwtTokenUtil;
//    }

    @Bean
    public Docket apiDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//        final UserDetails userDetails = userPrincipalDetailService
//                .loadUserByUsername("ceo");
//        final String token = jwtTokenUtil.generateToken(userDetails);

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(Collections.singletonList(
                        new ParameterBuilder()
                            .name("Authorization")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .hidden(true)
                                .defaultValue("Bearer " + "dummyjwt")
                                .build()
                ));
    }
}