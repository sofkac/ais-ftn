<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="stavkeDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='stavkeDetail.heading'/>"/>
</head>

<s:form id="stavkeForm" action="saveStavke" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="stavke.ids"/>
    </li>
    <s:select key="stavke.faktura" name="stavke.faktura.idf" list="fakturas" headerKey="-10" headerValue="--Select Faktura--" listKey="idf" listValue="idf+' '+klijent.naziv"></s:select>
    <s:select key="stavke.roba" name="stavke.roba.idr" headerKey="-10" headerValue="--Select Roba--" list="robas" listKey="idr" listValue="naziv+' | kolicina: ' +kolicina"></s:select>
    <s:textfield key="stavke.kolicina" required="true" maxlength="255" cssClass="text medium"/>
    <s:textfield key="stavke.napomena" required="false" maxlength="15" cssClass="text medium"/>

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
