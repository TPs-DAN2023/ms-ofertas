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

    public Precio createPrecio(Precio precio) {

        precio.setFechaActualizacion(Instant.now());
        if(precio.getGanancia() == null)
            precio.setGanancia(2d);
        precio.setMonto(precio.getGanancia()*precio.getProducto().getCosto());
        precio.setCosto(precio.getProducto().getCosto());

        return precioRepository.save(precio);
    }

    @Override
    public List<Precio> getAllPrecios() {
       return precioRepository.findAll();
    }


    @Override
    public Precio getPrecioFromProducto(Producto producto) {
        Precio precio = precioRepository.findByProducto(producto.getId());
        if(precio == null) {
            precio = new Precio();
            precio.setProducto(producto);
            precio = createPrecio(precio);
        }
        else if (precio.getCosto() != producto.getCosto()) {
            precio.setCosto(producto.getCosto());
            precio.setMonto(precio.getGanancia()*precio.getCosto());
            precio.setFechaActualizacion(Instant.now());
            precio = precioRepository.save(precio);
        }
        precio.getProducto().setNombre(producto.getNombre());
        precio.getProducto().setDescripcion(producto.getDescripcion());
        return precio;
    }
}
