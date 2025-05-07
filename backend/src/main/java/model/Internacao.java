package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Internacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String local;

    @OneToMany(mappedBy = "localInternacao")
    private List<CasoDengue> casos;


    public Internacao() {}

    public Internacao(String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void addCaso(CasoDengue caso) {
        this.casos.add(caso);
    }
}
