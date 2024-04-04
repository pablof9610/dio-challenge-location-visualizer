package dio.project.challenge.locationvisualizer.service;

import dio.project.challenge.locationvisualizer.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
    Endereco validateCep(@PathVariable("cep") String cep);
}
