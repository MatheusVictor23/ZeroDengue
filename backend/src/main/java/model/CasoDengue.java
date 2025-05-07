package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private LocalDate dataNascimento;

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

    @Column(nullable = false)
    private LocalDate dataInicioSintomas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="caso_sintoma",
            joinColumns = @JoinColumn(name = "caso_id"),
            inverseJoinColumns = @JoinColumn(name="sintoma_id")
    )
    private List<Sintoma> sintomas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Internacao localInternacao;

    @ManyToOne
    private Cidade cidade;

    @ManyToOne
    private Evolucao evolucao;

    public CasoDengue() {}

    public CasoDengue(String nome, String cpf, LocalDate dataNascimento, String idade, String sexo, String bairro, String logradouro, String numero, String complemento, LocalDate dataInicioSintomas) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.sexo = sexo;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.dataInicioSintomas = dataInicioSintomas;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
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

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public Internacao getLocalInternacao() {
        return localInternacao;
    }

    public void setLocalInternacao(Internacao localInternacao) {
        this.localInternacao = localInternacao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Evolucao getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(Evolucao evolucao) {
        this.evolucao = evolucao;
    }

    @Override
    public String toString() {
        return "CasoDengue{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", idade='" + idade + '\'' +
                ", sexo='" + sexo + '\'' +
                ", bairro='" + bairro + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", sintomas=" + sintomas +
                ", localInternacao=" + localInternacao +
                ", cidade=" + cidade +
                ", evolucao=" + evolucao +
                '}';
    }

}
