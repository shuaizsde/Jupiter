package com.laioffer.jupiter.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//jackson 处理特殊情况的一些应用
@JsonIgnoreProperties(ignoreUnknown = true)//告诉jackson response里我只要我这个class里面的映射的东西
@JsonInclude(JsonInclude.Include.NON_NULL)//indicates that null fields can be skipped and not included.
@JsonDeserialize(builder = Item.Builder.class)// 告诉jackson 用Game.Builder建新对象
public class Item {
    @JsonProperty("id")
    private final String id;

    @JsonProperty("title")
    private final String title;

    @JsonProperty("thumbnail_url")//视频小图
    private final String thumbnailUrl;

    //@JsonAlias indicates that the field could be retrieved by another key.
    @JsonProperty("broadcaster_name")
    @JsonAlias({ "user_name" })
    private String broadcasterName;

    @JsonProperty("url")//真正的视频链接
    private String url;

    @JsonProperty("game_id")
    private String gameId;
    //jackson可以把enum识别出来吗？ 看来是的
    @JsonProperty("item_type")//video, clip or stream
    private ItemType type;


    // Constructor
    private Item(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.url = builder.url;
        this.thumbnailUrl = builder.thumbnailUrl;
        this.broadcasterName = builder.broadcasterName;
        this.gameId = builder.gameId;
        this.type = builder.type;
    }

    //Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Builder {
        @JsonProperty("id")
        private String id;

        @JsonProperty("title")
        private String title;

        @JsonProperty("url")
        private String url;

        @JsonProperty("thumbnail_url")
        private String thumbnailUrl;

        @JsonProperty("broadcaster_name")
        @JsonAlias({ "user_name" })
        private String broadcasterName;

        @JsonProperty("game_id")
        private String gameId;

        @JsonProperty("item_type")
        private ItemType type;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder thumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        public Builder broadcasterName(String broadcasterName) {
            this.broadcasterName = broadcasterName;
            return this;
        }

        public Builder gameId(String gameId) {
            this.gameId = gameId;
            return this;
        }

        public Builder type(ItemType type) {
            this.type = type;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

//Setter and Getter
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getBroadcasterName() {
        return broadcasterName;
    }

    public String getUrl() {
        return url;
    }

    public ItemType getType() {
        return type;
    }

    public String getGameId() {
        return gameId;
    }

    public Item setType(ItemType type) {
        this.type = type;
        return this;
    }

    public Item setBroadcasterName(String broadcasterName) {
        this.broadcasterName = broadcasterName;
        return this;
    }

    public Item setUrl(String url) {
        this.url = url;
        return this;
    }

    public Item setGameId(String gameId) {
        this.gameId = gameId;
        return this;
    }


}

