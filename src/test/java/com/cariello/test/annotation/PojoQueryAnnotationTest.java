package com.cariello.test.annotation;

import com.cariello.entityquery.anotacao.ConsultaEntidade;
import com.cariello.test.modelos.ClassAnnotationTest;
import java.lang.annotation.Annotation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos
 */
public class PojoQueryAnnotationTest {
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void testTableAnnotation() {
        Class<?> clazz = ClassAnnotationTest.class;
        
        assertTrue (clazz.isAnnotationPresent(ConsultaEntidade.class ) );
        
        Annotation annotation = clazz.getAnnotation(ConsultaEntidade.class );
        ConsultaEntidade pojoQuery = (ConsultaEntidade) annotation;

        assertEquals("tabela1", pojoQuery.tableName() );

     }
}
