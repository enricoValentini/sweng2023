package sweng2023.sweng;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Scambio_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native sweng2023.sweng.Miacarta getDaCedere(sweng2023.sweng.Scambio instance) /*-{
    return instance.@sweng2023.sweng.Scambio::daCedere;
  }-*/;
  
  private static native void setDaCedere(sweng2023.sweng.Scambio instance, sweng2023.sweng.Miacarta value) 
  /*-{
    instance.@sweng2023.sweng.Scambio::daCedere = value;
  }-*/;
  
  private static native sweng2023.sweng.Miacarta getDaRicevere(sweng2023.sweng.Scambio instance) /*-{
    return instance.@sweng2023.sweng.Scambio::daRicevere;
  }-*/;
  
  private static native void setDaRicevere(sweng2023.sweng.Scambio instance, sweng2023.sweng.Miacarta value) 
  /*-{
    instance.@sweng2023.sweng.Scambio::daRicevere = value;
  }-*/;
  
  private static native java.lang.String getMittente(sweng2023.sweng.Scambio instance) /*-{
    return instance.@sweng2023.sweng.Scambio::mittente;
  }-*/;
  
  private static native void setMittente(sweng2023.sweng.Scambio instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.Scambio::mittente = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, sweng2023.sweng.Scambio instance) throws SerializationException {
    setDaCedere(instance, (sweng2023.sweng.Miacarta) streamReader.readObject());
    setDaRicevere(instance, (sweng2023.sweng.Miacarta) streamReader.readObject());
    setMittente(instance, streamReader.readString());
    
  }
  
  public static sweng2023.sweng.Scambio instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new sweng2023.sweng.Scambio();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, sweng2023.sweng.Scambio instance) throws SerializationException {
    streamWriter.writeObject(getDaCedere(instance));
    streamWriter.writeObject(getDaRicevere(instance));
    streamWriter.writeString(getMittente(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return sweng2023.sweng.Scambio_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    sweng2023.sweng.Scambio_FieldSerializer.deserialize(reader, (sweng2023.sweng.Scambio)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    sweng2023.sweng.Scambio_FieldSerializer.serialize(writer, (sweng2023.sweng.Scambio)object);
  }
  
}
