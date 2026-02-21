
package model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="venta")
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_empleado")
    private Empleado empleado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    @Column(name="total")
    private Double total;
    @Column(name="fechaHora")
    private LocalDateTime fechaHora;
    @Column(name="articulos")
    private int articulos;
    @OneToMany(mappedBy = "venta",cascade = CascadeType.ALL)
    private List<LineaDeVenta> detalles = new ArrayList(); 
    public Venta() {
    }

    public Venta(Long id, Empleado empleado, Cliente cliente, Double total, LocalDateTime fechaHora, int articulos) {
        this.id = id;
        this.empleado = empleado;
        this.cliente = cliente;
        this.total = total;
        this.fechaHora = fechaHora;
        this.articulos = articulos;
    }

    public Venta(Empleado empleado, Cliente cliente, Double total, LocalDateTime fechaHora, int articulos) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.total = total;
        this.fechaHora = fechaHora;
        this.articulos = articulos;
    }

    public Venta(Empleado empleado, Cliente cliente, Double total, LocalDateTime fechaHora, int articulos, List<LineaDeVenta> detalles) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.total = total;
        this.fechaHora = fechaHora;
        this.articulos = articulos;
        this.detalles = detalles;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getArticulos() {
        return articulos;
    }

    public void setArticulos(int articulos) {
        this.articulos = articulos;
    }
    public void addDetalle(LineaDeVenta detalle){
    if(detalles ==null){
    detalles = new ArrayList<>();}
    detalles.add(detalle);
    detalle.setVenta(this);
    }

    public List<LineaDeVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<LineaDeVenta> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
}
