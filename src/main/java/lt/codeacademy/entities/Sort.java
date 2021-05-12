package lt.codeacademy.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sort")
public class Sort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type_id")
    private int typeId;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "sort", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PajamuIrasas>pajamuIrasasList;

    public Sort() {

    }

    public Sort(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Sort(int typeId, String type) {
        this.typeId = typeId;
        this.type = type;
    }

    public List<PajamuIrasas> getPajamuIrasasList() {
        return pajamuIrasasList;
    }

    public void setPajamuIrasasList(List<PajamuIrasas> pajamuIrasasList) {
        this.pajamuIrasasList = pajamuIrasasList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
