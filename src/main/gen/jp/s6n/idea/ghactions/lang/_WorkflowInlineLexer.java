// Generated by JFlex 1.9.1 http://jflex.de/  (tweaked for IntelliJ platform)
// source: _WorkflowInlineLexer.flex

package jp.s6n.idea.ghactions.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static jp.s6n.idea.ghactions.lang.WorkflowInlineTypes.*;


public class _WorkflowInlineLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\1\u0200\1\u0300\1\u0400\1\u0500\1\u0600\1\u0700"+
    "\1\u0800\1\u0900\1\u0a00\1\u0b00\1\u0c00\1\u0d00\1\u0e00\1\u0f00"+
    "\1\u1000\1\u0100\1\u1100\1\u1200\1\u1300\1\u0100\1\u1400\1\u1500"+
    "\1\u1600\1\u1700\1\u1800\1\u1900\1\u1a00\1\u1b00\1\u0100\1\u1c00"+
    "\1\u1d00\1\u1e00\2\u1f00\1\u2000\7\u1f00\1\u2100\1\u2200\1\u2300"+
    "\1\u1f00\1\u2400\1\u2500\2\u1f00\31\u0100\1\u2600\121\u0100\1\u2700"+
    "\4\u0100\1\u2800\1\u0100\1\u2900\1\u2a00\1\u2b00\1\u2c00\1\u2d00"+
    "\1\u2e00\53\u0100\1\u2f00\41\u1f00\1\u0100\1\u3000\1\u3100\1\u0100"+
    "\1\u3200\1\u3300\1\u3400\1\u3500\1\u3600\1\u3700\1\u3800\1\u3900"+
    "\1\u3a00\1\u0100\1\u3b00\1\u3c00\1\u3d00\1\u3e00\1\u3f00\1\u4000"+
    "\1\u4100\1\u1f00\1\u4200\1\u4300\1\u4400\1\u4500\1\u4600\1\u4700"+
    "\1\u4800\1\u4900\1\u4a00\1\u4b00\1\u4c00\1\u4d00\1\u1f00\1\u4e00"+
    "\1\u4f00\1\u5000\1\u1f00\3\u0100\1\u5100\1\u5200\1\u5300\12\u1f00"+
    "\4\u0100\1\u5400\17\u1f00\2\u0100\1\u5500\41\u1f00\2\u0100\1\u5600"+
    "\1\u5700\2\u1f00\1\u5800\1\u5900\27\u0100\1\u5a00\2\u0100\1\u5b00"+
    "\45\u1f00\1\u0100\1\u5c00\1\u5d00\11\u1f00\1\u5e00\24\u1f00\1\u5f00"+
    "\1\u6000\1\u1f00\1\u6100\1\u6200\1\u6300\1\u6400\2\u1f00\1\u6500"+
    "\5\u1f00\1\u6600\1\u6700\1\u6800\5\u1f00\1\u6900\1\u6a00\4\u1f00"+
    "\1\u6b00\2\u1f00\1\u6c00\16\u1f00\246\u0100\1\u6d00\20\u0100\1\u6e00"+
    "\1\u6f00\25\u0100\1\u7000\34\u0100\1\u7100\14\u1f00\2\u0100\1\u7200"+
    "\u0b06\u1f00\1\u7300\u02fe\u1f00";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\5\1\22\0\1\1\1\2\4\0\1\3\1\4"+
    "\1\5\1\6\2\0\1\7\1\10\1\11\1\0\12\12"+
    "\2\0\1\13\1\14\1\15\2\0\32\16\1\17\1\0"+
    "\1\20\1\0\1\21\1\0\1\22\3\16\1\23\1\24"+
    "\5\16\1\25\1\16\1\26\3\16\1\27\1\30\1\31"+
    "\1\32\5\16\1\0\1\33\10\0\1\1\32\0\1\1"+
    "\11\0\1\16\12\0\1\16\4\0\1\16\5\0\27\16"+
    "\1\0\37\16\1\0\u01ca\16\4\0\14\16\16\0\5\16"+
    "\7\0\1\16\1\0\1\16\21\0\160\21\5\16\1\0"+
    "\2\16\2\0\4\16\1\0\1\16\6\0\1\16\1\0"+
    "\3\16\1\0\1\16\1\0\24\16\1\0\123\16\1\0"+
    "\213\16\1\0\7\21\246\16\1\0\46\16\2\0\1\16"+
    "\6\0\51\16\10\0\55\21\1\0\1\21\1\0\2\21"+
    "\1\0\2\21\1\0\1\21\10\0\33\16\4\0\4\16"+
    "\35\0\13\21\5\0\53\16\37\21\4\0\2\16\1\21"+
    "\143\16\1\0\1\16\7\21\2\0\6\21\2\16\2\21"+
    "\1\0\4\21\2\16\12\21\3\16\2\0\1\16\20\0"+
    "\1\16\1\21\36\16\33\21\2\0\131\16\13\21\1\16"+
    "\16\0\12\21\41\16\11\21\2\16\4\0\1\16\2\0"+
    "\1\21\2\0\26\16\4\21\1\16\11\21\1\16\3\21"+
    "\1\16\5\21\22\0\31\16\3\21\4\0\13\16\65\0"+
    "\25\16\1\0\10\16\25\0\17\21\1\0\41\21\66\16"+
    "\3\21\1\16\22\21\1\16\7\21\12\16\2\21\2\0"+
    "\12\21\1\0\20\16\3\21\1\0\10\16\2\0\2\16"+
    "\2\0\26\16\1\0\7\16\1\0\1\16\3\0\4\16"+
    "\2\0\1\21\1\16\7\21\2\0\2\21\2\0\3\21"+
    "\1\16\10\0\1\21\4\0\2\16\1\0\3\16\2\21"+
    "\2\0\12\21\2\16\12\0\1\16\1\0\1\21\2\0"+
    "\3\21\1\0\6\16\4\0\2\16\2\0\26\16\1\0"+
    "\7\16\1\0\2\16\1\0\2\16\1\0\2\16\2\0"+
    "\1\21\1\0\5\21\4\0\2\21\2\0\3\21\3\0"+
    "\1\21\7\0\4\16\1\0\1\16\7\0\14\21\3\16"+
    "\1\21\13\0\3\21\1\0\11\16\1\0\3\16\1\0"+
    "\26\16\1\0\7\16\1\0\2\16\1\0\5\16\2\0"+
    "\1\21\1\16\10\21\1\0\3\21\1\0\3\21\2\0"+
    "\1\16\17\0\2\16\2\21\2\0\12\21\11\0\1\16"+
    "\6\21\1\0\3\21\1\0\10\16\2\0\2\16\2\0"+
    "\26\16\1\0\7\16\1\0\2\16\1\0\5\16\2\0"+
    "\1\21\1\16\7\21\2\0\2\21\2\0\3\21\10\0"+
    "\2\21\4\0\2\16\1\0\3\16\2\21\2\0\12\21"+
    "\1\0\1\16\20\0\1\21\1\16\1\0\6\16\3\0"+
    "\3\16\1\0\4\16\3\0\2\16\1\0\1\16\1\0"+
    "\2\16\3\0\2\16\3\0\3\16\3\0\14\16\4\0"+
    "\5\21\3\0\3\21\1\0\4\21\2\0\1\16\6\0"+
    "\1\21\16\0\12\21\20\0\5\21\10\16\1\0\3\16"+
    "\1\0\27\16\1\0\20\16\3\0\1\16\7\21\1\0"+
    "\3\21\1\0\4\21\7\0\2\21\1\0\3\16\5\0"+
    "\2\16\2\21\2\0\12\21\20\0\1\16\3\21\1\0"+
    "\10\16\1\0\3\16\1\0\27\16\1\0\12\16\1\0"+
    "\5\16\2\0\1\21\1\16\7\21\1\0\3\21\1\0"+
    "\4\21\7\0\2\21\7\0\1\16\1\0\2\16\2\21"+
    "\2\0\12\21\1\0\2\16\15\0\4\21\1\0\10\16"+
    "\1\0\3\16\1\0\51\16\2\21\1\16\7\21\1\0"+
    "\3\21\1\0\4\21\1\16\5\0\3\16\1\21\7\0"+
    "\3\16\2\21\2\0\12\21\12\0\6\16\2\0\2\21"+
    "\1\0\22\16\3\0\30\16\1\0\11\16\1\0\1\16"+
    "\2\0\7\16\3\0\1\21\4\0\6\21\1\0\1\21"+
    "\1\0\10\21\6\0\12\21\2\0\2\21\15\0\60\16"+
    "\1\21\2\16\7\21\5\0\7\16\10\21\1\0\12\21"+
    "\47\0\2\16\1\0\1\16\1\0\5\16\1\0\30\16"+
    "\1\0\1\16\1\0\12\16\1\21\2\16\11\21\1\16"+
    "\2\0\5\16\1\0\1\16\1\0\6\21\2\0\12\21"+
    "\2\0\4\16\40\0\1\16\27\0\2\21\6\0\12\21"+
    "\13\0\1\21\1\0\1\21\1\0\1\21\4\0\2\21"+
    "\10\16\1\0\44\16\4\0\24\21\1\0\2\21\5\16"+
    "\13\21\1\0\44\21\11\0\1\21\71\0\53\16\24\21"+
    "\1\16\12\21\6\0\6\16\4\21\4\16\3\21\1\16"+
    "\3\21\2\16\7\21\3\16\4\21\15\16\14\21\1\16"+
    "\17\21\2\0\46\16\1\0\1\16\5\0\1\16\2\0"+
    "\53\16\1\0\115\16\1\0\4\16\2\0\7\16\1\0"+
    "\1\16\1\0\4\16\2\0\51\16\1\0\4\16\2\0"+
    "\41\16\1\0\4\16\2\0\7\16\1\0\1\16\1\0"+
    "\4\16\2\0\17\16\1\0\71\16\1\0\4\16\2\0"+
    "\103\16\2\0\3\21\40\0\20\16\20\0\126\16\2\0"+
    "\6\16\3\0\u016c\16\2\0\21\16\1\1\32\16\5\0"+
    "\113\16\3\0\3\21\10\16\7\0\15\16\1\0\4\16"+
    "\3\21\13\0\22\16\3\21\13\0\22\16\2\21\14\0"+
    "\15\16\1\0\3\16\1\0\2\21\14\0\64\16\40\21"+
    "\3\0\1\16\4\0\1\16\1\21\2\0\12\21\41\0"+
    "\3\21\2\0\12\21\6\0\131\16\7\0\5\16\2\21"+
    "\42\16\1\21\1\16\5\0\106\16\12\0\37\16\1\0"+
    "\14\21\4\0\14\21\12\0\12\21\36\16\2\0\5\16"+
    "\13\0\54\16\4\0\32\16\6\0\12\21\46\0\27\16"+
    "\5\21\4\0\65\16\12\21\1\0\35\21\2\0\13\21"+
    "\6\0\12\21\15\0\1\16\10\0\17\21\101\0\5\21"+
    "\57\16\21\21\7\16\4\0\12\21\21\0\11\21\14\0"+
    "\3\21\36\16\15\21\2\16\12\21\54\16\16\21\14\0"+
    "\44\16\24\21\10\0\12\21\3\0\3\16\12\21\44\16"+
    "\2\0\11\16\7\0\53\16\2\0\3\16\20\0\3\21"+
    "\1\0\25\21\4\16\1\21\6\16\1\21\2\16\3\21"+
    "\1\16\5\0\300\16\72\21\1\0\5\21\26\16\2\0"+
    "\6\16\2\0\46\16\2\0\6\16\2\0\10\16\1\0"+
    "\1\16\1\0\1\16\1\0\1\16\1\0\37\16\2\0"+
    "\65\16\1\0\7\16\1\0\1\16\3\0\3\16\1\0"+
    "\7\16\3\0\4\16\2\0\6\16\4\0\15\16\5\0"+
    "\3\16\1\0\7\16\3\0\13\1\35\0\2\1\5\0"+
    "\1\1\17\0\2\21\23\0\1\21\12\0\1\1\21\0"+
    "\1\16\15\0\1\16\20\0\15\16\63\0\41\21\21\0"+
    "\1\16\4\0\1\16\2\0\12\16\1\0\1\16\3\0"+
    "\5\16\6\0\1\16\1\0\1\16\1\0\1\16\1\0"+
    "\4\16\1\0\13\16\2\0\4\16\5\0\5\16\4\0"+
    "\1\16\21\0\43\21\2\16\4\21\u022d\0\64\21\26\0"+
    "\57\16\1\0\57\16\1\0\205\16\6\0\4\16\3\21"+
    "\2\16\14\0\46\16\1\0\1\16\5\0\1\16\2\0"+
    "\70\16\7\0\1\16\17\0\1\21\27\16\11\0\7\16"+
    "\1\0\7\16\1\0\7\16\1\0\7\16\1\0\7\16"+
    "\1\0\7\16\1\0\7\16\1\0\7\16\1\0\40\21"+
    "\57\0\1\16\320\0\1\1\4\0\2\16\1\21\31\0"+
    "\17\21\1\0\5\16\2\0\3\21\2\16\4\0\126\16"+
    "\2\0\2\21\2\0\3\16\1\0\132\16\1\0\4\16"+
    "\5\0\53\16\1\0\136\16\21\0\33\16\65\0\306\16"+
    "\112\0\360\16\20\0\215\16\103\0\56\16\2\0\15\16"+
    "\3\0\20\16\12\21\2\16\24\0\57\16\4\21\1\0"+
    "\12\21\1\0\37\16\2\21\106\16\14\21\45\0\11\16"+
    "\2\0\147\16\2\0\65\16\2\0\5\16\60\0\13\16"+
    "\1\21\3\16\1\21\4\16\1\21\27\16\5\21\30\0"+
    "\64\16\14\0\2\21\62\16\22\21\12\0\12\21\6\0"+
    "\22\21\6\16\3\0\1\16\1\0\2\16\13\21\34\16"+
    "\10\21\2\0\27\16\15\21\14\0\35\16\3\0\4\21"+
    "\57\16\16\21\16\0\1\16\12\21\6\0\5\16\1\21"+
    "\12\16\12\21\5\16\1\0\51\16\16\21\11\0\3\16"+
    "\1\21\10\16\2\21\2\0\12\21\6\0\27\16\3\0"+
    "\1\16\3\21\62\16\1\21\1\16\3\21\2\16\2\21"+
    "\5\16\2\21\1\16\1\21\1\16\30\0\3\16\2\0"+
    "\13\16\5\21\2\0\3\16\2\21\12\0\6\16\2\0"+
    "\6\16\2\0\6\16\11\0\7\16\1\0\7\16\1\0"+
    "\53\16\1\0\14\16\10\0\163\16\10\21\1\0\2\21"+
    "\2\0\12\21\6\0\244\16\14\0\27\16\4\0\61\16"+
    "\4\0\156\16\2\0\152\16\46\0\7\16\14\0\5\16"+
    "\5\0\1\16\1\21\12\16\1\0\15\16\1\0\5\16"+
    "\1\0\1\16\1\0\2\16\1\0\2\16\1\0\154\16"+
    "\41\0\153\16\22\0\100\16\2\0\66\16\50\0\14\16"+
    "\4\0\20\21\20\0\20\21\3\0\2\21\30\0\3\21"+
    "\40\0\5\16\1\0\207\16\23\0\12\21\7\0\32\16"+
    "\4\0\1\21\1\0\32\16\13\0\131\16\3\0\6\16"+
    "\2\0\6\16\2\0\6\16\2\0\3\16\43\0\14\16"+
    "\1\0\32\16\1\0\23\16\1\0\2\16\1\0\17\16"+
    "\2\0\16\16\42\0\173\16\105\0\65\21\210\0\1\21"+
    "\202\0\35\16\3\0\61\16\17\0\1\21\37\0\40\16"+
    "\15\0\24\16\1\21\10\16\1\21\5\0\46\16\5\21"+
    "\5\0\36\16\2\0\44\16\4\0\10\16\1\0\5\21"+
    "\52\0\236\16\2\0\12\21\6\0\44\16\4\0\44\16"+
    "\4\0\50\16\10\0\64\16\234\0\67\16\11\0\26\16"+
    "\12\0\10\16\230\0\6\16\2\0\1\16\1\0\54\16"+
    "\1\0\2\16\3\0\1\16\2\0\27\16\12\0\27\16"+
    "\11\0\37\16\101\0\23\16\1\0\2\16\12\0\26\16"+
    "\12\0\32\16\106\0\70\16\6\0\2\16\100\0\1\16"+
    "\3\21\1\0\2\21\5\0\4\21\4\16\1\0\3\16"+
    "\1\0\35\16\2\0\3\21\4\0\1\21\40\0\35\16"+
    "\3\0\35\16\43\0\10\16\1\0\34\16\2\21\31\0"+
    "\66\16\12\0\26\16\12\0\23\16\15\0\22\16\156\0"+
    "\111\16\67\0\63\16\15\0\63\16\15\0\44\16\4\21"+
    "\10\0\12\21\306\0\35\16\12\0\1\16\10\0\26\16"+
    "\13\21\217\0\27\16\11\0\3\21\65\16\17\21\37\0"+
    "\12\21\17\0\4\21\55\16\13\21\25\0\31\16\7\0"+
    "\12\21\6\0\3\21\44\16\16\21\1\0\12\21\4\0"+
    "\1\16\2\21\11\0\43\16\1\21\2\0\1\16\11\0"+
    "\3\21\60\16\16\21\4\16\4\0\4\21\3\0\12\21"+
    "\1\16\1\0\1\16\43\0\22\16\1\0\31\16\14\21"+
    "\6\0\1\21\101\0\7\16\1\0\1\16\1\0\4\16"+
    "\1\0\17\16\1\0\12\16\7\0\57\16\14\21\5\0"+
    "\12\21\6\0\4\21\1\0\10\16\2\0\2\16\2\0"+
    "\26\16\1\0\7\16\1\0\2\16\1\0\5\16\1\0"+
    "\2\21\1\16\7\21\2\0\2\21\2\0\3\21\2\0"+
    "\1\16\6\0\1\21\5\0\5\16\2\21\2\0\7\21"+
    "\3\0\5\21\213\0\65\16\22\21\4\16\5\0\12\21"+
    "\4\0\1\21\1\16\40\0\60\16\24\21\2\16\1\0"+
    "\1\16\10\0\12\21\246\0\57\16\7\21\2\0\11\21"+
    "\27\0\4\16\2\21\42\0\60\16\21\21\3\0\1\16"+
    "\13\0\12\21\46\0\53\16\15\21\1\16\7\0\12\21"+
    "\66\0\33\16\2\0\17\21\4\0\12\21\306\0\54\16"+
    "\17\21\145\0\100\16\12\21\25\0\1\16\240\0\10\16"+
    "\2\0\47\16\7\21\2\0\7\21\1\16\1\0\1\16"+
    "\1\21\33\0\1\16\12\21\50\16\7\21\1\16\4\21"+
    "\10\0\1\21\10\0\1\16\13\21\56\16\20\21\3\0"+
    "\1\16\42\0\71\16\7\0\11\16\1\0\45\16\10\21"+
    "\1\0\10\21\1\16\17\0\12\21\30\0\36\16\2\0"+
    "\26\21\1\0\16\21\111\0\7\16\1\0\2\16\1\0"+
    "\46\16\6\21\3\0\1\21\1\0\2\21\1\0\7\21"+
    "\1\16\1\21\10\0\12\21\6\0\6\16\1\0\2\16"+
    "\1\0\40\16\5\21\1\0\2\21\1\0\5\21\1\16"+
    "\7\0\12\21\u0136\0\23\16\4\21\11\0\232\16\146\0"+
    "\157\21\21\0\304\16\274\0\57\16\321\0\107\16\271\0"+
    "\71\16\7\0\37\16\1\0\12\21\146\0\36\16\2\0"+
    "\5\21\13\0\60\16\7\21\11\0\4\16\14\0\12\21"+
    "\11\0\25\16\5\0\23\16\260\0\100\16\200\0\113\16"+
    "\4\0\1\21\1\16\67\21\7\0\4\21\15\16\100\0"+
    "\2\16\1\0\1\16\34\0\370\16\10\0\363\16\15\0"+
    "\37\16\61\0\3\16\21\0\4\16\10\0\u018c\16\4\0"+
    "\153\16\5\0\15\16\3\0\11\16\7\0\12\16\3\0"+
    "\2\21\306\0\5\21\3\0\6\21\10\0\10\21\2\0"+
    "\7\21\36\0\4\21\224\0\3\21\273\0\125\16\1\0"+
    "\107\16\1\0\2\16\2\0\1\16\2\0\2\16\2\0"+
    "\4\16\1\0\14\16\1\0\1\16\1\0\7\16\1\0"+
    "\101\16\1\0\4\16\2\0\10\16\1\0\7\16\1\0"+
    "\34\16\1\0\4\16\1\0\5\16\1\0\1\16\3\0"+
    "\7\16\1\0\u0154\16\2\0\31\16\1\0\31\16\1\0"+
    "\37\16\1\0\31\16\1\0\37\16\1\0\31\16\1\0"+
    "\37\16\1\0\31\16\1\0\37\16\1\0\31\16\1\0"+
    "\10\16\2\0\151\21\4\0\62\21\10\0\1\21\16\0"+
    "\1\21\26\0\5\21\1\0\17\21\120\0\7\21\1\0"+
    "\21\21\2\0\7\21\1\0\2\21\1\0\5\21\325\0"+
    "\55\16\3\0\7\21\7\16\2\0\12\21\4\0\1\16"+
    "\u0171\0\54\16\16\21\6\0\305\16\13\0\7\21\51\0"+
    "\104\16\7\21\1\16\4\0\12\21\246\0\4\16\1\0"+
    "\33\16\1\0\2\16\1\0\1\16\2\0\1\16\1\0"+
    "\12\16\1\0\4\16\1\0\1\16\1\0\1\16\6\0"+
    "\1\16\4\0\1\16\1\0\1\16\1\0\1\16\1\0"+
    "\3\16\1\0\2\16\1\0\1\16\2\0\1\16\1\0"+
    "\1\16\1\0\1\16\1\0\1\16\1\0\1\16\1\0"+
    "\2\16\1\0\1\16\2\0\4\16\1\0\7\16\1\0"+
    "\4\16\1\0\4\16\1\0\1\16\1\0\12\16\1\0"+
    "\21\16\5\0\3\16\1\0\5\16\1\0\21\16\164\0"+
    "\32\21\6\0\32\21\6\0\32\21\166\0\327\16\51\0"+
    "\65\16\13\0\336\16\2\0\u0182\16\16\0\u0131\16\37\0"+
    "\36\16\342\0\360\21\20\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[29696];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\2\1\1\4\1\5\1\6"+
    "\1\1\1\7\1\10\1\11\1\1\1\12\1\13\1\14"+
    "\1\15\3\13\1\1\1\16\1\17\1\0\1\20\1\21"+
    "\2\0\1\22\1\23\1\24\3\13\1\25\1\21\1\0"+
    "\1\21\4\13\1\26\1\27\1\30";

  private static int [] zzUnpackAction() {
    int [] result = new int[46];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\34\0\70\0\124\0\160\0\214\0\34\0\34"+
    "\0\34\0\250\0\34\0\304\0\340\0\374\0\u0118\0\u0134"+
    "\0\34\0\34\0\u0150\0\u016c\0\u0188\0\u01a4\0\34\0\34"+
    "\0\214\0\u01c0\0\u01dc\0\u01f8\0\u0214\0\34\0\34\0\34"+
    "\0\u0230\0\u024c\0\u0268\0\34\0\u0284\0\u02a0\0\u02a0\0\u02bc"+
    "\0\u02d8\0\u02f4\0\u0310\0\u0134\0\u0134\0\u0134";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[46];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\2\2\20\1\23\1\20\1\24\2\20\1\25"+
    "\1\20\1\26\35\0\1\3\46\0\1\27\22\0\1\30"+
    "\30\0\4\31\1\32\27\31\12\0\1\33\32\0\1\34"+
    "\1\14\10\0\1\35\24\0\1\36\33\0\1\37\33\0"+
    "\1\40\27\0\1\20\1\0\1\20\3\0\1\20\2\0"+
    "\12\20\11\0\1\20\1\0\1\20\3\0\1\20\2\0"+
    "\1\20\1\41\10\20\11\0\1\20\1\0\1\20\3\0"+
    "\1\20\2\0\11\20\1\42\11\0\1\20\1\0\1\20"+
    "\3\0\1\20\2\0\6\20\1\43\3\20\34\0\1\44"+
    "\4\0\1\31\40\0\1\34\1\33\10\0\1\35\22\0"+
    "\1\45\31\0\1\46\1\0\1\47\31\0\1\20\1\0"+
    "\1\20\3\0\1\20\2\0\4\20\1\50\5\20\11\0"+
    "\1\20\1\0\1\20\3\0\1\20\2\0\4\20\1\51"+
    "\5\20\11\0\1\20\1\0\1\20\3\0\1\20\2\0"+
    "\11\20\1\52\13\0\1\45\10\0\1\35\22\0\1\47"+
    "\31\0\1\20\1\0\1\20\3\0\1\20\2\0\7\20"+
    "\1\53\2\20\11\0\1\20\1\0\1\20\3\0\1\20"+
    "\2\0\4\20\1\54\5\20\11\0\1\20\1\0\1\20"+
    "\3\0\1\20\2\0\2\20\1\55\7\20\11\0\1\20"+
    "\1\0\1\20\3\0\1\20\2\0\2\20\1\56\7\20"+
    "\1\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[812];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\4\1\3\11\1\1\1\11\5\1\2\11"+
    "\4\1\2\11\1\0\2\1\2\0\3\11\3\1\1\11"+
    "\1\1\1\0\10\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[46];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  protected int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
  public _WorkflowInlineLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _WorkflowInlineLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return BAD_CHARACTER;
            }
          // fall through
          case 25: break;
          case 2:
            { return WHITE_SPACE;
            }
          // fall through
          case 26: break;
          case 3:
            { return OP_NOT;
            }
          // fall through
          case 27: break;
          case 4:
            { return LEFT_PAREN;
            }
          // fall through
          case 28: break;
          case 5:
            { return RIGHT_PAREN;
            }
          // fall through
          case 29: break;
          case 6:
            { return OP_COMMA;
            }
          // fall through
          case 30: break;
          case 7:
            { return OP_DOT;
            }
          // fall through
          case 31: break;
          case 8:
            { return INTEGER;
            }
          // fall through
          case 32: break;
          case 9:
            { return OP_LT;
            }
          // fall through
          case 33: break;
          case 10:
            { return OP_GT;
            }
          // fall through
          case 34: break;
          case 11:
            { return ID;
            }
          // fall through
          case 35: break;
          case 12:
            { return LEFT_BRACKET;
            }
          // fall through
          case 36: break;
          case 13:
            { return RIGHT_BRACKET;
            }
          // fall through
          case 37: break;
          case 14:
            { return OP_NE;
            }
          // fall through
          case 38: break;
          case 15:
            { return OP_AND;
            }
          // fall through
          case 39: break;
          case 16:
            { return STRING;
            }
          // fall through
          case 40: break;
          case 17:
            { return NUMBER;
            }
          // fall through
          case 41: break;
          case 18:
            { return OP_LTE;
            }
          // fall through
          case 42: break;
          case 19:
            { return OP_EQ;
            }
          // fall through
          case 43: break;
          case 20:
            { return OP_GTE;
            }
          // fall through
          case 44: break;
          case 21:
            { return OP_OR;
            }
          // fall through
          case 45: break;
          case 22:
            { return NULL;
            }
          // fall through
          case 46: break;
          case 23:
            { return TRUE;
            }
          // fall through
          case 47: break;
          case 24:
            { return FALSE;
            }
          // fall through
          case 48: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
