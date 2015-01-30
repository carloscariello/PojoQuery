package com.cariello.entityquery.expressao;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Carlos Cariello F1765038
 */
public class ExpressaoDisjuncao extends Expressao{
    private static final Operador operador = Operador.OU;
    private List<Expressao> expressaoList;
   
    @Override
    public String toString() {
        String retorno = "";
        for (Expressao expressao : expressaoList) {
            retorno += String.format("%s %s ", expressao.toString(), operador.getTextoSQL() );
        }
        retorno = retorno.substring(0, retorno.lastIndexOf( operador.getTextoSQL() ) -1 );
        retorno = retorno.equals("")? retorno : String.format("(%s)", retorno);
        return retorno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.expressaoList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExpressaoDisjuncao other = (ExpressaoDisjuncao) obj;
        if (!Objects.equals(this.expressaoList, other.expressaoList)) {
            return false;
        }
        return true;
    }

    
    
    public List<Expressao> getExpressaoList() {
        return expressaoList;
    }

    public void setExpressaoList(List<Expressao> expressaoList) {
        this.expressaoList = expressaoList;
    }
}
