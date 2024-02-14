package dan.ms.tp.msofertas.domain;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Producto {

    @Id
    @NotNull
    private String id;

    private String nombre;
    private String descripcion;
    private Double precio;
}
