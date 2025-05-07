package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Evolucao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String descricao;

    @OneToMany(mappedBy = "evolucao")
    private List<CasoDengue> casos;

    public Evolucao() {}

    public Evolucao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addCaso(CasoDengue caso) {
        this.casos.add(caso);
    }
}
