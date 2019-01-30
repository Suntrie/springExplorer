<%@ include file="header.jsp" %>
<%--@elvariable id="geoLocation" type="com.testcase.models.GeoLocation"--%>
<spring:form method="post" modelAttribute="geoLocation" action="weatherInfo">

    <div class="form-group">
        <label for="longitude">Longitude</label>
        <spring:input type="number" class="form-control"
               id="longitude" placeholder="Enter longitude"
                      path="longitude"/>
    </div>
    <div class="form-group">
        <label for="latitude">Latitude</label>
        <spring:input type="number" class="form-control"
                      id="latitude" placeholder="Enter longitude"
                      path="latitude"/>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</spring:form>
<%@ include file="footer.jsp" %>
