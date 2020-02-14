package br.com.shortestpathapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Entidade responsável em mapear a tabela TBL_ORIGEM_DESTINO.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 13/02/2020
 */
@Entity(name = "TBL_ORIGEM_DESTINO")
@Data
public class NodeOrigemDestinationEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "O campo origem é obrigatorio!")
    @Column(name = "ORIGEM", nullable = false)
    private String origem;

    @NotEmpty(message = "O campo origem é obrigatorio!")
    @Column(name = "DESTINO", nullable = false)
    private String destino;

    @NotEmpty(message = "O campo peso é obrigatorio!")
    @Column(name = "PESO", nullable = false)
    private Integer peso;

    @ManyToOne
    @JoinColumn(name="NODE_ID")
    private NodeDomain no;

    public NodeOrigemDestinationEntity() {

    }

    public NodeOrigemDestinationEntity(String origem, String destino, Integer peso, NodeDomain no) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.no = no;
    }
}
