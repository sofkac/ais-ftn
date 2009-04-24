<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="zanimanjeDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='zanimanjeDetail.heading'/>"/>
</head>

<s:form id="zanimanjeForm" action="saveZanimanje" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="zanimanje.idzan"/>
    </li>
    <s:textfield key="zanimanje.nazzan" required="true" maxlength="30" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty zanimanje.idzan}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Zanimanje')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("zanimanjeForm"));
</script>
