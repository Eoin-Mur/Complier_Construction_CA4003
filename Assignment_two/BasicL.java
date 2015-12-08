/* Generated By:JJTree&JavaCC: Do not edit this line. BasicL.java */
import java.io.*;
import java.util.*;

public class BasicL/*@bgen(jjtree)*/implements BasicLTreeConstants, BasicLConstants {/*@bgen(jjtree)*/
  protected static JJTBasicLState jjtree = new JJTBasicLState();public static void main(String args[]) throws ParseException, FileNotFoundException
        {

                if (args.length < 1)
    {
      System.out.println("Please pass in the filename.");
      System.exit(1);
    }

                BasicL parser = new BasicL(new FileInputStream(args[0]));

    ASTProgram root = parser.Program();

    System.out.println("Abstract Syntax Tree:");

    root.dump(" ");
        }

/***********************************
***** SECTION 4 - THE GRAMMAR *****
***********************************/
  static final public ASTProgram Program() throws ParseException {
                                 /*@bgen(jjtree) Program */
  ASTProgram jjtn000 = new ASTProgram(JJTPROGRAM);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case CONST:
        case VAR:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        Decl();
      }
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case BOOL:
        case INT:
        case DOUBLE:
        case VOID:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_2;
        }
        Function();
      }
      Main_Prog();
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
          {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
    throw new Error("Missing return statement in function");
  }

  static final public void Decl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR:
      Var_decl();
      break;
    case CONST:
      Const_decl();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Var_decl() throws ParseException {
    jj_consume_token(VAR);
    Ident_list();
    jj_consume_token(TYPE_ASSIGN);
    Type();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      jj_consume_token(COMMA);
      Ident_list();
      jj_consume_token(TYPE_ASSIGN);
      Type();
    }
    jj_consume_token(SEMICOLON);
  }

  static final public void Const_decl() throws ParseException {
    jj_consume_token(CONST);
    Indentifier();
    jj_consume_token(TYPE_ASSIGN);
    Type();
    jj_consume_token(EQUALS_SIGN);
    Expression();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
      jj_consume_token(COMMA);
      Indentifier();
      jj_consume_token(TYPE_ASSIGN);
      Type();
      jj_consume_token(EQUALS_SIGN);
      Expression();
    }
    jj_consume_token(SEMICOLON);
  }

  static final public void Function() throws ParseException {
                             /*@bgen(jjtree) Function */
  ASTFunction jjtn000 = new ASTFunction(JJTFUNCTION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Type();
      Indentifier();
      jj_consume_token(LEFT_BRACKET);
      Param_list();
      jj_consume_token(RIGHT_BRACKET);
      jj_consume_token(BEGIN);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case CONST:
        case VAR:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_5;
        }
        Decl();
      }
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IF:
        case WHILE:
        case BEGIN:
        case ID:
        case SEMICOLON:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_6;
        }
        Statment();
        jj_consume_token(SEMICOLON);
      }
      jj_consume_token(RETURN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FALSE:
      case TRUE:
      case ID:
      case NUM:
      case REAL:
      case LEFT_BRACKET:
        Expression();
        break;
      default:
        jj_la1[7] = jj_gen;

      }
      jj_consume_token(SEMICOLON);
      jj_consume_token(END);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void Param_list() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      Indentifier();
      jj_consume_token(TYPE_ASSIGN);
      Type();
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_7;
        }
        jj_consume_token(COMMA);
        Indentifier();
        jj_consume_token(TYPE_ASSIGN);
        Type();
      }
      break;
    default:
      jj_la1[9] = jj_gen;

    }
  }

  static final public void Type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case DOUBLE:
      jj_consume_token(DOUBLE);
      break;
    case BOOL:
      jj_consume_token(BOOL);
      break;
    case VOID:
      jj_consume_token(VOID);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Main_Prog() throws ParseException {
                          /*@bgen(jjtree) Main */
  ASTMain jjtn000 = new ASTMain(JJTMAIN);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(MAIN);
      jj_consume_token(BEGIN);
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case CONST:
        case VAR:
          ;
          break;
        default:
          jj_la1[11] = jj_gen;
          break label_8;
        }
        Decl();
      }
      label_9:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IF:
        case WHILE:
        case BEGIN:
        case ID:
        case SEMICOLON:
          ;
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_9;
        }
        Statment();
        jj_consume_token(SEMICOLON);
      }
      jj_consume_token(END);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void Statment() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
                  ASTAssign jjtn001 = new ASTAssign(JJTASSIGN);
                  boolean jjtc001 = true;
                  jjtree.openNodeScope(jjtn001);
      try {
        Indentifier();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ASSIGN:
          jj_consume_token(ASSIGN);
          Expression();
          break;
        case LEFT_BRACKET:
          Arg_list();
          break;
        default:
          jj_la1[13] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      } catch (Throwable jjte001) {
                  if (jjtc001) {
                    jjtree.clearNodeScope(jjtn001);
                    jjtc001 = false;
                  } else {
                    jjtree.popNode();
                  }
                  if (jjte001 instanceof RuntimeException) {
                    {if (true) throw (RuntimeException)jjte001;}
                  }
                  if (jjte001 instanceof ParseException) {
                    {if (true) throw (ParseException)jjte001;}
                  }
                  {if (true) throw (Error)jjte001;}
      } finally {
                  if (jjtc001) {
                    jjtree.closeNodeScope(jjtn001,  2);
                  }
      }
      break;
    case BEGIN:
      jj_consume_token(BEGIN);
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IF:
        case WHILE:
        case BEGIN:
        case ID:
        case SEMICOLON:
          ;
          break;
        default:
          jj_la1[14] = jj_gen;
          break label_10;
        }
        Statment();
        jj_consume_token(SEMICOLON);
      }
      jj_consume_token(END);
      break;
    case IF:
      jj_consume_token(IF);
      Condition();
      jj_consume_token(THEN);
      Statment();
      jj_consume_token(SEMICOLON);
      jj_consume_token(ELSE);
      Statment();
      break;
    case WHILE:
      jj_consume_token(WHILE);
      Condition();
      jj_consume_token(DO);
      Statment();
      break;
    default:
      jj_la1[15] = jj_gen;

    }
  }

  static final public void Expression() throws ParseException {
    AddExpression();
  }

  static final public void AddExpression() throws ParseException {
          ASTAdd jjtn001 = new ASTAdd(JJTADD);
          boolean jjtc001 = true;
          jjtree.openNodeScope(jjtn001);
    try {
      MultExpression();
      label_11:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS_SIGN:
        case MINUS_SIGN:
          ;
          break;
        default:
          jj_la1[16] = jj_gen;
          break label_11;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS_SIGN:
          jj_consume_token(PLUS_SIGN);
          break;
        case MINUS_SIGN:
          jj_consume_token(MINUS_SIGN);
          break;
        default:
          jj_la1[17] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        MultExpression();
      }
    } catch (Throwable jjte001) {
          if (jjtc001) {
            jjtree.clearNodeScope(jjtn001);
            jjtc001 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte001 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte001;}
          }
          if (jjte001 instanceof ParseException) {
            {if (true) throw (ParseException)jjte001;}
          }
          {if (true) throw (Error)jjte001;}
    } finally {
          if (jjtc001) {
            jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
          }
    }
  }

  static final public void MultExpression() throws ParseException {
          ASTMult jjtn001 = new ASTMult(JJTMULT);
          boolean jjtc001 = true;
          jjtree.openNodeScope(jjtn001);
    try {
      Fragment();
      label_12:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MULT_SIGN:
        case DIV_SIGN:
          ;
          break;
        default:
          jj_la1[18] = jj_gen;
          break label_12;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MULT_SIGN:
          jj_consume_token(MULT_SIGN);
          break;
        case DIV_SIGN:
          jj_consume_token(DIV_SIGN);
          break;
        default:
          jj_la1[19] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        Fragment();
      }
    } catch (Throwable jjte001) {
          if (jjtc001) {
            jjtree.clearNodeScope(jjtn001);
            jjtc001 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte001 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte001;}
          }
          if (jjte001 instanceof ParseException) {
            {if (true) throw (ParseException)jjte001;}
          }
          {if (true) throw (Error)jjte001;}
    } finally {
          if (jjtc001) {
            jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
          }
    }
  }

  static final public void Fragment() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FALSE:
    case TRUE:
      Bool();
      break;
    case ID:
      Indentifier();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LEFT_BRACKET:
        Arg_list();
        break;
      default:
        jj_la1[20] = jj_gen;
        ;
      }
      break;
    case NUM:
      Number();
      break;
    case REAL:
      jj_consume_token(REAL);
      break;
    case LEFT_BRACKET:
      jj_consume_token(LEFT_BRACKET);
      Expression();
      jj_consume_token(RIGHT_BRACKET);
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void BoolOpp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQUALS_SIGN:
      jj_consume_token(EQUALS_SIGN);
      break;
    case NOT_EQUALS_SIGN:
      jj_consume_token(NOT_EQUALS_SIGN);
      break;
    case LESS_THAN:
      jj_consume_token(LESS_THAN);
      break;
    case GREATER_THAN:
      jj_consume_token(GREATER_THAN);
      break;
    case GREATER_THAN_EQUALS:
      jj_consume_token(GREATER_THAN_EQUALS);
      break;
    case LESS_THAT_EQUALS:
      jj_consume_token(LESS_THAT_EQUALS);
      break;
    case AND:
      jj_consume_token(AND);
      break;
    case OR:
      jj_consume_token(OR);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Condition() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
      jj_consume_token(NOT);
      Condition();
      break;
    case FALSE:
    case TRUE:
    case ID:
    case NUM:
    case REAL:
    case LEFT_BRACKET:
            ASTCondition jjtn001 = new ASTCondition(JJTCONDITION);
            boolean jjtc001 = true;
            jjtree.openNodeScope(jjtn001);
      try {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LEFT_BRACKET:
          jj_consume_token(LEFT_BRACKET);
          break;
        default:
          jj_la1[23] = jj_gen;
          ;
        }
        Expression();
        label_13:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case AND:
          case OR:
          case EQUALS_SIGN:
          case NOT_EQUALS_SIGN:
          case LESS_THAN:
          case GREATER_THAN:
          case LESS_THAT_EQUALS:
          case GREATER_THAN_EQUALS:
            ;
            break;
          default:
            jj_la1[24] = jj_gen;
            break label_13;
          }
          BoolOpp();
          Expression();
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case RIGHT_BRACKET:
            jj_consume_token(RIGHT_BRACKET);
            break;
          default:
            jj_la1[25] = jj_gen;
            ;
          }
        }
      } catch (Throwable jjte001) {
            if (jjtc001) {
              jjtree.clearNodeScope(jjtn001);
              jjtc001 = false;
            } else {
              jjtree.popNode();
            }
            if (jjte001 instanceof RuntimeException) {
              {if (true) throw (RuntimeException)jjte001;}
            }
            if (jjte001 instanceof ParseException) {
              {if (true) throw (ParseException)jjte001;}
            }
            {if (true) throw (Error)jjte001;}
      } finally {
            if (jjtc001) {
              jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
            }
      }
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Ident_list() throws ParseException {
    Indentifier();
    label_14:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[27] = jj_gen;
        break label_14;
      }
      jj_consume_token(COMMA);
      Indentifier();
    }
  }

  static final public void Arg_list() throws ParseException {
    jj_consume_token(LEFT_BRACKET);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      Indentifier();
      label_15:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[28] = jj_gen;
          break label_15;
        }
        jj_consume_token(COMMA);
        Indentifier();
      }
      break;
    default:
      jj_la1[29] = jj_gen;

    }
    jj_consume_token(RIGHT_BRACKET);
  }

  static final public void Indentifier() throws ParseException {
                          /*@bgen(jjtree) Id */
                           ASTId jjtn000 = new ASTId(JJTID);
                           boolean jjtc000 = true;
                           jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(ID);
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    jjtn000.setName(t.image);
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void Number() throws ParseException {
                      /*@bgen(jjtree) Num */
                       ASTNum jjtn000 = new ASTNum(JJTNUM);
                       boolean jjtc000 = true;
                       jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(NUM);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
                jjtn000.setName(t.image);
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void Bool() throws ParseException {
                      /*@bgen(jjtree) Bool */
  ASTBool jjtn000 = new ASTBool(JJTBOOL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TRUE:
        jj_consume_token(TRUE);
        break;
      case FALSE:
        jj_consume_token(FALSE);
        break;
      default:
        jj_la1[30] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
                  if (jjtc000) {
                    jjtree.closeNodeScope(jjtn000, true);
                  }
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public BasicLTokenManager token_source;
  static JavaCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[31];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x4002000,0x80c1000,0x4002000,0x0,0x0,0x4002000,0xb0020000,0x82010000,0x0,0x80000000,0x80c1000,0x4002000,0xb0020000,0x0,0xb0020000,0xb0020000,0x0,0x0,0x0,0x0,0x0,0x82010000,0x400800,0x0,0x400800,0x0,0x82210000,0x0,0x0,0x80000000,0x2010000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x10000,0x10000,0x0,0x20000,0x4006,0x10000,0x0,0x0,0x0,0x20000,0x84000,0x20000,0x0,0x30,0x30,0xc0,0xc0,0x4000,0x4006,0x3f00,0x4000,0x3f00,0x8000,0x4006,0x10000,0x10000,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public BasicL(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public BasicL(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new BasicLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public BasicL(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new BasicLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public BasicL(BasicLTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(BasicLTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[53];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 31; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 53; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
