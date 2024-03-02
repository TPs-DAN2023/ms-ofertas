package dan.ms.tp.msofertas.service;

import java.time.Instant;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import dan.ms.tp.msofertas.dao.PrecioRepository;
import dan.ms.tp.msofertas.domain.Precio;
import dan.ms.tp.msofertas.domain.Producto;
import dan.ms.tp.msofertas.exception.NotFoundException;

@Service
public class PrecioServiceImpl implements PrecioService {

    @Autowired
    private PrecioRepository precioRepository;
    @Autowired
    private Environment environment;

    public Precio createPrecio(Precio precio) throws NotFoundException {

        precio.setFechaActualizacion(Instant.now());

        RestTemplate restTemplate = new RestTemplate();
        Producto associatedProduct = precio.getProducto();
        Producto prod = restTemplate.exchange(
                environment.getProperty("env.msproductos.url") + "api/productos/" + associatedProduct.getId(),
                HttpMethod.GET, null,
                Producto.class).getBody();

        if (prod == null) throw new NotFoundException("Producto", associatedProduct.getId());

        return precioRepository.save(precio);
    }

    @Override
    public Precio getPrecioById(String id) throws NotFoundException {
        return precioRepository.findById(id)
                                .orElseThrow(() -> new NotFoundException("Precio", id));
    }

    @Override
    public List<Precio> getAllPrecios() {
       return precioRepository.findAll();
    }

}
