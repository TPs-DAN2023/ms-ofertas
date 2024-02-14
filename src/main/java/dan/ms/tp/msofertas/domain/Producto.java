package dan.ms.tp.msofertas.domain;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
public class Producto {

    @Id
    private String id;
}
