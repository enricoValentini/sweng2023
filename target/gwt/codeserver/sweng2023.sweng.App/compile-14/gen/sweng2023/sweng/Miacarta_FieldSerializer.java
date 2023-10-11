package sweng2023.sweng;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Miacarta_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native sweng2023.sweng.Carta getCarta(sweng2023.sweng.Miacarta instance) /*-{
    return instance.@sweng2023.sweng.Miacarta::carta;
  }-*/;
  
  private static native void setCarta(sweng2023.sweng.Miacarta instance, sweng2023.sweng.Carta value) 
  /*-{
    instance.@sweng2023.sweng.Miacarta::carta = value;
  }-*/;
  
  private static native java.lang.String getDescrizione(sweng2023.sweng.Miacarta instance) /*-{
    return instance.@sweng2023.sweng.Miacarta::descrizione;
  }-*/;
  
  private static native void setDescrizione(sweng2023.sweng.Miacarta instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.Miacarta::descrizione = value;
  }-*/;
  
  private static native int getStato(sweng2023.sweng.Miacarta instance) /*-{
    return instance.@sweng2023.sweng.Miacarta::stato;
  }-*/;
  
  private static native void setStato(sweng2023.sweng.Miacarta instance, int value) 
  /*-{
    instance.@sweng2023.sweng.Miacarta::stato = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, sweng2023.sweng.Miacarta instance) throws SerializationException {
    setCarta(instance, (sweng2023.sweng.Carta) streamReader.readObject());
    setDescrizione(instance, streamReader.readString());
    setStato(instance, streamReader.readInt());
    
  }
  
  public static sweng2023.sweng.Miacarta instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new sweng2023.sweng.Miacarta();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, sweng2023.sweng.Miacarta instance) throws SerializationException {
    streamWriter.writeObject(getCarta(instance));
    streamWriter.writeString(getDescrizione(instance));
    streamWriter.writeInt(getStato(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return sweng2023.sweng.Miacarta_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    sweng2023.sweng.Miacarta_FieldSerializer.deserialize(reader, (sweng2023.sweng.Miacarta)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    sweng2023.sweng.Miacarta_FieldSerializer.serialize(writer, (sweng2023.sweng.Miacarta)object);
  }
  
}
