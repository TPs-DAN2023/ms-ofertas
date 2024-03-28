package dan.ms.tp.msofertas.domain;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.experimental.PackagePrivate;

@Data
@Document(collection = "dan_precios")
public class Precio {
    
    @Id
    private String id;
    private Double monto;
    private Instant fechaActualizacion;
    private Double costo;
    @NotNull
    private Double ganancia;
    @NotNull
    @Valid
    private Producto producto;

}
