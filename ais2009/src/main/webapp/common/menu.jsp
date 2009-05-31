<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
<ul id="primary-nav" class="menuList">
    <li class="pad">&nbsp;</li>
    <c:if test="${empty pageContext.request.remoteUser}"><li><a href="<c:url value="/login.jsp"/>" class="current"><fmt:message key="login.title"/></a></li></c:if>
    <menu:displayMenu name="MainMenu"/>
    <menu:displayMenu name="UserMenu"/>
    <menu:displayMenu name="ApplicationMenu"/>
    <menu:displayMenu name="AdminMenu"/>
    <menu:displayMenu name="WebServices"/>
    <menu:displayMenu name="Logout"/>
    <!--Stavke-START-->
<!--    <menu:displayMenu name="StavkeMenu"/>-->
    <!--Stavke-END-->
    <!--Faktura-START-->
<!--    <menu:displayMenu name="FakturaMenu"/>-->
    <!--Faktura-END-->
    <!--Klijent-START-->
<!--    <menu:displayMenu name="KlijentMenu"/>-->
    <!--Klijent-END-->
    <!--Roba-START-->
<!--    <menu:displayMenu name="RobaMenu"/>-->
    <!--Roba-END-->
</ul>
</menu:useMenuDisplayer>