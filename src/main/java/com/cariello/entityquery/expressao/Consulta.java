package com.cariello.entityquery.expressao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Carlos Cariello F1765038
 */
public abstract class Consulta {
    protected static final String SEPARADOR = " ";
   
    protected Consulta() {
    }

    public String getSQL() {
        return getSQLBase() + getSQLJoins() + getSQLCondicoes() + SEPARADOR + getClausulaGroupBy() + SEPARADOR + getClausulaOrderBy();
    }
    
    private String getSQLJoins(){
        String joins = "";
        for (Map.Entry<Class<?>, String> entry : getJoinMap().entrySet()) {
            joins += SEPARADOR + entry.getValue() + SEPARADOR;
        }
        return joins;
    }
    
    private String getClausulaGroupBy(){
        String str = "";
        for ( String s : getGroupByList() ){
            str += s + ", ";
        }
        str = str.substring(0, str.lastIndexOf(",") );
        return str.equals("")? str : SEPARADOR + "GROUP BY" + SEPARADOR + str;
    }
    
    private String getClausulaOrderBy(){
        String str = "";
        for ( String s : getOrderByList() ){
            str += s + ", ";
        }
        str = str.substring(0, str.lastIndexOf(",") );
        return str.equals("")? str : SEPARADOR + "ORDER BY" + SEPARADOR + str;
    }
    
    private String getSQLCondicoes() {
        ExpressaoConjuncao condicoes = new ExpressaoConjuncao();
        condicoes.setExpressaoList( getExpressaoList());
        return ( condicoes.getExpressaoList().size() > 0 )? SEPARADOR + "WHERE" + SEPARADOR + condicoes.toString() : "";
    }
    
    public abstract String getSQLBase();
    public abstract Class<?> getClasseResultado();
    public abstract List<String> getGroupByList();
    public abstract List<String> getOrderByList();
    public abstract List<Expressao> getExpressaoList();
    public abstract Map< Class<?>, String> getJoinMap();
    
}
