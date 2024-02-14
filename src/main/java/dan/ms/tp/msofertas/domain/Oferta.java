package dan.ms.tp.msofertas.domain;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "dan_ofertas")
public class Oferta {
    
    @Id
    private String id;
    private Instant fechaAlta;
    private Instant fechaBaja;
    private Instant fechaDesde;
    private Instant fechaHasta;
    private Double descuento;

}
