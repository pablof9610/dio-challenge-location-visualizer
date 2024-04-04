package dio.project.challenge.locationvisualizer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "googleMaps", url = "https://maps.googleapis.com")
public interface GoogleMapsService {
    @GetMapping("/maps/api/staticmap?center={address}&zoom={zoom}&size={size}&key={apiKey}")
    byte[] getStaticMapImage(@PathVariable("address") String endereco,
                             @PathVariable("zoom") int zoom,
                             @PathVariable("size") String size,
                             @PathVariable("apiKey") String apiKey);
}
