<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="zanimanjeList.title"/></title>
    <meta name="heading" content="<fmt:message key='zanimanjeList.heading'/>"/>
    <meta name="menu" content="ZanimanjeMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editZanimanje.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="zanimanjes" class="table" requestURI="" id="zanimanjeList" export="true" pagesize="25">
    <display:column property="idzan" sortable="true" href="editZanimanje.html" media="html"
        paramId="idzan" paramProperty="idzan" titleKey="zanimanje.idzan"/>
    <display:column property="idzan" media="csv excel xml pdf" titleKey="zanimanje.idzan"/>
    <display:column property="nazzan" sortable="true" titleKey="zanimanje.nazzan"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="zanimanjeList.zanimanje"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="zanimanjeList.zanimanjes"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="zanimanjeList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="zanimanjeList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="zanimanjeList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("zanimanjeList");
</script>
