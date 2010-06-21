<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="osobljeDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='osobljeDetail.heading'/>"/>
</head>

<s:form id="osobljeForm" action="saveOsoblje" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="osoblje.osobljeID"/>
    </li>
    <s:textfield key="osoblje.detalji" required="false" maxlength="65535" cssClass="text medium"/>
    <s:textfield key="osoblje.ime" required="true" maxlength="20" cssClass="text medium"/>
    <s:textfield key="osoblje.prezime" required="true" maxlength="25" cssClass="text medium"/>
    <s:textfield key="osoblje.telefon" required="false" maxlength="15" cssClass="text medium"/>
    <s:textfield key="osoblje.vrsta" required="true" maxlength="255" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty osoblje.osobljeID}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Osoblje')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("osobljeForm"));
</script>
