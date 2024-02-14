package dan.ms.tp.msofertas.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dan.ms.tp.msofertas.dao.OfertaRepository;
import dan.ms.tp.msofertas.domain.Oferta;
import dan.ms.tp.msofertas.exception.NotFoundException;

@Service
public class OfertaServiceImpl implements OfertaService {

    @Autowired
    private OfertaRepository ofertaRepo;

    @Override
    public Oferta createOferta(Oferta oferta) {
        oferta.setFechaAlta(Instant.now());
        return ofertaRepo.save(oferta);
    }

    @Override
    public List<Oferta> getAllOfertasVigentes() {
        return ofertaRepo.findAllVigentes(Instant.now());
    }

    @Override
    public Oferta getOfertaById(String id) throws NotFoundException{
        return ofertaRepo.findById(id)
                        .orElseThrow(() -> new NotFoundException("Oferta", id));
    }

    @Override
    public Oferta deleteOferta(Oferta oferta) {
        oferta.setFechaBaja(Instant.now());
        return ofertaRepo.save(oferta);
    }
    
}
