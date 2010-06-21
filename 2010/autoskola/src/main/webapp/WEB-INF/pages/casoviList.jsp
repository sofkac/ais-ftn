<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="casoviList.title"/></title>
    <meta name="heading" content="<fmt:message key='casoviList.heading'/>"/>
    <meta name="menu" content="CasoviMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editCasovi.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="casovies" class="table" requestURI="" id="casoviList" export="true" pagesize="25">
    <display:column property="idCas" sortable="true" href="editCasovi.html" media="html"
        paramId="idCas" paramProperty="idCas" titleKey="casovi.idCas"/>
    <display:column property="idCas" media="csv excel xml pdf" titleKey="casovi.idCas"/>
    <display:column property="datumCasa" sortable="true" titleKey="casovi.datumCasa"/>
    <display:column property="detalji" sortable="true" titleKey="casovi.detalji"/>
    <display:column property="status" sortable="true" titleKey="casovi.status"/>
    <display:column property="vremeOd" sortable="true" titleKey="casovi.vremeOd"/>
    <display:column property="vremeDo" sortable="true" titleKey="casovi.vremeDo"/>
    <display:column property="vrsta" sortable="true" titleKey="casovi.vrsta"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="casoviList.casovi"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="casoviList.casovies"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="casoviList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="casoviList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="casoviList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("casoviList");
</script>
