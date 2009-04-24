<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="pripadaList.title"/></title>
    <meta name="heading" content="<fmt:message key='pripadaList.heading'/>"/>
    <meta name="menu" content="PripadaMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editPripada.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="pripadas" class="table" requestURI="" id="pripadaList" export="true" pagesize="25">
    <display:column property="idp" sortable="true" href="editPripada.html" media="html"
        paramId="idp" paramProperty="idp" titleKey="pripada.idp"/>
    <display:column property="idp" media="csv excel xml pdf" titleKey="pripada.idp"/>
    <display:column property="brlj" sortable="true" titleKey="pripada.brlj"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="pripadaList.pripada"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="pripadaList.pripadas"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="pripadaList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="pripadaList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="pripadaList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("pripadaList");
</script>
