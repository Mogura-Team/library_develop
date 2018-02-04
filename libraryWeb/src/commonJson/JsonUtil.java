/**
 * JsonUtil.java
 * 2017/11/05
 */
package commonJson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 拓真
 *
 */
public class JsonUtil {
  /**
  * JSON文字列をDTOクラスへ変換する
  * @param dto
  * @param json
  * @return DTOobject
  * @throws IOException
  */
  public <T> T parse(Class<T> dto, String json){
       ObjectMapper mapper = new ObjectMapper();
       try{
            return (T) mapper.readValue(json, dto);
       }catch(IOException e){
            return null;
       }
  }
  /**
  * DTOクラスのインスタンスをJSON文字列に変換する
  * @param dto
  * @return String
  * @throws JsonProcessingException
  */
  public String convert(Object dto){
       ObjectMapper mapper = new ObjectMapper();
       try{
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            return json;
       }catch(JsonProcessingException e){
            return null;
       }
  }
}
