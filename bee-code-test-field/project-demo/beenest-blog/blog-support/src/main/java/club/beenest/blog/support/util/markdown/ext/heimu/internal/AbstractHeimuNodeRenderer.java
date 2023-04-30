package club.beenest.blog.support.util.markdown.ext.heimu.internal;

import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;
import club.beenest.blog.support.util.markdown.ext.heimu.Heimu

import java.util.Collections;
import java.util.Set;

/**
 * 黑幕节点抽象
 *
 * @author 陈玉轩
 * @since　1.0
 */
abstract class AbstractHeimuNodeRenderer implements NodeRenderer {
    @Override
    public Set<Class<? extends Node>> getNodeTypes() {
        return Collections.<Class<? extends Node>>singleton(Heimu.class);
    }
}
