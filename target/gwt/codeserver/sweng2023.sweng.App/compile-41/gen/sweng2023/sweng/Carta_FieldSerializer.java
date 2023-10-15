package sweng2023.sweng;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Carta_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, sweng2023.sweng.Carta instance) throws SerializationException {
    instance.name = streamReader.readString();
    
  }
  
  public static sweng2023.sweng.Carta instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new sweng2023.sweng.Carta();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, sweng2023.sweng.Carta instance) throws SerializationException {
    streamWriter.writeString(instance.name);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return sweng2023.sweng.Carta_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    sweng2023.sweng.Carta_FieldSerializer.deserialize(reader, (sweng2023.sweng.Carta)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    sweng2023.sweng.Carta_FieldSerializer.serialize(writer, (sweng2023.sweng.Carta)object);
  }
  
}
