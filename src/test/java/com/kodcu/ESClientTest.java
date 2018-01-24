package com.kodcu;

import com.kodcu.dao.QueryDAO;
import com.kodcu.entity.Document;
import com.kodcu.prop.ConfigProps;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticSearchStarter.class)
@ActiveProfiles("test")
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ESClientTest {

    @Autowired
    private ConfigProps props;

    @Autowired
    private QueryDAO dao;

    private Document doc = new Document(null, "first", "last", "Hello!");

    @Test
    public void testA() throws IOException {
        assertNotNull(dao.createIndex(doc));
        dao.flush();
    }

    @Test
    public void testD() throws IOException {
        List<Document> documentList = dao.wildcardQuery("hello");
        documentList.forEach(doc -> dao.deleteDocument(doc.getId()));
        dao.flush();
        assertTrue(dao.matchAllQuery().isEmpty());
    }

    @Test
    public void testB(){
        assertFalse(dao.matchAllQuery().isEmpty());
    }

    @Test
    public void testC(){
        assertFalse(dao.wildcardQuery("hello").isEmpty());
    }

}
