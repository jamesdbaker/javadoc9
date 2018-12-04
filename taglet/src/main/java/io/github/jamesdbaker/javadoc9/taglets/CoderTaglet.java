package io.github.jamesdbaker.javadoc9.taglets;

import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.UnknownBlockTagTree;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import javax.lang.model.element.Element;
import jdk.javadoc.doclet.Taglet;

/**
 * Produces similar functionality to the author taglet, as a first
 * attempt at producing a taglet.
 */
public class CoderTaglet implements Taglet {

  public Set<Location> getAllowedLocations() {
    return Set.of(Location.TYPE);
  }

  public boolean isInlineTag() {
    return false;
  }

  public String getName() {
    return "coder";
  }

  public String toString(List<? extends DocTree> tags, Element element) {
    // I'm not sure if this will ever happen
    if(tags.isEmpty())
      return null;

    // If we have just one tag in the block use that
    if(tags.size() == 1) {
      //FIXME: This case should be checked
      UnknownBlockTagTree blockTagTree = (UnknownBlockTagTree) tags.get(0);

      return "<dt><span class=\"simpleTagLabel\">Coder:</span></dt>"
          + "<dd>" + blockTagTree.getContent() + "</dd>";

    //Otherwise, loop through each tag in the block
    }else{
      StringJoiner sj = new StringJoiner(", ");
      for(DocTree dt : tags){
        //FIXME: This case should be checked
        UnknownBlockTagTree blockTagTree = (UnknownBlockTagTree) dt;
        sj.add(blockTagTree.getContent().toString());
      }

      return "<dt><span class=\"simpleTagLabel\">Coder:</span></dt>"
          + "<dd>" + sj.toString() + "</dd>";
    }
  }
}
