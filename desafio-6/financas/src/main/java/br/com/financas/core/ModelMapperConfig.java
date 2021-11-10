package br.com.financas.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

/*
* Strictu sensu eu não precisei dessa classe, o spring foi capaz de gerenciar corretamente o model mapper sem
* a necessidade da criação de uma classe de configuração.
* Entretanto criei de qualquer forma para deixar registrado o procedimento completo.
* */