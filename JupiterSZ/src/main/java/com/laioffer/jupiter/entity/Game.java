/*@JsonProperty("") indicates the mapping, the exact match is not required, but it’s required for
multi-word snake case and camel case conversions, like release_time to releaseTime.

Note the @JsonProperty("") annotation is applied to the getter method instead of the field.
This is because the field is private and the way to get the data is by getter.

twitch ID ：  f2magq76stgqg668e0s53t9ejimejv
*/

package com.laioffer.jupiter.entity;
// import Jackson. Jackson 是用拿到response导成java object 的小插件（从外界往java里存object）
import com.fasterxml.jackson.annotation.JsonProperty;
//import jackson 处理特殊情况的一些应用  handle some edge cases.
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//jackson 处理特殊情况的一些应用
@JsonIgnoreProperties(ignoreUnknown = true)//告诉jackson response里我只要我这个class里面的映射的东西
@JsonInclude(JsonInclude.Include.NON_NULL)//indicates that null fields can be skipped and not included.
@JsonDeserialize(builder = Game.Builder.class)// 告诉jackson 用Game.Builder建新对象
public class Game {
    //fields, Jackson 认的是括号里的名字， 他会把我们java定义的field 转化成相应的json格式
    @JsonProperty("id")
    private final String id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("box_art_url")//图标
    private final String boxArtUrl;

    //constructor through Builder
    private Game(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.boxArtUrl = builder.boxArtUrl;
    }

    //define Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Builder {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("box_art_url")
        private String boxArtUrl;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder boxArtUrl(String boxArtUrl) {
            this.boxArtUrl = boxArtUrl;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBoxArtUrl() {
        return boxArtUrl;
    }


}
