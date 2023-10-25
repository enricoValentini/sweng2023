package sweng2023.sweng;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CartaMagic_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getArtist(sweng2023.sweng.CartaMagic instance) /*-{
    return instance.@sweng2023.sweng.CartaMagic::artist;
  }-*/;
  
  private static native void setArtist(sweng2023.sweng.CartaMagic instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaMagic::artist = value;
  }-*/;
  
  private static native boolean getHasFoil(sweng2023.sweng.CartaMagic instance) /*-{
    return instance.@sweng2023.sweng.CartaMagic::hasFoil;
  }-*/;
  
  private static native void setHasFoil(sweng2023.sweng.CartaMagic instance, boolean value) 
  /*-{
    instance.@sweng2023.sweng.CartaMagic::hasFoil = value;
  }-*/;
  
  private static native boolean getIsAlternative(sweng2023.sweng.CartaMagic instance) /*-{
    return instance.@sweng2023.sweng.CartaMagic::isAlternative;
  }-*/;
  
  private static native void setIsAlternative(sweng2023.sweng.CartaMagic instance, boolean value) 
  /*-{
    instance.@sweng2023.sweng.CartaMagic::isAlternative = value;
  }-*/;
  
  private static native boolean getIsFullArt(sweng2023.sweng.CartaMagic instance) /*-{
    return instance.@sweng2023.sweng.CartaMagic::isFullArt;
  }-*/;
  
  private static native void setIsFullArt(sweng2023.sweng.CartaMagic instance, boolean value) 
  /*-{
    instance.@sweng2023.sweng.CartaMagic::isFullArt = value;
  }-*/;
  
  private static native boolean getIsPromo(sweng2023.sweng.CartaMagic instance) /*-{
    return instance.@sweng2023.sweng.CartaMagic::isPromo;
  }-*/;
  
  private static native void setIsPromo(sweng2023.sweng.CartaMagic instance, boolean value) 
  /*-{
    instance.@sweng2023.sweng.CartaMagic::isPromo = value;
  }-*/;
  
  private static native boolean getIsReprint(sweng2023.sweng.CartaMagic instance) /*-{
    return instance.@sweng2023.sweng.CartaMagic::isReprint;
  }-*/;
  
  private static native void setIsReprint(sweng2023.sweng.CartaMagic instance, boolean value) 
  /*-{
    instance.@sweng2023.sweng.CartaMagic::isReprint = value;
  }-*/;
  
  private static native java.lang.String getRarity(sweng2023.sweng.CartaMagic instance) /*-{
    return instance.@sweng2023.sweng.CartaMagic::rarity;
  }-*/;
  
  private static native void setRarity(sweng2023.sweng.CartaMagic instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaMagic::rarity = value;
  }-*/;
  
  private static native java.lang.String getText(sweng2023.sweng.CartaMagic instance) /*-{
    return instance.@sweng2023.sweng.CartaMagic::text;
  }-*/;
  
  private static native void setText(sweng2023.sweng.CartaMagic instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaMagic::text = value;
  }-*/;
  
  private static native java.lang.String getType(sweng2023.sweng.CartaMagic instance) /*-{
    return instance.@sweng2023.sweng.CartaMagic::type;
  }-*/;
  
  private static native void setType(sweng2023.sweng.CartaMagic instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.CartaMagic::type = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, sweng2023.sweng.CartaMagic instance) throws SerializationException {
    setArtist(instance, streamReader.readString());
    setHasFoil(instance, streamReader.readBoolean());
    setIsAlternative(instance, streamReader.readBoolean());
    setIsFullArt(instance, streamReader.readBoolean());
    setIsPromo(instance, streamReader.readBoolean());
    setIsReprint(instance, streamReader.readBoolean());
    setRarity(instance, streamReader.readString());
    setText(instance, streamReader.readString());
    setType(instance, streamReader.readString());
    
    sweng2023.sweng.Carta_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static sweng2023.sweng.CartaMagic instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new sweng2023.sweng.CartaMagic();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, sweng2023.sweng.CartaMagic instance) throws SerializationException {
    streamWriter.writeString(getArtist(instance));
    streamWriter.writeBoolean(getHasFoil(instance));
    streamWriter.writeBoolean(getIsAlternative(instance));
    streamWriter.writeBoolean(getIsFullArt(instance));
    streamWriter.writeBoolean(getIsPromo(instance));
    streamWriter.writeBoolean(getIsReprint(instance));
    streamWriter.writeString(getRarity(instance));
    streamWriter.writeString(getText(instance));
    streamWriter.writeString(getType(instance));
    
    sweng2023.sweng.Carta_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return sweng2023.sweng.CartaMagic_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    sweng2023.sweng.CartaMagic_FieldSerializer.deserialize(reader, (sweng2023.sweng.CartaMagic)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    sweng2023.sweng.CartaMagic_FieldSerializer.serialize(writer, (sweng2023.sweng.CartaMagic)object);
  }
  
}
