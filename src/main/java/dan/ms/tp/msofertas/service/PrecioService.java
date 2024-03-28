package dan.ms.tp.msofertas.service;

import java.util.List;

import dan.ms.tp.msofertas.domain.Precio;
import dan.ms.tp.msofertas.domain.Producto;
import dan.ms.tp.msofertas.exception.NotFoundException;

public interface PrecioService {
    
    Precio createPrecio(Precio precio);

    List<Precio> getAllPrecios();

    Precio getPrecioFromProducto(Producto producto);
}
