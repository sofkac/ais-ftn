<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="officeList.title"/></title>
    <meta name="heading" content="<fmt:message key='officeList.heading'/>"/>
    <meta name="menu" content="OfficeMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editOffice.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="offices" class="table" requestURI="" id="officeList" export="true" pagesize="25">
    <display:column property="idoffice" sortable="true" href="editOffice.html" media="html"
        paramId="idoffice" paramProperty="idoffice" titleKey="office.idoffice"/>
    <display:column property="idoffice" media="csv excel xml pdf" titleKey="office.idoffice"/>
    <display:column property="adresa" sortable="true" titleKey="office.adresa"/>
    <display:column property="grad" sortable="true" titleKey="office.grad"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="officeList.office"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="officeList.offices"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="officeList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="officeList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="officeList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("officeList");
</script>
