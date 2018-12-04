package io.github.jamesdbaker.javadoc9.taglets;

import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.UnknownBlockTagTree;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import jdk.javadoc.doclet.Taglet;

/**
 * Simple Taglet to add a Language property onto a field or type
 */
public class LanguageTaglet implements Taglet {

  @Override
  public Set<Location> getAllowedLocations() {
    return Set.of(Location.FIELD, Location.TYPE);
  }

  @Override
  public boolean isInlineTag() {
    return false;
  }

  @Override
  public String getName() {
    return "language";
  }

  @Override
  public String toString(List<? extends DocTree> tags, Element element) {
    if(tags.isEmpty())
      return null;

    //FIXME: This case should be checked
    UnknownBlockTagTree blockTagTree = (UnknownBlockTagTree) tags.get(0);   //Just take the first tag here for simplicity
    return "<dt><span class=\"simpleTagLabel\">Language:</span></dt>"
        + "<dd>" + blockTagTree.getContent() + "</dd>";
  }
}
