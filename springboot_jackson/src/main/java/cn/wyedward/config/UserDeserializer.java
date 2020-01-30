package cn.wyedward.config;

import cn.wyedward.domain.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class UserDeserializer extends JsonDeserializer<User> {
    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        TreeNode node = jsonParser.getCodec().readTree(jsonParser);
        JsonToken userName = node.get("user_name").asToken();
        User user = new User();
        user.setUserName(userName.asString());
        return user;
    }
}
