package uv.mx.is.ServicioInventario;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Producto")
public class ProductoController {
    private final ProductoService service;
    
    public ProductoController(ProductoService service){
        this.service = service;
    }

    @GetMapping
    public Iterable<Producto> list(){
        return service.list();
    }

    @GetMapping("/{idProducto}")
    public Producto find(@PathVariable("idProducto") int idProducto){
        return service.find(idProducto);
    }

    @PostMapping
    public Producto create(@RequestBody Producto producto){
        return service.save(producto);
    }

    @PutMapping("/{idProducto}")
    public Producto update(@PathVariable("idProducto") int idProducto, @RequestBody Producto producto){
        return service.update(idProducto, producto);
    }

    @DeleteMapping("/{idProducto}")
    public boolean delete(@PathVariable("idProducto") int idProducto){
        return service.delete(idProducto);
    }
}