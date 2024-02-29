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

public class WIOperableImpl extends ASTWrapperPsiElement implements WIOperable {

  public WIOperableImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WIVisitor visitor) {
    visitor.visitOperable(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WIVisitor) accept((WIVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WICondition getCondition() {
    return findChildByClass(WICondition.class);
  }

  @Override
  @Nullable
  public WISimpleExpr getSimpleExpr() {
    return findChildByClass(WISimpleExpr.class);
  }

}
