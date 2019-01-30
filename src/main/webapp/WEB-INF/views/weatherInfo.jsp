<%@ include file="header.jsp" %>
<%--@elvariable id="geoLocation" type="com.testcase.models.GeoLocation"--%>
<form method="post" modelAttribute="geoLocation" action="weatherInfo">

    <div class="form-group">
        <label for="longitude">Longitude</label>
        <input type="number" class="form-control"
               id="longitude" placeholder="Enter longitude"
               readonly
               value='${weather.geoLocation.longitude}'
        />
    </div>
    <div class="form-group">
        <label for="latitude">Latitude</label>
        <input type="number" class="form-control"
               id="latitude"
               readonly
               value='${weather.geoLocation.latitude}'
        />
    </div>
    <div class="form-group">
        <label for="temperature">Temperature</label>
        <input type="number" class="form-control"
               id="temperature"
               readonly
               value="${weather.temperature}"
        />
    </div>
    <div class="form-group">
        <label for="pressure">Pressure</label>
        <input type="number" class="form-control"
               id="pressure"
               readonly
               value="${weather.pressure}"
        />
    </div>

    <div class="form-group">
        <label for="wind_direction">Wind (direction)</label>
        <input type="text" class="form-control"
               id="wind_direction"
               readonly
               value="${weather.wind.direction}"
        />
    </div>
    <div class="form-group">
        <label for="wind_speed">Wind (speed)</label>
        <input type="number" class="form-control"
               id="wind_speed"
               readonly
               value="${weather.wind.speed}"
        />
    </div>
</form>
<%@ include file="footer.jsp" %>