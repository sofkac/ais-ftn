<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="voziloDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='voziloDetail.heading'/>"/>
</head>

<s:form id="voziloForm" action="saveVozilo" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="vozilo.voziloID"/>
    </li>
    <s:textfield key="vozilo.detalji" required="false" maxlength="65535" cssClass="text medium"/>
    <s:textfield key="vozilo.godiste" required="false" maxlength="255" cssClass="text medium"/>
    <s:textfield key="vozilo.marka" required="true" maxlength="45" cssClass="text medium"/>
    <s:textfield key="vozilo.model" required="true" maxlength="45" cssClass="text medium"/>
    <s:textfield key="vozilo.regBroj" required="true" maxlength="10" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty vozilo.voziloID}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Vozilo')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("voziloForm"));
</script>
