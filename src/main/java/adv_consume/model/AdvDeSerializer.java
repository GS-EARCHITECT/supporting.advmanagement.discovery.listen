package adv_consume.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class AdvDeSerializer implements Deserializer<AdvMaster_DTO> 
{
    
	 private ObjectMapper objectMapper = new ObjectMapper();

	    @Override
	    public void configure(Map<String, ?> configs, boolean isKey) {
	    }

	    @Override
	    public AdvMaster_DTO deserialize(String topic, byte[] data) 
	    {
	        try {
	            if (data == null){
	                System.out.println("Null received at deserializing");
	                return null;
	            }
	            System.out.println("Deserializing...");
	            return objectMapper.readValue(new String(data, "UTF-8"), AdvMaster_DTO.class);
	        } catch (Exception e) {
	            throw new SerializationException("Error when deserializing byte[] to MessageDto");
	        }
	    }
	    
	    @Override
	    public void close() {
	    }
}