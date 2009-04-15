<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="fakturaDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='fakturaDetail.heading'/>"/>
</head>

<s:form id="fakturaForm" action="saveFaktura" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="faktura.idf"/>
    </li>
    <s:textfield key="faktura.datum" required="true" cssClass="text medium"/>
    <s:textfield key="faktura.iznos" required="false" maxlength="255" cssClass="text medium"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select name="faktura.klijent.id" list="klijentList" listKey="id" listValue="id"></s:select>
    <s:textfield key="faktura.napomena" required="false" maxlength="200" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty faktura.idf}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Faktura')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("fakturaForm"));
</script>
