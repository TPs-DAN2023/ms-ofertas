package dan.ms.tp.msofertas.domain;

import java.time.Instant;

import org.springframework.data.annotation.Id;

public class Oferta {
    
    @Id
    private String id;
    private Instant fechaAlta;
    private Instant fechaBaja;
    private Instant fechaDesde;
    private Instant fechaHasta;
    private Double descuento;

}
