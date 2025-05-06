package model;

import javax.persistence.*;

@Entity
public class Evolução {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String descricao;
}
