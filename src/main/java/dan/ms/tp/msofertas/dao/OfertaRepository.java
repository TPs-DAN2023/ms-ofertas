package dan.ms.tp.msofertas.dao;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import dan.ms.tp.msofertas.domain.Oferta;

@Repository
public interface OfertaRepository extends MongoRepository<Oferta, String>{
    
    @Query("{'fechaHasta': {$gte: ?0}, 'fechaBaja': null}")
    List<Oferta> findAllVigentes(Instant hoy);

}
