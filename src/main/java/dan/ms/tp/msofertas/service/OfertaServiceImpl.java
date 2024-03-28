package dan.ms.tp.msofertas.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dan.ms.tp.msofertas.dao.OfertaRepository;
import dan.ms.tp.msofertas.domain.Oferta;
import dan.ms.tp.msofertas.domain.Producto;
import dan.ms.tp.msofertas.exception.NotFoundException;

@Service
public class OfertaServiceImpl implements OfertaService {

    @Autowired
    private OfertaRepository ofertaRepo;
    @Autowired 
    private Environment env;

    @Override
    public Oferta createOferta(Oferta oferta) throws NotFoundException{
        
        oferta.setFechaAlta(Instant.now());

        //check que los productos existen
        RestTemplate restTemplate = new RestTemplate();
        for (Producto p : oferta.getProductos()) {
            Producto prod = restTemplate.exchange(
                    env.getProperty("env.msproductos.url") + "api/productos/" + p.getId(),
                    HttpMethod.GET, null,
                    Producto.class
                ).getBody();

            if (prod == null) throw new NotFoundException("Producto", p.getId());
        }

        return ofertaRepo.save(oferta);
    }

    @Override
    public List<Oferta> getAllOfertasVigentes() throws NotFoundException{
        List<Oferta> oList = ofertaRepo.findAllVigentes(Instant.now());
        RestTemplate restTemplate = new RestTemplate();

        // cargar productos
        for(Oferta o : oList) {
            for (Producto p: o.getProductos()) {
                Producto prod = restTemplate.exchange(
                    env.getProperty("env.msproductos.url") + "api/productos/" + p.getId(),
                    HttpMethod.GET, null,
                    Producto.class
                ).getBody();

                // no deberia ocurrir, pero por las dudas....
                if(prod == null) throw new NotFoundException("Producto", p.getId());

                p.setNombre(prod.getNombre());
                p.setDescripcion(prod.getDescripcion());
            }
        }

        return oList;
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
