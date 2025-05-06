package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sintoma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String descricao;

    @ManyToMany(mappedBy = "sintomas")
    private List<CasoDengue> casos;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addCaso(CasoDengue caso) {
        caso.addSintoma(this);
    }
}
