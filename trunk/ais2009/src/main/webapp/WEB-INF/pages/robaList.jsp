<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="robaList.title"/></title>
    <meta name="heading" content="<fmt:message key='robaList.heading'/>"/>
    <meta name="menu" content="RobaMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editRoba.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="robas" class="table" requestURI="" id="robaList" export="true" pagesize="25">
    <display:column property="idr" sortable="true" href="editRoba.html" media="html"
        paramId="idr" paramProperty="idr" titleKey="roba.idr"/>
    <display:column property="idr" media="csv excel xml pdf" titleKey="roba.idr"/>
    <display:column property="jm" sortable="true" titleKey="roba.jm"/>
    <display:column property="kolicina" sortable="true" titleKey="roba.kolicina"/>
    <display:column property="napomena" sortable="true" titleKey="roba.napomena"/>
    <display:column property="naziv" sortable="true" titleKey="roba.naziv"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="robaList.roba"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="robaList.robas"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="robaList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="robaList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="robaList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("robaList");
</script>
