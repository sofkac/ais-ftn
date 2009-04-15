<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="klijentDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='klijentDetail.heading'/>"/>
</head>

<s:form id="klijentForm" action="saveKlijent" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="klijent.idk"/>
    </li>
    <s:textfield key="klijent.adresa" required="true" maxlength="45" cssClass="text medium"/>
    <s:textfield key="klijent.mesto" required="true" maxlength="25" cssClass="text medium"/>
    <s:textfield key="klijent.naziv" required="true" maxlength="45" cssClass="text medium"/>
    <s:textfield key="klijent.telefon" required="false" maxlength="15" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty klijent.idk}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Klijent')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("klijentForm"));
</script>
