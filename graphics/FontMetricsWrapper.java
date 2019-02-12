package graphics;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.text.CharacterIterator;

/**
 * I use this somewhere.
 * 
 * http://stackoverflow.com/questions/17762642/change-line-spacing-in-
 * jtextarea-not-jtextpane
 * 
 * @author Ashwin
 *
 */
public class FontMetricsWrapper extends FontMetrics {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final FontMetrics target;

	public FontMetricsWrapper(FontMetrics target) {
		super(target.getFont());
		this.target = target;
	}

	@Override
	public int bytesWidth(byte[] data, int off, int len) {
		return target.bytesWidth(data, off, len);
	}

	@Override
	public int charWidth(char ch) {
		return target.charWidth(ch);
	}

	@Override
	public int charWidth(int codePoint) {
		return target.charWidth(codePoint);
	}

	public int getAscent() {
		return target.getAscent();
	}

	public int getDescent() {
		return target.getDescent();
	}

	public Font getFont() {
		return target.getFont();
	}

	public FontRenderContext getFontRenderContext() {
		return target.getFontRenderContext();
	}

	public int getHeight() {
		return target.getHeight();
	}

	public int getLeading() {
		return target.getLeading();
	}

	public LineMetrics getLineMetrics(char[] chars, int beginIndex,
			int limit, Graphics context) {
		return target.getLineMetrics(chars, beginIndex, limit, context);
	}

	public LineMetrics getLineMetrics(CharacterIterator ci, int beginIndex,
			int limit, Graphics context) {
		return target.getLineMetrics(ci, beginIndex, limit, context);
	}

	public LineMetrics getLineMetrics(String str, Graphics context) {
		return target.getLineMetrics(str, context);
	}

	public LineMetrics getLineMetrics(String str, int beginIndex,
			int limit, Graphics context) {
		return target.getLineMetrics(str, beginIndex, limit, context);
	}

	public int getMaxAdvance() {
		return target.getMaxAdvance();
	}

	public int getMaxAscent() {
		return target.getMaxAscent();
	}

	public Rectangle2D getMaxCharBounds(Graphics context) {
		return target.getMaxCharBounds(context);
	}


	public int getMaxDescent() {
		return target.getMaxDescent();
	}

	public Rectangle2D getStringBounds(char[] chars, int beginIndex,
			int limit, Graphics context) {
		return target.getStringBounds(chars, beginIndex, limit, context);
	}

	public Rectangle2D getStringBounds(CharacterIterator ci,
			int beginIndex, int limit, Graphics context) {
		return target.getStringBounds(ci, beginIndex, limit, context);
	}

	public Rectangle2D getStringBounds(String str, Graphics context) {
		return target.getStringBounds(str, context);
	}

	public Rectangle2D getStringBounds(String str, int beginIndex,
			int limit, Graphics context) {
		return target.getStringBounds(str, beginIndex, limit, context);
	}

	public int[] getWidths() {
		return target.getWidths();
	}

	public boolean hasUniformLineMetrics() {
		return target.hasUniformLineMetrics();
	}

	public int stringWidth(String str) {
		return target.stringWidth(str);
	}

	public String toString() {
		return target.toString();
	}
}