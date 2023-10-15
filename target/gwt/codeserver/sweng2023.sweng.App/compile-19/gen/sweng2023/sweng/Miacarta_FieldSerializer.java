package sweng2023.sweng;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Miacarta_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, sweng2023.sweng.Miacarta instance) throws SerializationException {
    instance.carta = (sweng2023.sweng.Carta) streamReader.readObject();
    instance.descrizione = streamReader.readString();
    instance.stato = streamReader.readInt();
    
  }
  
  public static sweng2023.sweng.Miacarta instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new sweng2023.sweng.Miacarta();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, sweng2023.sweng.Miacarta instance) throws SerializationException {
    streamWriter.writeObject(instance.carta);
    streamWriter.writeString(instance.descrizione);
    streamWriter.writeInt(instance.stato);
    
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
