package com.mobiquity.service;

import com.mobiquity.dto.AtmsInfo;
import com.mobiquity.exception.EntityNotFoundException;
import com.mobiquity.exception.RawJsonParseException;
import com.mobiquity.utility.Utility;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtmsService {

    @Autowired
    private WebClient webClientBuilder;

    @Value("${atms.uri}")
    private String uri;

    /**
     * get all atms details
     * @return
     * @throws RawJsonParseException
     */
    public List<AtmsInfo> getAllAtms() throws RawJsonParseException {
        String parsedJsonString = Utility.parseInputJson(getRawJsonFromExternalApi());
        return Utility.mapJsonStringToObject(parsedJsonString);
    }

    /**
     * This Method will filter Atms based on city
     * @param city
     * @return
     * @throws RawJsonParseException
     */
    public List<AtmsInfo> getAtmsByCity(final String city) throws RawJsonParseException {
        String parsedJsonString = Utility.parseInputJson(getRawJsonFromExternalApi());
        List<AtmsInfo> atmsInfos = Utility.mapJsonStringToObject(parsedJsonString);
        List<AtmsInfo> atmsInfosByCity = atmsInfos.stream().filter(p -> p.getAddress().getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        if (ObjectUtils.isEmpty(atmsInfosByCity)) {
            throw new EntityNotFoundException(AtmsInfo.class, city);
        }
        return atmsInfosByCity;
    }

    /**
     * Method is ued to communicate to external service
     * @return String
     */
    private String getRawJsonFromExternalApi() {
        return webClientBuilder.get().uri(uri).retrieve()
                .bodyToMono(String.class).block();
    }

}
