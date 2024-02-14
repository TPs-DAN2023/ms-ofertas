package dan.ms.tp.msofertas.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dan.ms.tp.msofertas.domain.Oferta;

@Repository
public interface OfertaRepository extends MongoRepository<Oferta, String>{
    
}
