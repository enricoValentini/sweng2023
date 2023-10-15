package sweng2023.sweng;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Varianti_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native boolean getFirstEdition(sweng2023.sweng.Varianti instance) /*-{
    return instance.@sweng2023.sweng.Varianti::firstEdition;
  }-*/;
  
  private static native void setFirstEdition(sweng2023.sweng.Varianti instance, boolean value) 
  /*-{
    instance.@sweng2023.sweng.Varianti::firstEdition = value;
  }-*/;
  
  private static native boolean getHolo(sweng2023.sweng.Varianti instance) /*-{
    return instance.@sweng2023.sweng.Varianti::holo;
  }-*/;
  
  private static native void setHolo(sweng2023.sweng.Varianti instance, boolean value) 
  /*-{
    instance.@sweng2023.sweng.Varianti::holo = value;
  }-*/;
  
  private static native boolean getNormal(sweng2023.sweng.Varianti instance) /*-{
    return instance.@sweng2023.sweng.Varianti::normal;
  }-*/;
  
  private static native void setNormal(sweng2023.sweng.Varianti instance, boolean value) 
  /*-{
    instance.@sweng2023.sweng.Varianti::normal = value;
  }-*/;
  
  private static native boolean getReverse(sweng2023.sweng.Varianti instance) /*-{
    return instance.@sweng2023.sweng.Varianti::reverse;
  }-*/;
  
  private static native void setReverse(sweng2023.sweng.Varianti instance, boolean value) 
  /*-{
    instance.@sweng2023.sweng.Varianti::reverse = value;
  }-*/;
  
  private static native boolean getWPromo(sweng2023.sweng.Varianti instance) /*-{
    return instance.@sweng2023.sweng.Varianti::wPromo;
  }-*/;
  
  private static native void setWPromo(sweng2023.sweng.Varianti instance, boolean value) 
  /*-{
    instance.@sweng2023.sweng.Varianti::wPromo = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, sweng2023.sweng.Varianti instance) throws SerializationException {
    setFirstEdition(instance, streamReader.readBoolean());
    setHolo(instance, streamReader.readBoolean());
    setNormal(instance, streamReader.readBoolean());
    setReverse(instance, streamReader.readBoolean());
    setWPromo(instance, streamReader.readBoolean());
    
  }
  
  public static sweng2023.sweng.Varianti instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new sweng2023.sweng.Varianti();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, sweng2023.sweng.Varianti instance) throws SerializationException {
    streamWriter.writeBoolean(getFirstEdition(instance));
    streamWriter.writeBoolean(getHolo(instance));
    streamWriter.writeBoolean(getNormal(instance));
    streamWriter.writeBoolean(getReverse(instance));
    streamWriter.writeBoolean(getWPromo(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return sweng2023.sweng.Varianti_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    sweng2023.sweng.Varianti_FieldSerializer.deserialize(reader, (sweng2023.sweng.Varianti)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    sweng2023.sweng.Varianti_FieldSerializer.serialize(writer, (sweng2023.sweng.Varianti)object);
  }
  
}
