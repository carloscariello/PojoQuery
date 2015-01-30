package com.cariello.test.modelos;

import com.cariello.entityquery.anotacao.Campo;
import com.cariello.entityquery.anotacao.ConsultaEntidade;

/**
 *
 * @author Carlos
 */
@ConsultaEntidade(tableName = "tabela1")
public class ClassAnnotationTest {
    @Campo(nomeCampo = "campoString")
    public String campoString;
}
