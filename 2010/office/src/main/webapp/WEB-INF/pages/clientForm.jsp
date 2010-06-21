<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="clientDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='clientDetail.heading'/>"/>
</head>

<s:form id="clientForm" action="saveClient" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="client.idclient"/>
    </li>
    <s:textfield key="client.naziv" required="true" maxlength="25" cssClass="text medium"/>
    <s:textfield key="client.datumOsnivanja" required="true" cssClass="text medium"/>
    <s:textfield key="client.opis" required="false" maxlength="250" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty client.idclient}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Client')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("clientForm"));
</script>
