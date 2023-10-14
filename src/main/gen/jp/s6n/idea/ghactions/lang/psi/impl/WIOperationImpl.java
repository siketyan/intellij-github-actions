// This is a generated file. Not intended for manual editing.
package jp.s6n.idea.ghactions.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static jp.s6n.idea.ghactions.lang.WorkflowInlineTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import jp.s6n.idea.ghactions.lang.psi.*;

public class WIOperationImpl extends ASTWrapperPsiElement implements WIOperation {

  public WIOperationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WIVisitor visitor) {
    visitor.visitOperation(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WIVisitor) accept((WIVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public WIConditionOperator getConditionOperator() {
    return findNotNullChildByClass(WIConditionOperator.class);
  }

  @Override
  @NotNull
  public WIExpression getExpression() {
    return findNotNullChildByClass(WIExpression.class);
  }

  @Override
  @NotNull
  public WISimpleExpr getSimpleExpr() {
    return findNotNullChildByClass(WISimpleExpr.class);
  }

}
