package dan.ms.tp.msofertas.service;

import java.util.List;

import dan.ms.tp.msofertas.domain.Oferta;
import dan.ms.tp.msofertas.exception.NotFoundException;

public interface OfertaService {
    
    Oferta createOferta(Oferta oferta) throws NotFoundException;
    List<Oferta> getAllOfertasVigentes() throws NotFoundException;
    Oferta getOfertaById(String id) throws NotFoundException;
    Oferta deleteOferta(Oferta oferta);

}
