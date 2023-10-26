package sweng2023.sweng;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Deck_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.List getCarte(sweng2023.sweng.Deck instance) /*-{
    return instance.@sweng2023.sweng.Deck::carte;
  }-*/;
  
  private static native void setCarte(sweng2023.sweng.Deck instance, java.util.List value) 
  /*-{
    instance.@sweng2023.sweng.Deck::carte = value;
  }-*/;
  
  private static native java.lang.String getNome(sweng2023.sweng.Deck instance) /*-{
    return instance.@sweng2023.sweng.Deck::nome;
  }-*/;
  
  private static native void setNome(sweng2023.sweng.Deck instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.Deck::nome = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, sweng2023.sweng.Deck instance) throws SerializationException {
    setCarte(instance, (java.util.List) streamReader.readObject());
    setNome(instance, streamReader.readString());
    
  }
  
  public static sweng2023.sweng.Deck instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new sweng2023.sweng.Deck();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, sweng2023.sweng.Deck instance) throws SerializationException {
    streamWriter.writeObject(getCarte(instance));
    streamWriter.writeString(getNome(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return sweng2023.sweng.Deck_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    sweng2023.sweng.Deck_FieldSerializer.deserialize(reader, (sweng2023.sweng.Deck)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    sweng2023.sweng.Deck_FieldSerializer.serialize(writer, (sweng2023.sweng.Deck)object);
  }
  
}
