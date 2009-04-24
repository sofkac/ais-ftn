<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="angazovanList.title"/></title>
    <meta name="heading" content="<fmt:message key='angazovanList.heading'/>"/>
    <meta name="menu" content="AngazovanMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editAngazovan.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="angazovans" class="table" requestURI="" id="angazovanList" export="true" pagesize="25">
    <display:column property="ida" sortable="true" href="editAngazovan.html" media="html"
        paramId="ida" paramProperty="ida" titleKey="angazovan.ida"/>
    <display:column property="ida" media="csv excel xml pdf" titleKey="angazovan.ida"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="angazovanList.angazovan"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="angazovanList.angazovans"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="angazovanList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="angazovanList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="angazovanList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("angazovanList");
</script>
