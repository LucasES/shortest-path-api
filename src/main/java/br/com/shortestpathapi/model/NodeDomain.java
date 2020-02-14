package br.com.shortestpathapi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * Entidade responsável em mapear a tabela TBL_NO.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 14/02/2020
 */
@Entity(name = "TBL_NO")
@Data
public class NodeDomain {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "O campo origem é obrigatorio!")
    @Column(name = "NOME", nullable = false)
    private String nome;

    public NodeDomain() {

    }

    public NodeDomain(String nome) {
        this.nome = nome;
    }
}
