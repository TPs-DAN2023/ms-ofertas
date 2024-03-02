package dan.ms.tp.msofertas.domain;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.PackagePrivate;

@Data
@Document(collection = "dan_precios")
public class Precio {
    
    @Id
    @NotNull
    private String id;
    private Double montoArs;
    private Double valorDolar;
    @NotNull
    @FutureOrPresent
    private Instant fechaActualizacion;
    private Double costo;
    private Double ganancia;
    @NotNull
    private Producto producto;

}
