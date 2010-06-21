<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="placanjaList.title"/></title>
    <meta name="heading" content="<fmt:message key='placanjaList.heading'/>"/>
    <meta name="menu" content="PlacanjaMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editPlacanja.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="placanjas" class="table" requestURI="" id="placanjaList" export="true" pagesize="25">
    <display:column property="idplacanje" sortable="true" href="editPlacanja.html" media="html"
        paramId="idplacanje" paramProperty="idplacanje" titleKey="placanja.idplacanje"/>
    <display:column property="idplacanje" media="csv excel xml pdf" titleKey="placanja.idplacanje"/>
    <display:column property="date" sortable="true" titleKey="placanja.date"/>
    <display:column property="detalji" sortable="true" titleKey="placanja.detalji"/>
    <display:column property="iznos" sortable="true" titleKey="placanja.iznos"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="placanjaList.placanja"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="placanjaList.placanjas"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="placanjaList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="placanjaList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="placanjaList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("placanjaList");
</script>
