package br.com.shortestpathapi.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe responsável em mapear os atributos do objeto Graph.
 *
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 14/02/2020
 */
public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
