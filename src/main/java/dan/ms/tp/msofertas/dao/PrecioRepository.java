package dan.ms.tp.msofertas.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import dan.ms.tp.msofertas.domain.Precio;

@Repository 
public interface PrecioRepository extends MongoRepository<Precio, String> {


    
}
