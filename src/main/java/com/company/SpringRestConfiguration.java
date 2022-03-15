package com.company;


import com.company.model.Order1;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import java.util.stream.Collectors;


//@Configuration
//class MyRepositoryRestConfigurerAdapter extends RepositoryRestConfigurerAdapter {
//
//	@Autowired
//	private EntityManager entityManager;
//
//	@Override
//	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType()).collect(Collectors.toList()).toArray(new Class[0]));
//	}
//
//}


// adds Id field in response
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class SpringRestConfiguration implements RepositoryRestConfigurer {

	final EntityManager entityManager;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
//		config.setDefaultMediaType(MediaType.APPLICATION_JSON);
//		config.useHalAsDefaultJsonMediaType(false);
		Class[] cl = entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType())
				.collect(Collectors.toList()).toArray(new Class[0]);
		config.exposeIdsFor(cl);
	}


//	@Bean
//	public RepresentationModelProcessor<EntityModel<Order1>> personProcessor() {
//
//		return new RepresentationModelProcessor<EntityModel<Order1>>() {
//
//			@Override
//			public EntityModel<Order1> process(EntityModel<Order1> model) {
//				model.removeLinks();
//				//model.add(new Link("http://localhost:8080/qqq", "added-link"));
//				return model;
//			}
//		};
//	}
}


//@Configuration
//class JacksonMapperConfiguration
//{
//	@Bean
//	public Jackson2ObjectMapperBuilderCustomizer customizer()
//	{
//		return builder -> builder.serializerByType(BigDecimal.class, new ToStringSerializer());
//	}
//}



//public class WebappConfig extends WebMvcConfigurerAdapter {
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//		builder.serializerByType(ObjectId.class, new ToStringSerializer());
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(builder.build());
//		converters.add(converter);
//	}
//}
