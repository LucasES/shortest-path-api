package br.com.shortestpathapi.repository;

import br.com.shortestpathapi.model.NodeOrigemDestinationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório responsável em mapear as consultas realizadas no objeto NodeOrigemDestinationEntity.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 14/02/2020
 */
@Repository
public interface NodeEntityRepository extends CrudRepository<NodeOrigemDestinationEntity, Long> {

    /**
     * Lista todos os NodeOrigemDestinationEntity.
     *
     * @return Lista de NodeOrigemDestinationEntity.
     */
    List<NodeOrigemDestinationEntity> findAll();
}
