/* Generated By:JavaCC: Do not edit this line. MELArulesConstants.java */
package ParserRulesFarms;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface MELArulesConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int INTEGER = 7;
  /** RegularExpression Id. */
  int FLOAT = 8;
  /** RegularExpression Id. */
  int FLOAT_SCIENTIFIC = 9;
  /** RegularExpression Id. */
  int EXPONENT = 10;
  /** RegularExpression Id. */
  int LETTER = 11;
  /** RegularExpression Id. */
  int DIGIT = 12;
  /** RegularExpression Id. */
  int WORD = 13;
  /** RegularExpression Id. */
  int SECTION_NAME = 14;
  /** RegularExpression Id. */
  int SECTION_FOCUS = 15;
  /** RegularExpression Id. */
  int SECTION_RUN = 16;
  /** RegularExpression Id. */
  int SECTION_STEP = 17;
  /** RegularExpression Id. */
  int KEYWORD_ACTIVE = 18;
  /** RegularExpression Id. */
  int KEYWORD_PASSIVE = 19;
  /** RegularExpression Id. */
  int KEYWORD_NOINF = 20;
  /** RegularExpression Id. */
  int KEYWORD_TIME = 21;
  /** RegularExpression Id. */
  int KEYWORD_BOUNDARY = 22;
  /** RegularExpression Id. */
  int KEYWORD_PERIODIC = 23;
  /** RegularExpression Id. */
  int KEYWORD_BOUNCING = 24;
  /** RegularExpression Id. */
  int KEYWORD_FIXED = 25;
  /** RegularExpression Id. */
  int KEYWORD_POPULATION = 26;
  /** RegularExpression Id. */
  int KEYWORD_POPLOC = 27;
  /** RegularExpression Id. */
  int KEYWORD_ACTION = 28;
  /** RegularExpression Id. */
  int WORD_TIME = 29;
  /** RegularExpression Id. */
  int EOL = 30;
  /** RegularExpression Id. */
  int PLUS = 31;
  /** RegularExpression Id. */
  int DOT = 32;
  /** RegularExpression Id. */
  int SEMICOLON = 33;
  /** RegularExpression Id. */
  int DEFINE = 34;
  /** RegularExpression Id. */
  int ASSIGN = 35;
  /** RegularExpression Id. */
  int LSQ = 36;
  /** RegularExpression Id. */
  int RSQ = 37;
  /** RegularExpression Id. */
  int LR = 38;
  /** RegularExpression Id. */
  int RR = 39;
  /** RegularExpression Id. */
  int QUO = 40;
  /** RegularExpression Id. */
  int SQUO = 41;
  /** RegularExpression Id. */
  int EXCL = 42;
  /** RegularExpression Id. */
  int LBRAC = 43;
  /** RegularExpression Id. */
  int RBRAC = 44;
  /** RegularExpression Id. */
  int COMMA = 45;
  /** RegularExpression Id. */
  int LANG = 46;
  /** RegularExpression Id. */
  int RANG = 47;
  /** RegularExpression Id. */
  int PARALLEL = 48;
  /** RegularExpression Id. */
  int DASH = 49;
  /** RegularExpression Id. */
  int UP = 50;
  /** RegularExpression Id. */
  int DOWN = 51;
  /** RegularExpression Id. */
  int INT = 52;
  /** RegularExpression Id. */
  int DOUBLE = 53;
  /** RegularExpression Id. */
  int IDENTIFIER = 54;
  /** RegularExpression Id. */
  int MATH_EXPR = 55;
  /** RegularExpression Id. */
  int SPACE = 56;
  /** RegularExpression Id. */
  int M_AND = 57;
  /** RegularExpression Id. */
  int M_OR = 58;
  /** RegularExpression Id. */
  int M_LINER = 59;
  /** RegularExpression Id. */
  int M_LINEN = 60;
  /** RegularExpression Id. */
  int SYMBOL = 61;
  /** RegularExpression Id. */
  int PARAM_SYMBOL = 62;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int RESET = 1;
  /** Lexical state. */
  int ID = 2;
  /** Lexical state. */
  int MATH = 3;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "<token of kind 5>",
    "<token of kind 6>",
    "<INTEGER>",
    "<FLOAT>",
    "<FLOAT_SCIENTIFIC>",
    "<EXPONENT>",
    "<LETTER>",
    "<DIGIT>",
    "<WORD>",
    "\"#Action\"",
    "\"#Focus\"",
    "\"#Runs\"",
    "\"#Time-step\"",
    "\"a\"",
    "\"p\"",
    "\"/\"",
    "\"#Time\"",
    "\"#Boundary\"",
    "\"Periodic\"",
    "\"Bouncing\"",
    "\"Fixed\"",
    "\"#Population\"",
    "\"#Pop_Loc\"",
    "\"#ActionCount\"",
    "\"time\"",
    "\";\"",
    "\"+\"",
    "\".\"",
    "\":\"",
    "\":=\"",
    "\"=\"",
    "\"[\"",
    "\"]\"",
    "\"(\"",
    "\")\"",
    "\"\\\"\"",
    "\"\\\'\"",
    "\"!\"",
    "\"{\"",
    "\"}\"",
    "\",\"",
    "\"<\"",
    "\">\"",
    "\"||\"",
    "\"-\"",
    "\">>\"",
    "\"<<\"",
    "<INT>",
    "<DOUBLE>",
    "<IDENTIFIER>",
    "<MATH_EXPR>",
    "<SPACE>",
    "\"&&\"",
    "\"|\"",
    "\"\\r\"",
    "\"\\n\"",
    "<SYMBOL>",
    "<PARAM_SYMBOL>",
  };

}
