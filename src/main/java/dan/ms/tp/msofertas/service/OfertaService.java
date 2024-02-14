package dan.ms.tp.msofertas.service;

import java.util.List;

import dan.ms.tp.msofertas.domain.Oferta;

public interface OfertaService {
    
    Oferta createOferta(Oferta oferta);
    List<Oferta> getAllOfertas();
    Oferta getOfertaById(String id);
    Oferta deleteOferta(Oferta oferta);

}
