
package model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="lindea_de_venta")
public class LineaDeVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="producto_id")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name="venta_id")
    private Venta venta;
    @Column(name="cantidad")
    private int cantidad;
    @Column(name="subTotal")
    private Double subtotal ;

    public LineaDeVenta() {
    }

    public LineaDeVenta(Long id, Producto producto, Venta venta, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.venta = venta;
        this.cantidad = cantidad;
    }

    public LineaDeVenta(Producto producto, Venta venta, int cantidad,Double subtotal) {
        this.producto = producto;
        this.venta = venta;
        this.cantidad = cantidad;
        this.subtotal=subtotal;
    }
    public LineaDeVenta(Producto producto, int cantidad,Double subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal=subtotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    }
