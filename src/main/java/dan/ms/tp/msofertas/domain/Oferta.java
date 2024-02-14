package dan.ms.tp.msofertas.domain;

import java.time.Instant;
import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Document(collection = "dan_ofertas")
public class Oferta {
    
    @Id
    @NotNull
    private String id;
    private Instant fechaAlta;
    private Instant fechaBaja;
    @NotNull
    @FutureOrPresent
    private Instant fechaDesde;
    @NotNull
    @FutureOrPresent
    private Instant fechaHasta;
    @NotNull
    @Range(min = 0, max = 1)
    private Double descuento;
    @NotNull
    @Size(min = 1)
    private List<Producto> productos;

}
