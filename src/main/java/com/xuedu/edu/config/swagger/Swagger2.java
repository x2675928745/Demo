package com.xuedu.edu.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.xuedu.edu.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("学渡-教学平台API文档")
				.description(
						"Restfull API：<br/> 登录后接口：http://127.0.0.1/api/user <br/>"
								+ "权限控制: <br/>" 
								+ "401-->用户无访问权限 <br/>"
								+ "返回码status说明:<br/>"
								+ "200---->请求成功 <br/>"
								+ "500---->服务器异常 <br/>"
								+ "501---->操作失败 <br/>"
								+ "502---->Token失败 <br/>"
								+ "400---->参数列表错误 <br/>"
								+ "404---->找不到页面 <br/>"
								+ "1000---->请输入正确的账号和密码 <br/>"
								+ "1001---->手机号不合法 <br/>"
								+ "1002---->重复密码不一致 <br/>")
				.termsOfServiceUrl("http://127.0.0.1/").version("1.0").build();
	}
	
}
