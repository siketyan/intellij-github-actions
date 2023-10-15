// This is a generated file. Not intended for manual editing.
package jp.s6n.idea.ghactions.lang;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static jp.s6n.idea.ghactions.lang.WorkflowInlineTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class WorkflowInlineParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return expression(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(LITERAL, NUMBER_LITERAL, STRING_LITERAL),
  };

  /* ********************************************************** */
  // ident LEFT_PAREN (expression OP_COMMA)* expression RIGHT_PAREN
  public static boolean call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && call_2(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, CALL, r);
    return r;
  }

  // (expression OP_COMMA)*
  private static boolean call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!call_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "call_2", c)) break;
    }
    return true;
  }

  // expression OP_COMMA
  private static boolean call_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OP_LTE | OP_LT | OP_GTE | OP_GT | OP_EQ | OP_NE | OP_AND | OP_OR
  public static boolean condition_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION_OPERATOR, "<condition operator>");
    r = consumeToken(b, OP_LTE);
    if (!r) r = consumeToken(b, OP_LT);
    if (!r) r = consumeToken(b, OP_GTE);
    if (!r) r = consumeToken(b, OP_GT);
    if (!r) r = consumeToken(b, OP_EQ);
    if (!r) r = consumeToken(b, OP_NE);
    if (!r) r = consumeToken(b, OP_AND);
    if (!r) r = consumeToken(b, OP_OR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // operation | simple_expr
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = operation(b, l + 1);
    if (!r) r = simple_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PAREN expression RIGHT_PAREN
  public static boolean group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "group")) return false;
    if (!nextTokenIs(b, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, GROUP, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean ident(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ident")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, IDENT, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACKET integer RIGHT_BRACKET
  public static boolean indexer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexer")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFT_BRACKET, INTEGER, RIGHT_BRACKET);
    exit_section_(b, m, INDEXER, r);
    return r;
  }

  /* ********************************************************** */
  // NULL | TRUE | FALSE | number_literal | string_literal
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, LITERAL, "<literal>");
    r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = number_literal(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_NOT simple_expr
  public static boolean negate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negate")) return false;
    if (!nextTokenIs(b, OP_NOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_NOT);
    r = r && simple_expr(b, l + 1);
    exit_section_(b, m, NEGATE, r);
    return r;
  }

  /* ********************************************************** */
  // integer | number
  public static boolean number_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal")) return false;
    if (!nextTokenIs(b, "<number literal>", INTEGER, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_LITERAL, "<number literal>");
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // simple_expr condition_operator expression
  public static boolean operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATION, "<operation>");
    r = simple_expr(b, l + 1);
    r = r && condition_operator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ident (indexer | (OP_DOT qualifier))?
  public static boolean qualifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifier")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && qualifier_1(b, l + 1);
    exit_section_(b, m, QUALIFIER, r);
    return r;
  }

  // (indexer | (OP_DOT qualifier))?
  private static boolean qualifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifier_1")) return false;
    qualifier_1_0(b, l + 1);
    return true;
  }

  // indexer | (OP_DOT qualifier)
  private static boolean qualifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifier_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indexer(b, l + 1);
    if (!r) r = qualifier_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_DOT qualifier
  private static boolean qualifier_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifier_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_DOT);
    r = r && qualifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // negate | call | group | qualifier | literal
  public static boolean simple_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_EXPR, "<simple expr>");
    r = negate(b, l + 1);
    if (!r) r = call(b, l + 1);
    if (!r) r = group(b, l + 1);
    if (!r) r = qualifier(b, l + 1);
    if (!r) r = literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // string
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

}
