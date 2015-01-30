package com.cariello.entityquery.expressao;

/**
 *
 * @author Carlos Cariello F1765038
 */
public enum Operador implements OperadorStrategy{
    IGUAL {
        @Override
        public String getTextoSQL() {
            return "=";
        }
        
    },
    MAIOR_OU_IGUAL{
        @Override
        public String getTextoSQL() {
            return ">=";
        }
    },
    MENOR_OU_IGUAL{
        @Override
        public String getTextoSQL() {
            return "<=";
        }
    },
    DIFERENTE{
        @Override
        public String getTextoSQL() {
            return "!=";
        }
    },
    E{
        @Override
        public String getTextoSQL() {
            return "AND";
        }
    },
    OU{
        @Override
        public String getTextoSQL() {
            return "OR";
        }
    },
    LIKE {

        @Override
        public String getTextoSQL() {
            return "LIKE";
        }
        
    },
    IN {

        @Override
        public String getTextoSQL() {
            return "IN";
        }
        
    },
    NOT_IN{

        @Override
        public String getTextoSQL() {
            return "NOT IN";
        }
        
    }
}
