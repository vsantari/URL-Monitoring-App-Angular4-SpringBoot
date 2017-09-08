package com.urlmonitor.service.Url;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.urlmonitor.model.Url.URL;

@Service
public class URLService {
    private HttpConnection httpConnection = new HttpConnection();
    private Logger LOG = LogManager.getLogger(URLService.class);

    /**
     * Start checking URL connection and parsing it's content
     * @param urlStrings URL strings
     * @return List of com.urlmonitor.model.Url.URL
     */
    public List<URL> startMonitor(List<String> urlStrings) {
        LOG.debug("Start startMonitor. name={}", urlStrings);
        List<URL> urlList = new ArrayList();
        if (urlStrings == null) {
            LOG.debug("Empty URL Strings");
            return null;
        }

        int idCount = 1;
        for (String urlString : urlStrings) {
            for (int retry = 1; retry <= 3; retry++) {
                LinkedHashMap<String, String> output = httpConnection.checkHttpURLConnection(urlString, retry);
                if (!output.containsKey(ConstantValues.MAP_ERROR_KEY) || output.containsValue(ConstantValues.NO_COMPONENT_STATUS_GREEN)) {
                    urlList.add(setURLData(idCount, output));
                    idCount++;
                    break;
                }
                if (output.containsKey(ConstantValues.MAP_ERROR_KEY) && retry == 3) {
                    urlList.add(setURLData(idCount, output));
                    idCount++;
                }
            }
        }
        return urlList;
    }

    private URL setURLData(int id, LinkedHashMap<String, String> output) {
        URL url = new URL();
        url.setId(id);
        for (String key : output.keySet()) {
            String value = output.get(key);
            if (key == ConstantValues.MAP_TIMESTAMP_KEY)
                url.setTimestamp(value);
            if (key == ConstantValues.MAP_URL_KEY)
                url.setUrl(value);
            if (key == ConstantValues.MAP_STATUS_KEY)
                url.setStatus(value);
            if (key == ConstantValues.MAP_RESPONSE_TIME_KEY)
                url.setResponseTime(value);
            if (key == ConstantValues.MAP_RETRY_KEY)
                url.setRetry(Integer.valueOf(value));
            if (key == ConstantValues.MAP_ERROR_KEY)
                url.setError(value);
            String ret = output.get(key);
            LOG.debug(ret);
        }
        return url;
    }
}

