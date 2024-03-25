document.addEventListener('DOMContentLoaded', function() {
    fetchChargingStations(); // 충전소 정보를 불러오는 함수 호출
});

function init() {
    fetchChargingStations(); // 충전소 정보를 불러오는 함수 호출
}

function fetchChargingStations() {
    // API 호출 및 데이터 처리 로직...
    // 예시로, '/apitest' 엔드포인트로부터 데이터를 가져오는 코드
    fetch("/apitest")
        .then(response => response.text())
        .then(data => {
            displayResults(data); // 화면에 충전소 정보를 표시하는 함수
        })
        .catch(error => console.error('Error:', error));
}

function displayResults(xmlData) {
    const parser = new DOMParser();
    const xmlDoc = parser.parseFromString(xmlData, "text/xml");
    const items = xmlDoc.getElementsByTagName("item");
    let htmlContent = "";

    for (let i = 0; i < items.length; i++) {
        const stationName = items[i].getElementsByTagName("STAT_NM")[0].childNodes[0].nodeValue;
        const address = items[i].getElementsByTagName("RN_ADRES")[0].childNodes[0].nodeValue;
        const useTime = items[i].getElementsByTagName("USE_TM")[0].childNodes[0].nodeValue;
        const telNo = items[i].getElementsByTagName("TELNO")[0].childNodes[0].nodeValue;

        // 충전소 정보를 나열
        htmlContent += `<div class="station">
            <h3>${stationName}</h3>
            <p>주소: ${address}</p>
            <p>이용 시간: ${useTime}</p>
            <p>연락처: ${telNo}</p>
        </div>`;
    }

    if (htmlContent === "") {
        htmlContent = "<p>충전소 정보가 없습니다.</p>";
    }

    document.getElementById("results").innerHTML = htmlContent;
}
