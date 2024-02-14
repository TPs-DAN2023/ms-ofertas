package dan.ms.tp.msofertas.exception;

public class NotFoundException extends Exception{
    public NotFoundException(String resourceType) {
        super("Recurso del tipo "+resourceType+" no encontrado");
    }

    public NotFoundException(String resourceType, String id) {
        super("Recurso del tipo "+resourceType+" con id "+id+" no encontrado");
    }
}
