<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="timList.title"/></title>
    <meta name="heading" content="<fmt:message key='timList.heading'/>"/>
    <meta name="menu" content="TimMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editTim.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="tims" class="table" requestURI="" id="timList" export="true" pagesize="25">
    <display:column property="idt" sortable="true" href="editTim.html" media="html"
        paramId="idt" paramProperty="idt" titleKey="tim.idt"/>
    <display:column property="idt" media="csv excel xml pdf" titleKey="tim.idt"/>
    <display:column property="nazt" sortable="true" titleKey="tim.nazt"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="timList.tim"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="timList.tims"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="timList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="timList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="timList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("timList");
</script>
