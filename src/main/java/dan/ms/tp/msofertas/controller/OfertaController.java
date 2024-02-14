package dan.ms.tp.msofertas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dan.ms.tp.msofertas.domain.Oferta;
import dan.ms.tp.msofertas.service.OfertaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController("/api/ofertas")
public class OfertaController {
    
    @Autowired
    private OfertaService ofertaService;

    @PostMapping()
    ResponseEntity<Oferta> createOferta(@RequestBody Oferta oferta) {
        
        try {
            Oferta o = ofertaService.createOferta(oferta);
            return ResponseEntity.status(201).body(o);
        } catch (Exception e) {
            // other exceptions are handled by the global exception handler
            return ResponseEntity.status(500).build();
        }
        
    }

    @GetMapping()
    ResponseEntity<List<Oferta>> getVigentes() {
        try {
            List<Oferta> oList = ofertaService.getAllOfertasVigentes();
            return ResponseEntity.ok().body(oList);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Oferta> getOfertaById(@PathVariable String id) {
        try {
            Oferta o = ofertaService.getOfertaById(id);
            return ResponseEntity.ok().body(o);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping()
    ResponseEntity<Oferta> darOfertaDeBaja(@RequestBody Oferta oferta) {
        try {
            Oferta o = ofertaService.deleteOferta(oferta);
            return ResponseEntity.ok().body(o);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    

}
