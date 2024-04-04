package dio.project.challenge.locationvisualizer.service.impl;

import dio.project.challenge.locationvisualizer.model.Endereco;
import dio.project.challenge.locationvisualizer.service.CepService;
import dio.project.challenge.locationvisualizer.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepServiceImpl implements CepService {
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public String cepTreatment(Endereco endereco) {
        String cep = endereco.getCep();
        Endereco response = viaCepService.validateCep(cep);
        if(response.getCep() == null) {
            return "Invalid CEP";
        }
        return response.toString();
    }
}
