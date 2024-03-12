package regex.main;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import regex.lexer.Lexer;

public class Main {

  public static void main(String[] args) {
    String txt = "SELECT ANOMBRE, CALIFICACION , TURNO\n" +
        "FROM ALUMNOS, INSCRITOS, MATERIAS, CARRERAS\n" +
        "WHERE MNOMBRE=’LENAUT2’ AND TURNO = ‘TM’\n" +
        "AND CNOMBRE=’ISC’ AND SEMESTRE=’2023I’ AND CALIFICACION >= 70\n" +
        "\n" +
        "SELECT *\n" +
        "FROM PROFESORES\n" +
        "WHERE EDAD >45 AND GRADO='MAE' OR GRADO='DOC'\n" +
        "\n" +
        "SELECT ANOMBRE\n" +
        "FROM ALUMNOS,INSCRITOS,CARRERAS\n" +
        "WHERE ALUMNOS.A#=INSCRITOS.A# AND ALUMNOS.C#=CARRERAS.C<#\n" +
        "AND INSCRITOS.SEMESTRE='2010I'\n" +
        "AND CARRERAS.CNOMBRE='ISC'\n" +
        "AND ALUMNOS.GENERACION='2010'\n" +
        "\n" +
        "SELECT ANOMBRE\n" +
        "FROM ALUMNOS A,INSCRITOS I,CARRERAS C\n" +
        "WHERE A.A#=I.A# AND A.C#=C.C# AND I.SEMESTRE='2010I'\n" +
        "AND C.CNOMBRE='ISC' AND A.GENERACION='2010'\n" +
        "\n" +
        "SELECT MNOMBRE, CNOMBRE\n" +
        "FROM CARRERAS C,DEPARTAMENTOS D,MATERIAS M\n" +
        "WHERE C.C#=M.C# AND C.D#=D.D# AND D.DNOMBRE='CIECOM'\n" +
        "\n" +
        "SELECT M#,MNOMBRE\n" +
        "FROM MATERIAS\n" +
        "WHERE M# IN (SELECT M#\n" +
        "FROM INSCRITOS\n" +
        "WHERE A# IN (SELECT A#\n" +
        "FROM ALUMNOS\n" +
        "WHERE ANOMBRE='MESSI@ LIONEL'))\n" +
        "\n" +
        "SELECT ANOMBRE, CALIFICACION, TURNO\n" +
        "FROM ALUMNOS, INSCRITOS, MATERIAS, CARRERAS\n" +
        "WHERE MNOMBRE=’LENAUT2’ AND TURNO = ‘TM’\n" +
        "AND CNOMBRE=’ISC’ AND SEMESTRE=’%@!$2$#\\()%02-_3?{}[]I’ AND CALIFICACION >= 70\n";
    // Version de regex antigua que jala bien solamente que da este peque;o error
    //
    // MISFIT: MNOMBRE=
    //
    // String regex =
    // "([‘’'][\\d*a-zA-Z?]*['’])?,?([a-zA-Z.?#?\\d]*)\\.?(<?>?=?\\*?)";
    // Esta funciona nomas que cuando hay 3 espacios truena
    // String regex = "'\\b\\w+ \\w+\\b'|\\b\\w+\\b|(,|.)";
    //
    // est afunciona con messi
    String regex = "(‘|’|') ?[a-zA-Z@!\\$\\%#\\\\\\(\\)_\\-0-9\\[\\]\\{\\} ?]*(’|'|‘)|\\b\\w+\\b|(,|.)";
    // ------------------------------------------v-- el =?lopusakiibaaca----v
    // String regex = "(([‘’'][\\d*a-zA-Z
    // ?]*['’])?([a-zA-Z.?#?\\d]*)(<?>?=?\\*?)|(.?,?))?";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(txt);
    ArrayList<String> words = new ArrayList<>();

    while (matcher.find()) {
      if (!matcher.group().isBlank()) {
        words.add(matcher.group());
      }
    }

    for (String word : words) {
      String category = Lexer.MatchWordType(word);
      System.out.println("MISFIT: " + word);
    }
  }
}
