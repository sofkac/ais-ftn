<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="robaDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='robaDetail.heading'/>"/>
</head>

<s:form id="robaForm" action="saveRoba" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="roba.idr"/>
    </li>
    <s:textfield key="roba.jm" required="true" maxlength="10" cssClass="text medium"/>
    <s:textfield key="roba.kolicina" required="true" maxlength="255" cssClass="text medium"/>
    <s:textfield key="roba.napomena" required="false" maxlength="100" cssClass="text medium"/>
    <s:textfield key="roba.naziv" required="true" maxlength="50" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty roba.idr}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Roba')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("robaForm"));
</script>
