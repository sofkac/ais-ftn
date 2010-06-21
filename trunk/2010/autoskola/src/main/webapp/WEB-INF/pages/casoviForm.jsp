<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="casoviDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='casoviDetail.heading'/>"/>
</head>

<s:form id="casoviForm" action="saveCasovi" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="casovi.idCas"/>
    </li>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <s:select key="casovi.osobljeFK" name="casovi.osobljeFK.osobljeID" list="osobljes" listKey="osobljeID" listValue="prezime"></s:select>
    <s:select key="casovi.voziloFK" name="casovi.voziloFK.voziloID" list="vozilos" listKey="voziloID" listValue="regBroj"></s:select>
    <s:select key="casovi.polaznikFK" name="casovi.polaznikFK.idpolaznik" list="polazniks" listKey="idpolaznik" listValue="prezime"></s:select>

    <s:textfield key="casovi.datumCasa" required="true" maxlength="10" cssClass="text medium"/>
    <s:textfield key="casovi.detalji" required="false" maxlength="200" cssClass="text medium"/>
    <s:textfield key="casovi.status" required="true" maxlength="10" cssClass="text medium"/>
    
    <s:textfield key="casovi.vremeOd" required="true" maxlength="8" cssClass="text medium" />
    <s:textfield key="casovi.vremeDo" required="true" maxlength="8" cssClass="text medium" />
    <s:textfield key="casovi.vrsta" required="true" maxlength="10" cssClass="text medium"/>

    <li class="buttonBar bottom">
        <s:submit cssClass="button" method="save" key="button.save" theme="simple"/>
        <c:if test="${not empty casovi.idCas}">
            <s:submit cssClass="button" method="delete" key="button.delete"
                onclick="return confirmDelete('Casovi')" theme="simple"/>
        </c:if>
        <s:submit cssClass="button" method="cancel" key="button.cancel" theme="simple"/>
    </li>
</s:form>

<script type="text/javascript">
    Form.focusFirstElement($("casoviForm"));
</script>
