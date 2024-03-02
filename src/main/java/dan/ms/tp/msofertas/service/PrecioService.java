package dan.ms.tp.msofertas.service;

import java.util.List;

import dan.ms.tp.msofertas.domain.Precio;
import dan.ms.tp.msofertas.exception.NotFoundException;

public interface PrecioService {
    
    Precio createPrecio(Precio precio) throws NotFoundException;

    Precio getPrecioById(String id) throws NotFoundException;

    List<Precio> getAllPrecios();

}
