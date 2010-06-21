<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="osobljeList.title"/></title>
    <meta name="heading" content="<fmt:message key='osobljeList.heading'/>"/>
    <meta name="menu" content="OsobljeMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editOsoblje.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="osobljes" class="table" requestURI="" id="osobljeList" export="true" pagesize="25">
    <display:column property="osobljeID" sortable="true" href="editOsoblje.html" media="html"
        paramId="osobljeID" paramProperty="osobljeID" titleKey="osoblje.osobljeID"/>
    <display:column property="osobljeID" media="csv excel xml pdf" titleKey="osoblje.osobljeID"/>
    <display:column property="detalji" sortable="true" titleKey="osoblje.detalji"/>
    <display:column property="ime" sortable="true" titleKey="osoblje.ime"/>
    <display:column property="prezime" sortable="true" titleKey="osoblje.prezime"/>
    <display:column property="telefon" sortable="true" titleKey="osoblje.telefon"/>
    <display:column property="vrsta" sortable="true" titleKey="osoblje.vrsta"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="osobljeList.osoblje"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="osobljeList.osobljes"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="osobljeList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="osobljeList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="osobljeList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("osobljeList");
</script>
