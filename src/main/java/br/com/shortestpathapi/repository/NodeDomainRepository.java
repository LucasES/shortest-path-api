package br.com.shortestpathapi.repository;

import br.com.shortestpathapi.model.NodeDomain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório responsável em mapear as consultas realizadas no objeto NodeDomain.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 14/02/2020
 */
@Repository
public interface NodeDomainRepository extends CrudRepository<NodeDomain, Long> {

    /**
     * Lista todos os NodeDomain.
     *
     * @return Lista de NodeDomain
     */
    List<NodeDomain> findAll();
}
