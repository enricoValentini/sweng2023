package sweng2023.sweng;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CartaYugioh_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getDesc(sweng2023.sweng.CartaYugioh instance) /*-{
    return instance.@sweng2023.sweng.CartaYugioh::desc;
  }-*/;
  
  private static native void setDesc(sweng2023.sweng.CartaYugioh instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaYugioh::desc = value;
  }-*/;
  
  private static native java.lang.String getImage_url(sweng2023.sweng.CartaYugioh instance) /*-{
    return instance.@sweng2023.sweng.CartaYugioh::image_url;
  }-*/;
  
  private static native void setImage_url(sweng2023.sweng.CartaYugioh instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaYugioh::image_url = value;
  }-*/;
  
  private static native java.lang.String getRace(sweng2023.sweng.CartaYugioh instance) /*-{
    return instance.@sweng2023.sweng.CartaYugioh::race;
  }-*/;
  
  private static native void setRace(sweng2023.sweng.CartaYugioh instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaYugioh::race = value;
  }-*/;
  
  private static native java.lang.String getSmall_image_url(sweng2023.sweng.CartaYugioh instance) /*-{
    return instance.@sweng2023.sweng.CartaYugioh::small_image_url;
  }-*/;
  
  private static native void setSmall_image_url(sweng2023.sweng.CartaYugioh instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaYugioh::small_image_url = value;
  }-*/;
  
  private static native java.lang.String getType(sweng2023.sweng.CartaYugioh instance) /*-{
    return instance.@sweng2023.sweng.CartaYugioh::type;
  }-*/;
  
  private static native void setType(sweng2023.sweng.CartaYugioh instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaYugioh::type = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, sweng2023.sweng.CartaYugioh instance) throws SerializationException {
    setDesc(instance, streamReader.readString());
    setImage_url(instance, streamReader.readString());
    setRace(instance, streamReader.readString());
    setSmall_image_url(instance, streamReader.readString());
    setType(instance, streamReader.readString());
    
    sweng2023.sweng.Carta_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static sweng2023.sweng.CartaYugioh instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new sweng2023.sweng.CartaYugioh();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, sweng2023.sweng.CartaYugioh instance) throws SerializationException {
    streamWriter.writeString(getDesc(instance));
    streamWriter.writeString(getImage_url(instance));
    streamWriter.writeString(getRace(instance));
    streamWriter.writeString(getSmall_image_url(instance));
    streamWriter.writeString(getType(instance));
    
    sweng2023.sweng.Carta_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return sweng2023.sweng.CartaYugioh_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    sweng2023.sweng.CartaYugioh_FieldSerializer.deserialize(reader, (sweng2023.sweng.CartaYugioh)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    sweng2023.sweng.CartaYugioh_FieldSerializer.serialize(writer, (sweng2023.sweng.CartaYugioh)object);
  }
  
}
