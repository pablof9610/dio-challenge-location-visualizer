package dio.project.challenge.locationvisualizer.service;

import dio.project.challenge.locationvisualizer.model.Endereco;

import java.io.IOException;

public interface MapService {
    void mountImageFromBytes(Endereco endereco) throws IOException;
}
