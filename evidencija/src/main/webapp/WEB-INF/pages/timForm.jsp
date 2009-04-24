<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="timDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='timDetail.heading'/>"/>
</head>

<s:form id="timForm" action="saveTim" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="tim.idt"/>
    </li>
    <s:textfield key="tim.nazt" required="true" maxlength="30" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty tim.idt}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Tim')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("timForm"));
</script>
