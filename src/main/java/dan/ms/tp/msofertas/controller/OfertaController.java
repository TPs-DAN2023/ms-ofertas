package dan.ms.tp.msofertas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dan.ms.tp.msofertas.service.OfertaService;

@RestController("/api/ofertas")
public class OfertaController {
    
    @Autowired
    private OfertaService OfertaService;



}
