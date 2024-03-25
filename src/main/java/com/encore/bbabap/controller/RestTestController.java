package com.encore.bbabap.controller;

import com.encore.bbabap.domain.ChargingStation;
import com.encore.bbabap.domain.ChargingStations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestTestController {

    @GetMapping("/apitest")
    public String callApiWithXml() {
        StringBuffer result = new StringBuffer();

        try {
            String apiUrl = "http://safemap.go.kr/openApiService/data/getChargingStationData.do" +
                    "?serviceKey=DR8NE1Q1-DR8N-DR8N-DR8N-DR8NE1Q1HA" +
                    "&numOfRows=10" +
                    "&pageNo=4";

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            int status = urlConnection.getResponseCode();
            if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM || status == HttpURLConnection.HTTP_SEE_OTHER) {
                // 리다이렉션 URL 가져오기
                String newUrl = urlConnection.getHeaderField("Location");
                // 새 URL로 다시 연결
                urlConnection = (HttpURLConnection) new URL(newUrl).openConnection();
            }


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;
            result.append("<xmp>");
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine + "\n");
            }
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result + "</xmp>";
    }

    @GetMapping("/chargingStations")
    public List<ChargingStation> getChargingStations() {
        List<ChargingStation> stations = new ArrayList<>();
        try {
            String apiUrl = "http://safemap.go.kr/openApiService/data/getChargingStationData.do" +
                    "?serviceKey=DR8NE1Q1-DR8N-DR8N-DR8N-DR8NE1Q1HA" +
                    "&numOfRows=10" +
                    "&pageNo=1"; // 페이지 번호 조정 가능

            JAXBContext jaxbContext = JAXBContext.newInstance(ChargingStations.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ChargingStations chargingStations = (ChargingStations) unmarshaller.unmarshal(new URL(apiUrl));
            stations = chargingStations.getStations();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }
}
