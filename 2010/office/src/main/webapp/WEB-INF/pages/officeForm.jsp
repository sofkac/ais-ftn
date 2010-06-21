<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="officeDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='officeDetail.heading'/>"/>
</head>

<s:form id="officeForm" action="saveOffice" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="office.idoffice"/>
    </li>
    <s:select key="office.client.idclient" list="clients" headerKey="-10" headerValue="--Select Client--" listKey="idclient" listValue="naziv"></s:select>
    <s:textfield key="office.adresa" required="true" maxlength="45" cssClass="text medium"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:textfield key="office.grad" required="true" maxlength="45" cssClass="text medium"/>
    <!-- <s:textfield key="office.rvremeOd" required="false" cssClass="text medium"/> -->
    <!-- <s:textfield key="office.rvremeDo" required="false" cssClass="text medium"/> -->

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty office.idoffice}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Office')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("officeForm"));
</script>
