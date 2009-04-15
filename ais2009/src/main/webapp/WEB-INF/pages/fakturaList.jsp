<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="fakturaList.title"/></title>
    <meta name="heading" content="<fmt:message key='fakturaList.heading'/>"/>
    <meta name="menu" content="FakturaMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editFaktura.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="fakturas" class="table" requestURI="" id="fakturaList" export="true" pagesize="25">
    <display:column property="idf" sortable="true" href="editFaktura.html" media="html"
        paramId="idf" paramProperty="idf" titleKey="faktura.idf"/>
    <display:column property="idf" media="csv excel xml pdf" titleKey="faktura.idf"/>
    <display:column property="datum" sortable="true" titleKey="faktura.datum"/>
    <display:column property="iznos" sortable="true" titleKey="faktura.iznos"/>
    <display:column property="napomena" sortable="true" titleKey="faktura.napomena"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="fakturaList.faktura"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="fakturaList.fakturas"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="fakturaList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="fakturaList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="fakturaList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("fakturaList");
</script>
