package com.mobiquity.utility;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.dto.AtmsInfo;
import com.mobiquity.exception.RawJsonParseException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Utility {

    public static List<AtmsInfo> mapJsonStringToObject(String parsedJsonString) throws RawJsonParseException {
        List<AtmsInfo> atmsInfos = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        if (StringUtils.isBlank(parsedJsonString)) {
            return atmsInfos;
        }
        try {
            atmsInfos = mapper.readValue(parsedJsonString, new TypeReference<List<AtmsInfo>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RawJsonParseException("Unable to map each fields of json to object of pojo class(AtmsInfo)");
        }
        return atmsInfos;
    }

    public static String parseInputJson(String rawJson) {
        if(StringUtils.isBlank(rawJson)) {
            return rawJson;
        }
        int indexOf = rawJson.indexOf("[");
        return rawJson.substring(indexOf);
    }
}
