package sweng2023.sweng;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GreetingResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getGreeting(sweng2023.sweng.GreetingResponse instance) /*-{
    return instance.@sweng2023.sweng.GreetingResponse::greeting;
  }-*/;
  
  private static native void setGreeting(sweng2023.sweng.GreetingResponse instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.GreetingResponse::greeting = value;
  }-*/;
  
  private static native java.lang.String getServerInfo(sweng2023.sweng.GreetingResponse instance) /*-{
    return instance.@sweng2023.sweng.GreetingResponse::serverInfo;
  }-*/;
  
  private static native void setServerInfo(sweng2023.sweng.GreetingResponse instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.GreetingResponse::serverInfo = value;
  }-*/;
  
  private static native java.lang.String getUserAgent(sweng2023.sweng.GreetingResponse instance) /*-{
    return instance.@sweng2023.sweng.GreetingResponse::userAgent;
  }-*/;
  
  private static native void setUserAgent(sweng2023.sweng.GreetingResponse instance, java.lang.String value) 
  /*-{
    instance.@sweng2023.sweng.GreetingResponse::userAgent = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, sweng2023.sweng.GreetingResponse instance) throws SerializationException {
    setGreeting(instance, streamReader.readString());
    setServerInfo(instance, streamReader.readString());
    setUserAgent(instance, streamReader.readString());
    
  }
  
  public static sweng2023.sweng.GreetingResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new sweng2023.sweng.GreetingResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, sweng2023.sweng.GreetingResponse instance) throws SerializationException {
    streamWriter.writeString(getGreeting(instance));
    streamWriter.writeString(getServerInfo(instance));
    streamWriter.writeString(getUserAgent(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return sweng2023.sweng.GreetingResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    sweng2023.sweng.GreetingResponse_FieldSerializer.deserialize(reader, (sweng2023.sweng.GreetingResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    sweng2023.sweng.GreetingResponse_FieldSerializer.serialize(writer, (sweng2023.sweng.GreetingResponse)object);
  }
  
}
