package br.com.shortestpathapi.service.impl;

import br.com.shortestpathapi.model.Graph;
import br.com.shortestpathapi.model.Node;
import br.com.shortestpathapi.model.NodeDomain;
import br.com.shortestpathapi.model.NodeOrigemDestinationEntity;
import br.com.shortestpathapi.repository.NodeDomainRepository;
import br.com.shortestpathapi.repository.NodeEntityRepository;
import br.com.shortestpathapi.service.IShortestPathService;
import br.com.shortestpathapi.util.DijkstraUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

/**
 * Implementação da interface de calculo do menor caminho.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 14/02/2020
 */
@Service
public class ShortestPathServiceImpl implements IShortestPathService {

    @Autowired
    private NodeEntityRepository nodeEntityRepository;

    @Autowired
    private NodeDomainRepository nodeDomainRepository;

    @Override
    public Optional<Graph> calculateShortestPathFromSource(String origem) {

        Optional<Graph> optionalGraph = setupInitialGraph();

        if(!optionalGraph.isPresent()) {
            return Optional.empty();
        }

        Graph graph = optionalGraph.get();

        Optional<Node> initialNodeFromGraph = getInitialNodeFromGraph(graph, origem);

        if(!initialNodeFromGraph.isPresent()) {
            return Optional.empty();
        }

        graph = DijkstraUtil.calculateShortestPathFromSource(graph, initialNodeFromGraph.get());

        return Optional.of(graph);
    }

    private Optional<Graph> setupInitialGraph() {

        ArrayList<Node> nodes = new ArrayList<>();
        List<NodeDomain> domains = this.nodeDomainRepository.findAll();

        if(domains == null || domains.isEmpty()) {
            return Optional.empty();
        }

        domains.forEach(domain -> nodes.add(new Node(domain.getNome())));

        List<NodeOrigemDestinationEntity> nodeOrigemDestinationEntities = nodeEntityRepository.findAll();

        if(nodeOrigemDestinationEntities == null || nodeOrigemDestinationEntities.isEmpty()) {
            return Optional.empty();
        }

        nodes.forEach(node -> nodeOrigemDestinationEntities.forEach(config -> {
            if(node.getName().equalsIgnoreCase(config.getOrigem())) {
                Optional<Node> first = nodes.stream().filter(n -> n.getName().equalsIgnoreCase(config.getDestino())).findFirst();
                first.ifPresent(value -> node.addDestination(value, config.getPeso()));
            }
        }));

        Graph graph = new Graph();
        nodes.forEach(graph::addNode);

        return Optional.of(graph);
    }

    private Optional<Node> getInitialNodeFromGraph(Graph graph, String origem)  {

        if(graph == null || graph.getNodes().isEmpty() || StringUtils.isEmpty(StringUtils.trimAllWhitespace(origem))) {
            return Optional.empty();
        }

        return graph.getNodes().stream().filter(node -> node.getName().equalsIgnoreCase(origem)).findFirst();
    }

}
