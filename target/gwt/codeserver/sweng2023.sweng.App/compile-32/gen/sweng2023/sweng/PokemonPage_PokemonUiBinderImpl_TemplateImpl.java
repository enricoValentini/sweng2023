package sweng2023.sweng;

public class PokemonPage_PokemonUiBinderImpl_TemplateImpl implements sweng2023.sweng.PokemonPage_PokemonUiBinderImpl.Template {
  
  public com.google.gwt.safehtml.shared.SafeHtml html1() {
    StringBuilder sb = new java.lang.StringBuilder();
    sb.append("Torna alla home");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}

public com.google.gwt.safehtml.shared.SafeHtml html2(java.lang.String arg0,java.lang.String arg1) {
StringBuilder sb = new java.lang.StringBuilder();
sb.append("<h1>Pokemon Cards</h1> <span id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg0));
sb.append("'></span>  <span id='");
sb.append(com.google.gwt.safehtml.shared.SafeHtmlUtils.htmlEscape(arg1));
sb.append("'></span>");
return new com.google.gwt.safehtml.shared.OnlyToBeUsedInGeneratedCodeStringBlessedAsSafeHtml(sb.toString());
}
}
