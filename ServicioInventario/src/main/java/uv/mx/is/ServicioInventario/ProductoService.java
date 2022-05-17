package uv.mx.is.ServicioInventario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    //Listando Productos
    private List<Producto> producto;

    public ProductoService(){
        producto = new ArrayList<>();
        producto.add(new Producto(1, "Chokis", "$15", "10", "Galletas", "Gamesa"));
        producto.add(new Producto(2, "Doritos", "$13", "20", "Botana", "Sabritas"));
        producto.add(new Producto(3, "Pepsi", "$12", "17", "Refresco", "Pepsi"));
    }

    public List<Producto> list(){
        return producto;
    }

    //Buscar Productos
    public Producto find(int idProducto){
        for (Producto producto : producto){
            if (producto.getIdProducto() == idProducto){
                return producto;
            }
        }
        return null;
    }

    //Crear Producto
    public Producto save(Producto product){
        producto.add(product);
        return product;
    }

    //Actualizar Producto
    public Producto update(int idProducto, Producto product){
        int index = 0;
        for(Producto p: producto){
            if (p.getIdProducto() == idProducto){
                product.setIdProducto(idProducto);
                producto.set(index, product);
            }
        }
        return product;
    }

    //Eliminar Producto
    public boolean delete(int idProducto){
        for (Producto p : producto){
            if (p.getIdProducto() == idProducto){
                return producto.remove(p);
            }
        }
        return false;
    }
}