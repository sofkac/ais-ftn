<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="polaznikList.title"/></title>
    <meta name="heading" content="<fmt:message key='polaznikList.heading'/>"/>
    <meta name="menu" content="PolaznikMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editPolaznik.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" class="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="polazniks" class="table" requestURI="" id="polaznikList" export="true" pagesize="25">
    <display:column property="idpolaznik" sortable="true" href="editPolaznik.html" media="html"
        paramId="idpolaznik" paramProperty="idpolaznik" titleKey="polaznik.idpolaznik"/>
    <display:column property="idpolaznik" media="csv excel xml pdf" titleKey="polaznik.idpolaznik"/>
    <display:column property="adresa" sortable="true" titleKey="polaznik.adresa"/>
    <display:column property="datumProjave" sortable="true" titleKey="polaznik.datumProjave"/>
    <display:column property="datumRodj" sortable="true" titleKey="polaznik.datumRodj"/>
    <display:column property="detalji" sortable="true" titleKey="polaznik.detalji"/>
    <display:column property="grad" sortable="true" titleKey="polaznik.grad"/>
    <display:column property="ime" sortable="true" titleKey="polaznik.ime"/>
    <display:column property="postBroj" sortable="true" titleKey="polaznik.postBroj"/>
    <display:column property="prezime" sortable="true" titleKey="polaznik.prezime"/>
    <display:column property="telefon" sortable="true" titleKey="polaznik.telefon"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="polaznikList.polaznik"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="polaznikList.polazniks"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="polaznikList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="polaznikList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="polaznikList.title"/>.pdf</display:setProperty>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("polaznikList");
</script>
