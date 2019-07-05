package com.spring.angular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.spring.angular.entidades.Estado;
import com.spring.angular.repositorios.EstadoRepository;

@Component
public class DataLoader  implements ApplicationRunner {
	
    private EstadoRepository estadoRepository;

    @Autowired
    public DataLoader(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public void run(ApplicationArguments args) {
    	estadoRepository.save(new Estado(1L, "Acre"));
    	estadoRepository.save(new Estado(2L, "Alagoas"));
    	estadoRepository.save(new Estado(3L, "Amapá"));
    	estadoRepository.save(new Estado(4L, "Amazonas"));
    	estadoRepository.save(new Estado(5L, "Bahia"));
    	estadoRepository.save(new Estado(6L, "Ceará"));
    	estadoRepository.save(new Estado(7L, "Distrito Federal"));
    	estadoRepository.save(new Estado(8L, "Espírito Santo"));
    	estadoRepository.save(new Estado(9L, "Goiás"));
    	estadoRepository.save(new Estado(10L, "Maranhão"));
    	estadoRepository.save(new Estado(11L, "Mato Grosso"));
    	estadoRepository.save(new Estado(12L, "Mato Grosso do Sul"));
    	estadoRepository.save(new Estado(13L, "Minas Gerais"));
    	estadoRepository.save(new Estado(14L, "Pará"));
    	estadoRepository.save(new Estado(15L, "Paraíba"));
    	estadoRepository.save(new Estado(16L, "Paraná"));
    	estadoRepository.save(new Estado(17L, "Pernambuco"));
    	estadoRepository.save(new Estado(18L, "Piauí"));
    	estadoRepository.save(new Estado(19L, "Rio de Janeiro"));
    	estadoRepository.save(new Estado(20L, "Rio Grande do Norte"));
    	estadoRepository.save(new Estado(21L, "Rio Grande do Sul"));
    	estadoRepository.save(new Estado(22L, "Rondônia"));
    	estadoRepository.save(new Estado(23L, "Roraima"));
    	estadoRepository.save(new Estado(24L, "Santa Catarina"));
    	estadoRepository.save(new Estado(25L, "São Paulo"));
    	estadoRepository.save(new Estado(26L, "Sergipe"));
    	estadoRepository.save(new Estado(27L, "Tocantins"));

    }

}
