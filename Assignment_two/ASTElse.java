/* Generated By:JJTree: Do not edit this line. ASTElse.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTElse extends SimpleNode {
  public ASTElse(int id) {
    super(id);
  }

  public ASTElse(BasicL p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicLVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=8fc82d9a34398f931392f6040e4305b7 (do not edit this line) */
