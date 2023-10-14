// This is a generated file. Not intended for manual editing.
package jp.s6n.idea.ghactions.lang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class WIVisitor extends PsiElementVisitor {

  public void visitCall(@NotNull WICall o) {
    visitPsiElement(o);
  }

  public void visitConditionOperator(@NotNull WIConditionOperator o) {
    visitPsiElement(o);
  }

  public void visitExpression(@NotNull WIExpression o) {
    visitPsiElement(o);
  }

  public void visitGroup(@NotNull WIGroup o) {
    visitPsiElement(o);
  }

  public void visitIdent(@NotNull WIIdent o) {
    visitPsiElement(o);
  }

  public void visitIndexer(@NotNull WIIndexer o) {
    visitPsiElement(o);
  }

  public void visitLiteral(@NotNull WILiteral o) {
    visitPsiElement(o);
  }

  public void visitNegate(@NotNull WINegate o) {
    visitPsiElement(o);
  }

  public void visitNumberLiteral(@NotNull WINumberLiteral o) {
    visitLiteral(o);
  }

  public void visitOperation(@NotNull WIOperation o) {
    visitPsiElement(o);
  }

  public void visitQualifier(@NotNull WIQualifier o) {
    visitPsiElement(o);
  }

  public void visitSimpleExpr(@NotNull WISimpleExpr o) {
    visitPsiElement(o);
  }

  public void visitStringLiteral(@NotNull WIStringLiteral o) {
    visitLiteral(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
