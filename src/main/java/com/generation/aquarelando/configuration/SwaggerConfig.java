package com.generation.aquarelando.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI springBlogPessoalOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Ecommerce Aquarelando")
						.description("Projeto Integrador - Aquarelando")
						.version("v0.0.1")
						.license(new License()
								.name("Bianca, Daniel, Gustavo, Isabella, Jefferson, Rafael e Wesley")
								.url("https://github.com/Aquarelando"))
						.contact(new Contact()
								.name("Bianca, Daniel, Gustavo, Isabella, Jefferson, Rafael e Wesley")
								.url("linkedin.com/in/FerreiraLimaDaniel"
										+ "https://www.linkedin.com/in/wesley-berto/"
										+ "https://www.linkedin.com/in/bianca-akemi/"
										+ "https://www.linkedin.com/in/isabellacorreiadossantos/"
										+ "https://www.linkedin.com/in/gustavoalcantaradejesus/"
										+ "https://www.linkedin.com/in/rafael-cabral22/"
										+ "https://www.linkedin.com/in/jeffersonfelizz/")
								.email("gen.aquarelando@gmail.com")))
				.externalDocs(new ExternalDocumentation()
						.description("Github")
						.url("https://github.com/Aquarelando/Backend"));
	}
	
	
	@Bean
	public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {

		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

			}));
		};
	}

	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);

	}
	
}