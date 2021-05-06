package lt.codeacademy.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "operation")
public class PajamuIrasas{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Sort sort;

    @Column(name = "suma")
    private int suma;

    @Column(name = "operation_id")
    private int indeksas;

    @Column(name = "date")
    private LocalDateTime data;

    @Column(name = "method")
    private String arIbanka;

    @Column(name = "info")
    private String info;

    public PajamuIrasas(int suma, int indeksas, String arIbanka, String info) {
        this.suma = suma;
        this.indeksas = indeksas;
        this.data = LocalDateTime.now();
        this.arIbanka = arIbanka;
        this.info = info;
    }

    public PajamuIrasas() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalDateTime getData() {
        return data;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getIndeksas() {
        return indeksas;
    }

    public void setIndeksas(int indeksas) {
        this.indeksas = indeksas;
    }

    public String getArIbanka() {
        return arIbanka;
    }

    public void setArIbanka(String arIbanka) {
        this.arIbanka = arIbanka;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
