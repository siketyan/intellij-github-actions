// This is a generated file. Not intended for manual editing.
package jp.s6n.idea.ghactions.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WIOperation extends PsiElement {

  @NotNull
  List<WILogicalOperator> getLogicalOperatorList();

  @NotNull
  List<WIOperable> getOperableList();

}
