package dan.ms.tp.msofertas.domain;

import java.time.Instant;

import org.springframework.data.annotation.Id;

public class Precio {
    
    @Id
    private String id;
    private Double montoArs;
    private Double valorDolar;
    private Instant fechaActualizacion;
    private Double costo;
    private Double ganancia;
    private Producto producto;

}
