package io.github.jamesdbaker.javadoc9.taglets;

import com.sun.source.doctree.DocTree;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Taglet;

/**
 * Taglet to list fields that are documented with a @language comment
 */
public class LanguagesTaglet implements Taglet {

  Types typeUtils;
  Elements elementUtils;

  @Override
  public void init(DocletEnvironment env, Doclet doclet) {
    typeUtils = env.getTypeUtils();
    elementUtils = env.getElementUtils();
  }

  @Override
  public Set<Location> getAllowedLocations() {
    return Set.of(Location.TYPE);
  }

  @Override
  public boolean isInlineTag() {
    return false;
  }

  @Override
  public String getName() {
    return "languages";
  }

  @Override
  public String toString(List<? extends DocTree> tags, Element element) {
    //Assume the element is a TypeElement - FIXME: We should check for this
    TypeElement currElement = (TypeElement) element;

    StringJoiner fields = new StringJoiner(", ");

    while(currElement != null){
      // Get fields from current element
      currElement.getEnclosedElements().stream().filter(e -> e.getKind().isField())
          .forEach(e -> {
            //Get the Javadoc and check it has an @language tag - TODO: Is there a better way to do this without manually passing the comment?
            String javadoc = elementUtils.getDocComment(e);
            if(javadoc != null && javadoc.contains("@language "))
              fields.add(e.getSimpleName().toString());
          });

      // Get the superclass of the current element so we can get the fields in those classes too
      currElement = (TypeElement) typeUtils.asElement(currElement.getSuperclass());
    }

    return "<dt><span class=\"simpleTagLabel\">Fields with a @language tag:</span></dt>"
        + "<dd>" + fields.toString() + "</dd>";
  }
}
