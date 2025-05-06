package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class CasoDengue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = false)
    private String idade;

    @Column(nullable = false, length = 1)
    private String sexo;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String complemento;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="caso_sintoma",
            joinColumns = @JoinColumn(name = "caso_id"),
            inverseJoinColumns = @JoinColumn(name="sintoma_id")
    )
    private List<Sintoma> sintomas;

    @ManyToOne(fetch = FetchType.EAGER)
    private Internacao localInternacao;

    @ManyToOne
    private Cidade cidade;

    public CasoDengue() {}

    public CasoDengue(String nome, String cpf, Date dataNascimento, String idade, String sexo, String bairro, String logradouro, String numero, String complemento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.sexo = sexo;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void addSintoma(Sintoma sintoma) {
        sintomas.add(sintoma);
    }


}
