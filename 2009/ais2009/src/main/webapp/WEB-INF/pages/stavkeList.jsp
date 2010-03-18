<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="stavkeList.title"/></title>
    <meta name="heading" content="<fmt:message key='stavkeList.heading'/>"/>
    <meta name="menu" content="ApplicationMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editStavke.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="stavkes" class="table" requestURI="" id="stavkeList" export="true" pagesize="25">
    <display:column property="ids" sortable="true" href="editStavke.html" media="html"
        paramId="ids" paramProperty="ids" titleKey="stavke.ids"/>
    <display:column property="ids" media="csv excel xml pdf" titleKey="stavke.ids"/>
    <display:column property="kolicina" sortable="true" titleKey="stavke.kolicina"/>
    <display:column property="napomena" sortable="true" titleKey="stavke.napomena"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="stavkeList.stavke"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="stavkeList.stavkes"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="stavkeList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="stavkeList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="stavkeList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("stavkeList");
</script>
