package dio.project.challenge.locationvisualizer.service.impl;

import dio.project.challenge.locationvisualizer.model.Endereco;
import dio.project.challenge.locationvisualizer.service.GoogleMapsService;
import dio.project.challenge.locationvisualizer.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private GoogleMapsService googleMapsService;
    @Autowired
    private CepServiceImpl cepService;
    @Value("${maps.api.key}")
    private String API_KEY;
    @Override
    public void mountImageFromBytes(Endereco endereco) throws IOException {
        String completeAddress = cepService.cepTreatment(endereco);
        System.out.println(completeAddress);
        byte[] imageBytes = googleMapsService.getStaticMapImage(endereco.toString(),
                15,
                "600x400",
                API_KEY);

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
        File outputFile = new File("..\\location-visualizer-front\\map.png");
        ImageIO.write(image, "png", outputFile);
    }
}
