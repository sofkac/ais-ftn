<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="voziloList.title"/></title>
    <meta name="heading" content="<fmt:message key='voziloList.heading'/>"/>
    <meta name="menu" content="VoziloMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editVozilo.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="voziloes" class="table" requestURI="" id="voziloList" export="true" pagesize="25">
    <display:column property="voziloID" sortable="true" href="editVozilo.html" media="html"
        paramId="voziloID" paramProperty="voziloID" titleKey="vozilo.voziloID"/>
    <display:column property="voziloID" media="csv excel xml pdf" titleKey="vozilo.voziloID"/>
    <display:column property="detalji" sortable="true" titleKey="vozilo.detalji"/>
    <display:column property="godiste" sortable="true" titleKey="vozilo.godiste"/>
    <display:column property="marka" sortable="true" titleKey="vozilo.marka"/>
    <display:column property="model" sortable="true" titleKey="vozilo.model"/>
    <display:column property="regBroj" sortable="true" titleKey="vozilo.regBroj"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="voziloList.vozilo"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="voziloList.voziloes"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="voziloList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="voziloList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="voziloList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("voziloList");
</script>
