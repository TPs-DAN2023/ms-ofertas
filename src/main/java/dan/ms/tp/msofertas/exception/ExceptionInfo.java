package dan.ms.tp.msofertas.exception;

import lombok.Data;

@Data
public class ExceptionInfo {
    public Integer status;
    public String name;
    public String message;
}
