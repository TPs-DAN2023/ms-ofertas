package dan.ms.tp.msofertas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import dan.ms.tp.msofertas.domain.Precio;
import dan.ms.tp.msofertas.domain.Producto;
import dan.ms.tp.msofertas.service.PrecioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("api/precios")
public class PrecioController {

  @Autowired
  private PrecioService precioService;

  @PostMapping
  public ResponseEntity<Precio> createPrecio(@RequestBody @Validated Precio precio) {

    try {
      Precio newPrecio = precioService.createPrecio(precio);
      return ResponseEntity.status(201).body(newPrecio);
    } catch (Exception e) {
      System.out.println(e.toString());
      return ResponseEntity.status(500).build();
    }

  }

  @GetMapping("/producto")
  public ResponseEntity<Precio> getPrecioFromProducto(@RequestBody @Validated Producto producto) {

    try {
      Precio precio = precioService.getPrecioFromProducto(producto);
      return ResponseEntity.ok().body(precio);      
    } catch (Exception e) {
      System.out.println(e.toString());
      return ResponseEntity.status(500).build();
    }
  }

  @GetMapping
  public ResponseEntity<List<Precio>> getAllPrecios() {

    try {
      List<Precio> precios = precioService.getAllPrecios();
      return ResponseEntity.ok().body(precios);
    } catch (Exception e) {
      System.out.println(e.toString());
      return ResponseEntity.status(500).build();
    }

  }

}
