package com.icteam.loyalty.model.util;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum;

public class EMFEnhancedEnumAdapter<E extends IEMFEnhancedEnum<E>> implements JsonSerializer<E>, JsonDeserializer<E> {

    @Override
    public JsonElement serialize(E src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", src.getName());

        return jsonObject;
    }

    @Override
    public E deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        JsonPrimitive prim = (JsonPrimitive) jsonObject.get("name");
        String name = prim.getAsString();

        return ModelUtil.valueOf((Class<E>) typeOfT, name);
    }
}