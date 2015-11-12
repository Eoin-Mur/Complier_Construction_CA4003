/* Generated By:JavaCC: Do not edit this line. BASICLInterpreter.java */
public class BASICLInterpreter implements BASICLInterpreterConstants {
        public static void main(String args[])
        {
                BASICLInterpreter interpreter;
                if (args.length == 0)
                {
                        System.out.println("BASICL Interpreter:  Reading from standard input...");
                        interpreter = new BASICLInterpreter(System.in);
                }
                else if (args.length == 1)
                {
                        System.out.println("BASICL Interpreter:  Reading from file " + args[0] + "...");
                        try
                        {
                                interpreter = new BASICLInterpreter(new java.io.FileInputStream(args[0]));
                        }
                        catch (java.io.FileNotFoundException e)
                        {
                                System.out.println("BASICL Interpreter:  File " + args[0] + " not found.");
                                return;
                        }
                }
                else
                {
                        System.out.println("BASICL Interpreter:  Usage is one of:");
                        System.out.println("         java BASICLInterpreter < inputfile");
                        System.out.println("OR");
                        System.out.println("         java BASICLInterpreter inputfile");
                        return;
                }
                try
                {
                        interpreter.Program();
                        System.out.println("BASICL Interpreter: File parse succesfull!");
                }
                catch (ParseException e)
                {
                        System.out.println(e.getMessage());
                        System.out.println("BASICL Interpreter:  Encountered errors during parse.");
                }
        }

/***********************************
***** SECTION 4 - THE GRAMMAR *****
***********************************/
  static final public void Program() throws ParseException {
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
    jj_consume_token(ID);
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
      jj_consume_token(ID);
      jj_consume_token(TYPE_ASSIGN);
      Type();
      jj_consume_token(EQUALS_SIGN);
      Expression();
    }
    jj_consume_token(SEMICOLON);
  }

  static final public void Function() throws ParseException {
    Type();
    jj_consume_token(ID);
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
    case PLUS_SIGN:
    case MINUS_SIGN:
    case LEFT_BRACKET:
      Expression();
      break;
    default:
      jj_la1[7] = jj_gen;

    }
    jj_consume_token(SEMICOLON);
    jj_consume_token(END);
  }

  static final public void Param_list() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
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
        jj_consume_token(ID);
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
  }

  static final public void Statment() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASSIGN:
        jj_consume_token(ASSIGN);
        Expression();
        break;
      case LEFT_BRACKET:
        jj_consume_token(LEFT_BRACKET);
        Arg_list();
        jj_consume_token(RIGHT_BRACKET);
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
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
    if (jj_2_1(2)) {
      jj_consume_token(ID);
      jj_consume_token(LEFT_BRACKET);
      Arg_list();
      jj_consume_token(RIGHT_BRACKET);
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FALSE:
      case TRUE:
      case ID:
      case NUM:
      case PLUS_SIGN:
      case MINUS_SIGN:
      case LEFT_BRACKET:
        Expression1();
        label_11:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PLUS_SIGN:
          case MINUS_SIGN:
          case MULT_SIGN:
          case DIV_SIGN:
            ;
            break;
          default:
            jj_la1[16] = jj_gen;
            break label_11;
          }
          Opp();
          Expression1();
        }
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Expression1() throws ParseException {
    Fragment();
  }

  static final public void Opp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS_SIGN:
      jj_consume_token(PLUS_SIGN);
      break;
    case MINUS_SIGN:
      jj_consume_token(MINUS_SIGN);
      break;
    case MULT_SIGN:
      jj_consume_token(MULT_SIGN);
      break;
    case DIV_SIGN:
      jj_consume_token(DIV_SIGN);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Fragment() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      break;
    case TRUE:
      jj_consume_token(TRUE);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    case NUM:
      jj_consume_token(NUM);
      break;
    case PLUS_SIGN:
    case MINUS_SIGN:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS_SIGN:
        jj_consume_token(PLUS_SIGN);
        break;
      case MINUS_SIGN:
        jj_consume_token(MINUS_SIGN);
        break;
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case LEFT_BRACKET:
      jj_consume_token(LEFT_BRACKET);
      Expression();
      jj_consume_token(RIGHT_BRACKET);
      break;
    default:
      jj_la1[20] = jj_gen;
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
    case PLUS_SIGN:
    case MINUS_SIGN:
    case LEFT_BRACKET:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LEFT_BRACKET:
        jj_consume_token(LEFT_BRACKET);
        break;
      default:
        jj_la1[21] = jj_gen;
        ;
      }
      Expression();
      label_12:
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
          jj_la1[22] = jj_gen;
          break label_12;
        }
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
          jj_la1[23] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        Expression();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case RIGHT_BRACKET:
          jj_consume_token(RIGHT_BRACKET);
          break;
        default:
          jj_la1[24] = jj_gen;
          ;
        }
      }
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Ident_list() throws ParseException {
    jj_consume_token(ID);
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[26] = jj_gen;
        break label_13;
      }
      jj_consume_token(COMMA);
      jj_consume_token(ID);
    }
  }

  static final public void Arg_list() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
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
        jj_consume_token(ID);
      }
      break;
    default:
      jj_la1[28] = jj_gen;

    }
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_3_1() {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(LEFT_BRACKET)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public BASICLInterpreterTokenManager token_source;
  static JavaCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[29];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2002000,0x4041000,0x2002000,0x0,0x0,0x2002000,0x58020000,0x41010000,0x0,0x40000000,0x4041000,0x2002000,0x58020000,0x0,0x58020000,0x58020000,0x0,0x41010000,0x0,0x0,0x41010000,0x0,0x200800,0x200800,0x0,0x41110000,0x0,0x0,0x40000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x4000,0x4000,0x0,0x8000,0x100d,0x4000,0x0,0x0,0x0,0x8000,0x21000,0x8000,0x0,0x3c,0x100d,0x3c,0xc,0x100d,0x1000,0xfc0,0xfc0,0x2000,0x100d,0x4000,0x4000,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[1];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public BASICLInterpreter(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public BASICLInterpreter(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new BASICLInterpreterTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
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
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public BASICLInterpreter(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new BASICLInterpreterTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public BASICLInterpreter(BASICLInterpreterTokenManager tm) {
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
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(BASICLInterpreterTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
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
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[51];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 29; i++) {
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
    for (int i = 0; i < 51; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
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

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
