
import com.cariello.entityquery.anotacao.Campo;
import com.cariello.entityquery.anotacao.ConsultaEntidade;
import com.cariello.test.modelos.ClassAnnotationTest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


/**
 *
 * @author Carlos
 */
public class avulso {
     public static void main(String...args){
         Class<?> clazz = ClassAnnotationTest.class;
         
         if ( clazz.isAnnotationPresent(ConsultaEntidade.class ) ){
             Annotation annotation = clazz.getAnnotation(ConsultaEntidade.class );
             ConsultaEntidade pojoQuery = (ConsultaEntidade) annotation;
             System.out.println( pojoQuery.tableName() );
             
             for (Field field : clazz.getFields() ){
                 if ( field.isAnnotationPresent( Campo.class ) ){
                     Annotation annCampo = field.getAnnotation( Campo.class );
                     Campo campo = (Campo) annCampo;
                     System.out.println( campo.nomeCampo() );
                 }
             }
         }
     }
}
