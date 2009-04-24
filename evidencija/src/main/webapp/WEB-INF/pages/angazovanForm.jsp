<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="angazovanDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='angazovanDetail.heading'/>"/>
</head>

<s:form id="angazovanForm" action="saveAngazovan" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="angazovan.ida"/>
    </li>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select name="angazovan.pripada.id" list="pripadaList" listKey="id" listValue="id"></s:select>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select name="angazovan.zaposleni.id" list="zaposleniList" listKey="id" listValue="id"></s:select>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty angazovan.ida}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Angazovan')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("angazovanForm"));
</script>
