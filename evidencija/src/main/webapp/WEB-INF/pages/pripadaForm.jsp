<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="pripadaDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='pripadaDetail.heading'/>"/>
</head>

<s:form id="pripadaForm" action="savePripada" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="pripada.idp"/>
    </li>
    <s:textfield key="pripada.brlj" required="true" maxlength="255" cssClass="text medium"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select name="pripada.tim.id" list="timList" listKey="id" listValue="id"></s:select>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select name="pripada.zanimanje.id" list="zanimanjeList" listKey="id" listValue="id"></s:select>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty pripada.idp}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Pripada')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("pripadaForm"));
</script>
