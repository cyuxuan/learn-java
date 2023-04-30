package club.beenest.blog.support.util.markdown.ext.heimu;

import org.commonmark.node.CustomNode;
import org.commonmark.node.Delimited;

/**
 * A heimu node containing text and other inline nodes nodes as children.
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class Heimu extends CustomNode implements Delimited {
    private static final String DELIMITER = "@@";

    @Override
    public String getOpeningDelimiter() {
        return DELIMITER;
    }

    @Override
    public String getClosingDelimiter() {
        return DELIMITER;
    }
}
