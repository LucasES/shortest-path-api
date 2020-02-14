package br.com.shortestpathapi.util;

import br.com.shortestpathapi.model.Graph;
import br.com.shortestpathapi.model.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 14/02/2020
 */
@SpringBootTest
public class DijkstraUtilTest {

    private Node nodeInitial = new Node("A");
    private Graph graph = new Graph();

    @BeforeEach
    void init() {
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeInitial.addDestination(nodeB, 10);
        nodeInitial.addDestination(nodeC, 20);

        nodeB.addDestination(nodeD, 15);
        nodeB.addDestination(nodeE, 50);

        nodeC.addDestination(nodeD, 30);

        nodeD.addDestination(nodeE, 30);

        graph.addNode(nodeInitial);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
    }

    @Test
    public void testDijkstraUtil() {
        DijkstraUtil.calculateShortestPathFromSource(this.graph, nodeInitial);
        List<Node> nodeList = new ArrayList<>(this.graph.getNodes());

        Node actual = nodeList.get(0);
        assertNotNull(actual, "Should not be null!");
        assertNotEquals(Integer.MAX_VALUE, actual.getDistance(), "Should be different distance!");
    }
}
