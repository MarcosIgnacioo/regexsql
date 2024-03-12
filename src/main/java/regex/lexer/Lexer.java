package regex.lexer;

import java.util.HashMap;

public class Lexer {

  static HashMap<String, String> keywords = new HashMap<String, String>() {
    {
      put("SELECT", "KEYWORD");
      put("FROM", "KEYWORD");
      put("IN", "KEYWORD");
      put("WHERE", "KEYWORD");
      put("AND", "KEYWORD");
      put("OR", "KEYWORD");
      put("CREATE", "KEYWORD");
      put("TABLE", "KEYWORD");
      put("CHAR", "KEYWORD");
      put("NUMERIC", "KEYWORD");
      put("NOT", "KEYWORD");
      put("NULL", "KEYWORD");
      put("CONSTRAINT", "KEYWORD");
      put("KEY", "KEYWORD");
      put("PRIMARY", "KEYWORD");
      put("FOREIGN", "KEYWORD");
      put("REFERENCES", "KEYWORD");
      put("INSERT", "KEYWORD");
      put("INTO", "KEYWORD");
      put("VALUES", "KEYWORD");

      put(",", "DELIMITER");
      put(".", "DELIMITER");
      put("(", "DELIMITER");
      put(")", "DELIMITER");
      put("'", "DELIMITER");
      put("‘", "DELIMITER");
      put("\"", "DELIMITER");
      put("’", "DELIMITER");

      put("+", "OPERATOR");
      put("*", "OPERATOR");
      put("/", "OPERATOR");
      put("-", "OPERATOR");

      put("=", "RELATIONAL");
      put(">", "RELATIONAL");
      put("<", "RELATIONAL");
      put("<=", "RELATIONAL");
      put(">=", "RELATIONAL");
    }
  };

  public static String MatchWordType(String word) {
    return keywords.get(word);
  }
}
