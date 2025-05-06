package model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nome;

    @OneToMany(mappedBy = "estado", fetch = FetchType.EAGER)
    private List<Cidade> cidades;

    public Estado() {}

    public Estado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void addCidade (Cidade cidade) {
        this.cidades.add(cidade);
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ",nome='" + nome + '\'' +
                '}';
    }
}
