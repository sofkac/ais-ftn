<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="placanjaDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='placanjaDetail.heading'/>"/>
</head>

<s:form id="placanjaForm" action="savePlacanja" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="placanja.idplacanje"/>
    </li>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select key="placanja.polaznikFK" name="placanja.polaznikFK.idpolaznik" list="polazniks" listKey="idpolaznik" listValue="ime"></s:select>
    <s:textfield key="placanja.date" required="true" maxlength="10" cssClass="text medium"/>
    <s:textfield key="placanja.detalji" required="false" maxlength="65535" cssClass="text medium"/>
    <s:textfield key="placanja.iznos" required="true" maxlength="255" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty placanja.idplacanje}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Placanja')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("placanjaForm"));
</script>
