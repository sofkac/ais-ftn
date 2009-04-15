<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="stavkeDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='stavkeDetail.heading'/>"/>
</head>

<s:form id="stavkeForm" action="saveStavke" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="stavke.ids"/>
    </li>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select name="stavke.faktura.id" list="fakturaList" listKey="id" listValue="id"></s:select>
    <s:textfield key="stavke.kolicina" required="true" maxlength="255" cssClass="text medium"/>
    <s:textfield key="stavke.napomena" required="false" maxlength="15" cssClass="text medium"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select name="stavke.roba.id" list="robaList" listKey="id" listValue="id"></s:select>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty stavke.ids}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Stavke')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("stavkeForm"));
</script>
