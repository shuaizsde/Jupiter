package com.laioffer.jupiter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

//LoginResponse需要把java转成json传走
//序列化：java to json
//反序列化： json to java
/*举例
public class JsonTest {

    @Test
    public void JsonTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = " {\n" +
                "      \"name\":\"Coke\",\n" +
                "      \"capacity\":500\n" +
                "}";

        //json deserialization
        Coke coke = mapper.readValue(jsonStr,Coke.class);
        System.out.println(coke.capacity);

        //json serialization
        Coke coke1 = new Coke();

        coke1.setName("BigCoke");
        coke1.setCapacity(680);

        String serializationJson = mapper.writeValueAsString(coke1);
        System.out.println(serializationJson);
    }
}
//response 的参数是从java 来的 要让json 认领 所以在定义处 而不是传参时@JsonProperty
*/
//Shen: java to jason， serilization
public class LoginResponseBody {
    @JsonProperty("user_id")
    private final String userId;

    @JsonProperty("name")
    private final String name;

    public LoginResponseBody(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }


}
