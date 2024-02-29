// This is a generated file. Not intended for manual editing.
package jp.s6n.idea.ghactions.lang;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import jp.s6n.idea.ghactions.lang.psi.impl.*;

public interface WorkflowInlineTypes {

  IElementType CALL = new WorkflowInlineElementType("CALL");
  IElementType CONDITION = new WorkflowInlineElementType("CONDITION");
  IElementType CONDITION_OPERATOR = new WorkflowInlineElementType("CONDITION_OPERATOR");
  IElementType EXPRESSION = new WorkflowInlineElementType("EXPRESSION");
  IElementType GROUP = new WorkflowInlineElementType("GROUP");
  IElementType IDENT = new WorkflowInlineElementType("IDENT");
  IElementType INDEXER = new WorkflowInlineElementType("INDEXER");
  IElementType LITERAL = new WorkflowInlineElementType("LITERAL");
  IElementType LOGICAL_OPERATOR = new WorkflowInlineElementType("LOGICAL_OPERATOR");
  IElementType NEGATE = new WorkflowInlineElementType("NEGATE");
  IElementType NUMBER_LITERAL = new WorkflowInlineElementType("NUMBER_LITERAL");
  IElementType OPERABLE = new WorkflowInlineElementType("OPERABLE");
  IElementType OPERATION = new WorkflowInlineElementType("OPERATION");
  IElementType PARAMS = new WorkflowInlineElementType("PARAMS");
  IElementType QUALIFIABLE = new WorkflowInlineElementType("QUALIFIABLE");
  IElementType QUALIFIER = new WorkflowInlineElementType("QUALIFIER");
  IElementType SIMPLE_EXPR = new WorkflowInlineElementType("SIMPLE_EXPR");
  IElementType STRING_LITERAL = new WorkflowInlineElementType("STRING_LITERAL");

  IElementType FALSE = new WorkflowInlineTokenType("false");
  IElementType ID = new WorkflowInlineTokenType("id");
  IElementType INTEGER = new WorkflowInlineTokenType("integer");
  IElementType LEFT_BRACKET = new WorkflowInlineTokenType("[");
  IElementType LEFT_PAREN = new WorkflowInlineTokenType("(");
  IElementType NULL = new WorkflowInlineTokenType("null");
  IElementType NUMBER = new WorkflowInlineTokenType("number");
  IElementType OP_AND = new WorkflowInlineTokenType("&&");
  IElementType OP_COMMA = new WorkflowInlineTokenType(",");
  IElementType OP_DOT = new WorkflowInlineTokenType(".");
  IElementType OP_EQ = new WorkflowInlineTokenType("==");
  IElementType OP_GT = new WorkflowInlineTokenType(">");
  IElementType OP_GTE = new WorkflowInlineTokenType(">=");
  IElementType OP_LT = new WorkflowInlineTokenType("<");
  IElementType OP_LTE = new WorkflowInlineTokenType("<=");
  IElementType OP_NE = new WorkflowInlineTokenType("!=");
  IElementType OP_NOT = new WorkflowInlineTokenType("!");
  IElementType OP_OR = new WorkflowInlineTokenType("||");
  IElementType RIGHT_BRACKET = new WorkflowInlineTokenType("]");
  IElementType RIGHT_PAREN = new WorkflowInlineTokenType(")");
  IElementType STRING = new WorkflowInlineTokenType("string");
  IElementType TRUE = new WorkflowInlineTokenType("true");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CALL) {
        return new WICallImpl(node);
      }
      else if (type == CONDITION) {
        return new WIConditionImpl(node);
      }
      else if (type == CONDITION_OPERATOR) {
        return new WIConditionOperatorImpl(node);
      }
      else if (type == EXPRESSION) {
        return new WIExpressionImpl(node);
      }
      else if (type == GROUP) {
        return new WIGroupImpl(node);
      }
      else if (type == IDENT) {
        return new WIIdentImpl(node);
      }
      else if (type == INDEXER) {
        return new WIIndexerImpl(node);
      }
      else if (type == LITERAL) {
        return new WILiteralImpl(node);
      }
      else if (type == LOGICAL_OPERATOR) {
        return new WILogicalOperatorImpl(node);
      }
      else if (type == NEGATE) {
        return new WINegateImpl(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new WINumberLiteralImpl(node);
      }
      else if (type == OPERABLE) {
        return new WIOperableImpl(node);
      }
      else if (type == OPERATION) {
        return new WIOperationImpl(node);
      }
      else if (type == PARAMS) {
        return new WIParamsImpl(node);
      }
      else if (type == QUALIFIABLE) {
        return new WIQualifiableImpl(node);
      }
      else if (type == QUALIFIER) {
        return new WIQualifierImpl(node);
      }
      else if (type == SIMPLE_EXPR) {
        return new WISimpleExprImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new WIStringLiteralImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
