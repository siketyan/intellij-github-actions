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

public class WISimpleExprImpl extends ASTWrapperPsiElement implements WISimpleExpr {

  public WISimpleExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WIVisitor visitor) {
    visitor.visitSimpleExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WIVisitor) accept((WIVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WICall getCall() {
    return findChildByClass(WICall.class);
  }

  @Override
  @Nullable
  public WIGroup getGroup() {
    return findChildByClass(WIGroup.class);
  }

  @Override
  @Nullable
  public WILiteral getLiteral() {
    return findChildByClass(WILiteral.class);
  }

  @Override
  @Nullable
  public WINegate getNegate() {
    return findChildByClass(WINegate.class);
  }

  @Override
  @Nullable
  public WIQualifier getQualifier() {
    return findChildByClass(WIQualifier.class);
  }

}
