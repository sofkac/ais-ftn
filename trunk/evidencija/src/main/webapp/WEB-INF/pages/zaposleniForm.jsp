<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="zaposleniDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='zaposleniDetail.heading'/>"/>
</head>

<s:form id="zaposleniForm" action="saveZaposleni" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="zaposleni.idz"/>
    </li>
    <s:textfield key="zaposleni.adrz" required="true" maxlength="50" cssClass="text medium"/>
    <s:textfield key="zaposleni.gradz" required="true" maxlength="20" cssClass="text medium"/>
    <s:textfield key="zaposleni.imez" required="true" maxlength="20" cssClass="text medium"/>
    <s:textfield key="zaposleni.jmbz" required="true" maxlength="13" cssClass="text medium"/>
    <s:textfield key="zaposleni.mailz" required="true" maxlength="50" cssClass="text medium"/>
    <s:textfield key="zaposleni.przz" required="true" maxlength="20" cssClass="text medium"/>
    <s:textfield key="zaposleni.telz" required="true" maxlength="15" cssClass="text medium"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select name="zaposleni.zanimanje.id" list="zanimanjeList" listKey="id" listValue="id"></s:select>
    <s:textfield key="zaposleni.zipz" required="true" maxlength="10" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty zaposleni.idz}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Zaposleni')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("zaposleniForm"));
</script>
