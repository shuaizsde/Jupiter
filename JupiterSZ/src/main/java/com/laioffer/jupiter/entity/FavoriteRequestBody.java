package com.laioffer.jupiter.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
// JsonProperty 是用拿到response导成java object 的小插件（从外界往java里存object）

//把加了星的item（传进来的是json） 转化成java 并提供get的function
public class FavoriteRequestBody {
        private final Item favoriteItem;

        @JsonCreator//把json变java
        public FavoriteRequestBody(@JsonProperty("favorite") Item favoriteItem) {
            this.favoriteItem = favoriteItem;
        }

        public Item getFavoriteItem() {
            return favoriteItem;
        }
}
