package jp.s6n.idea.ghactions.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static jp.s6n.idea.ghactions.lang.WorkflowInlineTypes.*;

%%

%{
  public _WorkflowInlineLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _WorkflowInlineLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
INTEGER=[0-9]+
NUMBER=-?[0-9]+(\.[0-9]+)?(e-?[0-9]+)?
ID=[:letter:][a-zA-Z_0-9]*
STRING='([^']|'')*'

%%
<YYINITIAL> {
  {WHITE_SPACE}       { return WHITE_SPACE; }

  ","                 { return OP_COMMA; }
  "."                 { return OP_DOT; }
  "!"                 { return OP_NOT; }
  "<"                 { return OP_LT; }
  "<="                { return OP_LTE; }
  ">"                 { return OP_GT; }
  ">="                { return OP_GTE; }
  "=="                { return OP_EQ; }
  "!="                { return OP_NE; }
  "&&"                { return OP_AND; }
  "||"                { return OP_OR; }
  "["                 { return LEFT_BRACKET; }
  "]"                 { return RIGHT_BRACKET; }
  "("                 { return LEFT_PAREN; }
  ")"                 { return RIGHT_PAREN; }
  "null"              { return NULL; }
  "true"              { return TRUE; }
  "false"             { return FALSE; }

  {SPACE}             { return SPACE; }
  {INTEGER}           { return INTEGER; }
  {NUMBER}            { return NUMBER; }
  {ID}                { return ID; }
  {STRING}            { return STRING; }

}

[^] { return BAD_CHARACTER; }
