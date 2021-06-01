package com.laioffer.jupiter.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonProperty： 有json格式的object想存进来的时候 帮助认领相对应的java field， 并进行写操作
//Shen: 解析前端的json 转成java， deserilization
public class LoginRequestBody {
    private final String userId;
    private final String password;

    //本class的constructor，用于convert用户输入的json变成我们后端可以操作的java obj
    //    public LoginRequestBody(@JsonProperty("user_id") String userId, @JsonProperty("password") String password) {
    //        this.userId = userId;
    //        this.password = password;
    //    }
    @JsonCreator
    public LoginRequestBody(@JsonProperty("user_id") String userId,
                            @JsonProperty("password") String password){
            this.userId= userId;
            this.password= password;
    }
    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }


}
