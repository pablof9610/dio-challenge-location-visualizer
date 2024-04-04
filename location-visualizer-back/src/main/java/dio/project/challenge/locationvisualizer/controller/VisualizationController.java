package dio.project.challenge.locationvisualizer.controller;

import dio.project.challenge.locationvisualizer.model.Endereco;
import dio.project.challenge.locationvisualizer.service.CepService;
import dio.project.challenge.locationvisualizer.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("visualization")
public class VisualizationController {
    @Autowired
    private MapService mapService;
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public void getImage(@RequestBody Endereco endereco) throws IOException {
        mapService.mountImageFromBytes(endereco);
    }
}
