<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="zaposleniList.title"/></title>
    <meta name="heading" content="<fmt:message key='zaposleniList.heading'/>"/>
    <meta name="menu" content="ZaposleniMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editZaposleni.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="zaposlenies" class="table" requestURI="" id="zaposleniList" export="true" pagesize="25">
    <display:column property="idz" sortable="true" href="editZaposleni.html" media="html"
        paramId="idz" paramProperty="idz" titleKey="zaposleni.idz"/>
    <display:column property="idz" media="csv excel xml pdf" titleKey="zaposleni.idz"/>
    <display:column property="adrz" sortable="true" titleKey="zaposleni.adrz"/>
    <display:column property="gradz" sortable="true" titleKey="zaposleni.gradz"/>
    <display:column property="imez" sortable="true" titleKey="zaposleni.imez"/>
    <display:column property="jmbz" sortable="true" titleKey="zaposleni.jmbz"/>
    <display:column property="mailz" sortable="true" titleKey="zaposleni.mailz"/>
    <display:column property="przz" sortable="true" titleKey="zaposleni.przz"/>
    <display:column property="telz" sortable="true" titleKey="zaposleni.telz"/>
    <display:column property="zipz" sortable="true" titleKey="zaposleni.zipz"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="zaposleniList.zaposleni"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="zaposleniList.zaposlenies"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="zaposleniList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="zaposleniList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="zaposleniList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("zaposleniList");
</script>
