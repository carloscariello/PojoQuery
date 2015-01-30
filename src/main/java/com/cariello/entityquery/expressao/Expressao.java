package com.cariello.entityquery.expressao;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Carlos Cariello F1765038
 */
public class Expressao {
    private Object campo;
    private Operador operador;
    private Object valor;
    
    private final SimpleDateFormat fmtMySQL = new SimpleDateFormat("yyyy-MM-dd");
    

    public Operador getOperador() {
        return operador;
    }
    
    public static Expressao getExpressao(String campo, Operador operador, Object valor) {
        Expressao expressao = new Expressao();
        expressao.setCampo(campo);
        expressao.setOperador(operador);
        expressao.setValor(valor);
        return expressao;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public static Expressao e( Expressao...expressaoArgs ){
        ExpressaoConjuncao conjuncao = new ExpressaoConjuncao();
        conjuncao.setExpressaoList(Arrays.asList(expressaoArgs));
        return conjuncao; 
    }
    
    public static Expressao ou( Expressao...expressaoArgs ){
        ExpressaoDisjuncao disjuncao = new ExpressaoDisjuncao();
        disjuncao.setExpressaoList(Arrays.asList(expressaoArgs));
        return disjuncao; 
    }
    
    @Override
    public String toString() {
        String format = String.format("(%s %s %s)", campo.toString(), operador.getTextoSQL(), formataParametro(valor) );
        return String.format( format );
    }

    private String formataParametro(Object o){
        if ( o instanceof Collection ){
            Collection<?> collection = (Collection<?>) o;
            String csvList = "";
            for ( Object item : collection ){
                csvList += formataParametro( item ) + ",";
            }
            return String.format("(%s)",  csvList.subSequence(0, csvList.lastIndexOf(",") - 1).toString() );
        } else if ( o instanceof Date ){
            return String.format("'%s'", fmtMySQL.format( o ) );
        } else if ( o instanceof String ){
            return String.format( "'%s'", o.toString().replaceAll("'", "") ).replaceAll("\"", "\\\"");
        } 
        
        return o.toString();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.campo);
        hash = 53 * hash + Objects.hashCode(this.operador);
        hash = 53 * hash + Objects.hashCode(this.valor);
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
        final Expressao other = (Expressao) obj;
        if (!Objects.equals(this.campo, other.campo)) {
            return false;
        }
        if (this.operador != other.operador) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }

    public Object getCampo() {
        return campo;
    }

    public void setCampo(Object campo) {
        this.campo = campo;
    }
    
    
}
