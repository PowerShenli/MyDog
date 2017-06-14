package org.huangpu.mydog.core.grammar;


import org.huangpu.mydog.core.Grammar;
import org.huangpu.mydog.core.enums.OutputFormat;

/**
 * Created by shenli on 2017/4/9.
 */
public class GrammarFactory {

    public static Grammar buildGrammar(OutputFormat format) {
        switch (format) {
            case JAVA:
                return new JavaGrammar();
            case XML:
                return new XmlGrammar();
            case HTML:
                return new HtmlGrammar();
            case PROPERTIES:
                return new PropertiesGrammar();
            case SQL:
                return new DDLGrammar();
        }
        return null;
    }
}
