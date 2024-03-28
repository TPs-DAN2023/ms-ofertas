package dan.ms.tp.msofertas.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import dan.ms.tp.msofertas.domain.Precio;
import dan.ms.tp.msofertas.domain.Producto;

@Repository 
public interface PrecioRepository extends MongoRepository<Precio, String> {

    @Query("{'producto._id': ?0}")
    Precio findByProducto(String idProducto);
    
}
