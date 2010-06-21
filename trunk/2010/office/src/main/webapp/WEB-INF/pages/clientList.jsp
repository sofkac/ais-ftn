<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="clientList.title"/></title>
    <meta name="heading" content="<fmt:message key='clientList.heading'/>"/>
    <meta name="menu" content="ClientMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editClient.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="clients" class="table" requestURI="" id="clientList" export="true" pagesize="25">
    <display:column property="idclient" sortable="true" href="editClient.html" media="html"
        paramId="idclient" paramProperty="idclient" titleKey="client.idclient"/>
    <display:column property="idclient" media="csv excel xml pdf" titleKey="client.idclient"/>
    <display:column property="naziv" sortable="true" titleKey="client.naziv"/>
    <display:column property="datumOsnivanja" sortable="true" titleKey="client.datumOsnivanja"/>
    <display:column property="opis" sortable="true" titleKey="client.opis"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="clientList.client"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="clientList.clients"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="clientList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="clientList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="clientList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("clientList");
</script>
