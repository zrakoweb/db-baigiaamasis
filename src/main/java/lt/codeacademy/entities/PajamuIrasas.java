package lt.codeacademy.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "operation")
public class PajamuIrasas{


    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "suma")
    private int suma;

//    @Column(name = "operation_id")
//    private int indeksas;

    @Column(name = "date")
    private LocalDateTime data;

    @Column(name = "method")
    private String arIbanka;

    @Column(name = "info")
    private String info;

    @ManyToOne
    @JoinColumn(name = "sort_id")
    private Sort sort;

    public PajamuIrasas(int suma, Sort sort, String arIbanka, String info) {
        this.suma = suma;
        this.sort = sort;
        this.data = LocalDateTime.now();
        this.arIbanka = arIbanka;
        this.info = info;
    }

    public PajamuIrasas(int suma, Sort sort, LocalDateTime data, String arIbanka, String info) {
        this.suma = suma;
        this.sort = sort;
        this.data = data;
        this.arIbanka = arIbanka;
        this.info = info;
    }

    public PajamuIrasas() {

    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
