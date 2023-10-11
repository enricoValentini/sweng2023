package sweng2023.sweng;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CartaPokemon_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getDescription(sweng2023.sweng.CartaPokemon instance) /*-{
    return instance.@sweng2023.sweng.CartaPokemon::description;
  }-*/;
  
  private static native void setDescription(sweng2023.sweng.CartaPokemon instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaPokemon::description = value;
  }-*/;
  
  private static native java.lang.String getIllustrator(sweng2023.sweng.CartaPokemon instance) /*-{
    return instance.@sweng2023.sweng.CartaPokemon::illustrator;
  }-*/;
  
  private static native void setIllustrator(sweng2023.sweng.CartaPokemon instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaPokemon::illustrator = value;
  }-*/;
  
  private static native java.lang.String getImage(sweng2023.sweng.CartaPokemon instance) /*-{
    return instance.@sweng2023.sweng.CartaPokemon::image;
  }-*/;
  
  private static native void setImage(sweng2023.sweng.CartaPokemon instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaPokemon::image = value;
  }-*/;
  
  private static native java.lang.String getRarity(sweng2023.sweng.CartaPokemon instance) /*-{
    return instance.@sweng2023.sweng.CartaPokemon::rarity;
  }-*/;
  
  private static native void setRarity(sweng2023.sweng.CartaPokemon instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaPokemon::rarity = value;
  }-*/;
  
  private static native java.util.List getTypes(sweng2023.sweng.CartaPokemon instance) /*-{
    return instance.@sweng2023.sweng.CartaPokemon::types;
  }-*/;
  
  private static native void setTypes(sweng2023.sweng.CartaPokemon instance, java.util.List value) 
  /*-{
    instance.@sweng2023.sweng.CartaPokemon::types = value;
  }-*/;
  
  private static native sweng2023.sweng.Varianti getVariants(sweng2023.sweng.CartaPokemon instance) /*-{
    return instance.@sweng2023.sweng.CartaPokemon::variants;
  }-*/;
  
  private static native void setVariants(sweng2023.sweng.CartaPokemon instance, sweng2023.sweng.Varianti value) 
  /*-{
    instance.@sweng2023.sweng.CartaPokemon::variants = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, sweng2023.sweng.CartaPokemon instance) throws SerializationException {
    setDescription(instance, streamReader.readString());
    setIllustrator(instance, streamReader.readString());
    setImage(instance, streamReader.readString());
    setRarity(instance, streamReader.readString());
    setTypes(instance, (java.util.List) streamReader.readObject());
    setVariants(instance, (sweng2023.sweng.Varianti) streamReader.readObject());
    
    sweng2023.sweng.Carta_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static sweng2023.sweng.CartaPokemon instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new sweng2023.sweng.CartaPokemon();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, sweng2023.sweng.CartaPokemon instance) throws SerializationException {
    streamWriter.writeString(getDescription(instance));
    streamWriter.writeString(getIllustrator(instance));
    streamWriter.writeString(getImage(instance));
    streamWriter.writeString(getRarity(instance));
    streamWriter.writeObject(getTypes(instance));
    streamWriter.writeObject(getVariants(instance));
    
    sweng2023.sweng.Carta_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return sweng2023.sweng.CartaPokemon_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    sweng2023.sweng.CartaPokemon_FieldSerializer.deserialize(reader, (sweng2023.sweng.CartaPokemon)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    sweng2023.sweng.CartaPokemon_FieldSerializer.serialize(writer, (sweng2023.sweng.CartaPokemon)object);
  }
  
}
