# MS-OFERTAS
Microservicio para manejar los descuentos y precios de los productos.

Cosas que tiene que hacer:
- CRUD ofertas (alta,baja y lectura)
- leer historial de precios de un producto
- actualizar la ganancia de un producto (actualizar precio manual)
- actualizar los precios de los productos de forma automatica

## Problemas
Lo ideal seria separar Oferta y Precio en dos microservicios, porque con este enfoque ocurre lo siguiente:
1. El usuario pide cargar las ofertas al ms (GET)
2. El ms busca las ofertas vigentes, y carga la info de los productos asociados llamando a ms-productos
3. (aca esta el "problema?") ms-productos llama a este ms para cargar los precios de los productos

## Info
Un producto tiene una oferta, una oferta puede estar
asociada a varios productos.
Ademas, un producto tiene un Precio

La oferta tiene:
- fecha de alta
- fecha de baja
- fecha desde
- fecha hasta
- descuento

El precio se actualiza si el dolar aumento más de un 5%
(precioOrden * precioDolar * ganancia / precioActual > 1.05)
cuando se busca el precio de un producto

Entonces Precio tiene los campos:
- montoArs (precioActual en Ars)
- precioDolar (valor del dolar en la fecha de actualizacion)
- fechaActualizacion
- costo (precio al que se compró (asumimos que compra en dolares))
- ganancia (porcentaje que se le saca de ganancia)
- producto
