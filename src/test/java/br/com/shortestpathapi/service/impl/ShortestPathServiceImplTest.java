package br.com.shortestpathapi.service.impl;

import br.com.shortestpathapi.model.Graph;
import br.com.shortestpathapi.model.Node;
import br.com.shortestpathapi.model.NodeDomain;
import br.com.shortestpathapi.model.NodeOrigemDestinationEntity;
import br.com.shortestpathapi.repository.NodeDomainRepository;
import br.com.shortestpathapi.repository.NodeEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 14/02/2020
 */
@SpringBootTest
public class ShortestPathServiceImplTest {

    @InjectMocks
    private ShortestPathServiceImpl shortestPathService;

    @Mock
    private NodeEntityRepository nodeEntityRepository;

    @Mock
    private NodeDomainRepository nodeDomainRepository;

    private List<NodeDomain> nodes = new ArrayList<>();

    private List<NodeOrigemDestinationEntity> nodeOrigemDestinationEntities = new ArrayList<>();

    @BeforeEach
    public void init() {
        NodeDomain nodeA = new NodeDomain("A");
        NodeDomain nodeB = new NodeDomain("B");
        NodeDomain nodeC = new NodeDomain("C");
        NodeDomain nodeD = new NodeDomain("D");
        NodeDomain nodeE = new NodeDomain("E");

        nodes = Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE);

        NodeOrigemDestinationEntity config1 = new NodeOrigemDestinationEntity("A", "B", 10, nodeA);
        NodeOrigemDestinationEntity config2 = new NodeOrigemDestinationEntity("B", "D", 15, nodeB);
        NodeOrigemDestinationEntity config3 = new NodeOrigemDestinationEntity("A", "C", 20, nodeA);
        NodeOrigemDestinationEntity config4 = new NodeOrigemDestinationEntity("C", "D", 30, nodeC);
        NodeOrigemDestinationEntity config5 = new NodeOrigemDestinationEntity("B", "E", 50, nodeB);
        NodeOrigemDestinationEntity config6 = new NodeOrigemDestinationEntity("D", "E", 30, nodeD);

        nodeOrigemDestinationEntities = Arrays.asList(config1, config2, config3, config4, config5, config6);
    }

    @Test
    public void testCalculateShortestPathFromSource() {

        when(this.nodeDomainRepository.findAll()).thenReturn(nodes);
        when(this.nodeEntityRepository.findAll()).thenReturn(nodeOrigemDestinationEntities);

        Optional<Graph> optionalGraph = this.shortestPathService.calculateShortestPathFromSource("A");

        assertTrue(optionalGraph.isPresent());
        assertNotNull(optionalGraph.get(), "Should not be null!");
    }
}
