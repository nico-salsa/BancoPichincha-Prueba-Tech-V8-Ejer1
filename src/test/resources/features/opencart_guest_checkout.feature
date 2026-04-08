# language: es
Característica: Compra como invitado en OpenCart

  Escenario: Completar una compra con dos productos como guest checkout
    Dado que el comprador invitado ingresa a la tienda
    Cuando agrega los dos productos al carrito
    Y visualiza el carrito de compras
    Entonces debe ver ambos productos en el carrito
    Cuando completa el checkout como invitado
    Entonces la orden se completa con el mensaje de confirmacion final
