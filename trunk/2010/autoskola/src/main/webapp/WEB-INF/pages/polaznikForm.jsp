<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="polaznikDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='polaznikDetail.heading'/>"/>
</head>

<s:form id="polaznikForm" action="savePolaznik" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="polaznik.idpolaznik"/>
    </li>
    <s:textfield key="polaznik.adresa" required="false" maxlength="50" cssClass="text medium"/>
    <s:textfield key="polaznik.datumProjave" required="false" maxlength="10" cssClass="text medium"/>
    <s:textfield key="polaznik.datumRodj" required="false" maxlength="10" cssClass="text medium"/>
    <s:textfield key="polaznik.detalji" required="false" maxlength="200" cssClass="text medium"/>
    <s:textfield key="polaznik.grad" required="false" maxlength="45" cssClass="text medium"/>
    <s:textfield key="polaznik.ime" required="true" maxlength="20" cssClass="text medium"/>
    <s:textfield key="polaznik.postBroj" required="false" maxlength="255" cssClass="text medium"/>
    <s:textfield key="polaznik.prezime" required="true" maxlength="25" cssClass="text medium"/>
    <s:textfield key="polaznik.telefon" required="false" maxlength="15" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty polaznik.idpolaznik}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Polaznik')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("polaznikForm"));
</script>
