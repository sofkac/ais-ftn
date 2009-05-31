<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="klijentList.title"/></title>
    <meta name="heading" content="<fmt:message key='klijentList.heading'/>"/>
    <meta name="menu" content="ApplicationMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editKlijent.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="klijents" class="table" requestURI="" id="klijentList" export="true" pagesize="25">
    <display:column property="idk" sortable="true" href="editKlijent.html" media="html"
        paramId="idk" paramProperty="idk" titleKey="klijent.idk"/>
    <display:column property="idk" media="csv excel xml pdf" titleKey="klijent.idk"/>
    <display:column property="adresa" sortable="true" titleKey="klijent.adresa"/>
    <display:column property="mesto" sortable="true" titleKey="klijent.mesto"/>
    <display:column property="naziv" sortable="true" titleKey="klijent.naziv"/>
    <display:column property="telefon" sortable="true" titleKey="klijent.telefon"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="klijentList.klijent"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="klijentList.klijents"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="klijentList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="klijentList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="klijentList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("klijentList");
</script>
