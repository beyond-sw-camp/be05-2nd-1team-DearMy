package com.encore.bbabap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@RestController
public class ChargingStationController {

    @GetMapping("/api/charging-stations")
    public List<Map<String, String>> getChargingStations() {
        List<Map<String, String>> stations = new ArrayList<>();
        try {
            String apiUrl = "http://safemap.go.kr/openApiService/data/getChargingStationData.do" +
                    "?serviceKey=DR8NE1Q1-DR8N-DR8N-DR8N-DR8NE1Q1HA" + // 실제 서비스키로 변경 필요
                    "&numOfRows=10" +
                    "&pageNo=1";

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(urlConnection.getInputStream());
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("item");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Map<String, String> station = new HashMap<>();
                    station.put("OBJT_ID", element.getElementsByTagName("OBJT_ID").item(0).getTextContent());
                    station.put("STAT_NM", element.getElementsByTagName("STAT_NM").item(0).getTextContent());
                    station.put("STAT_ID", element.getElementsByTagName("STAT_ID").item(0).getTextContent());
                    station.put("CHGER_ID", element.getElementsByTagName("CHGER_ID").item(0).getTextContent());
                    station.put("CHGER_TY", element.getElementsByTagName("CHGER_TY").item(0).getTextContent());
                    station.put("USE_TM", element.getElementsByTagName("USE_TM").item(0).getTextContent());
                    station.put("BUSI_ID", element.getElementsByTagName("BUSI_ID").item(0).getTextContent());
                    station.put("BUSI_NM", element.getElementsByTagName("BUSI_NM").item(0).getTextContent());
                    station.put("TELNO", element.getElementsByTagName("TELNO").item(0).getTextContent());
                    station.put("ADRES", element.getElementsByTagName("ADRES").item(0).getTextContent());
                    station.put("RN_ADRES", element.getElementsByTagName("RN_ADRES").item(0).getTextContent());
                    station.put("CTPRVN_CD", element.getElementsByTagName("CTPRVN_CD").item(0).getTextContent());
                    station.put("SGG_CD", element.getElementsByTagName("SGG_CD").item(0).getTextContent());
                    station.put("EMD_CD", element.getElementsByTagName("EMD_CD").item(0).getTextContent());
                    station.put("X", element.getElementsByTagName("X").item(0).getTextContent());
                    station.put("Y", element.getElementsByTagName("Y").item(0).getTextContent());
                    stations.add(station);
                }
            }
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }
}
